package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ha Tien Dat
 */
public class Data {

    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    private String str = "";//String Query SQL server CRUD (create read update delete)
    private boolean check = false;

    //
    public static Connection getConnection() {
        try {
            //add JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Student_Struts", "sa", "1234567");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<StudentFormBean> getAllStudent() {
        str = "SELECT * FROM tbl_Student";
        ArrayList<StudentFormBean> arr = new ArrayList<>();
        getConnection();
        //
        try {
            pstmt = conn.prepareStatement(str);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentFormBean st = new StudentFormBean();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setAge(rs.getInt("age"));
                st.setAddress(rs.getString("address"));
                st.setEmail(rs.getString("email"));
                st.setPhone(rs.getString("phone"));
                arr.add(st);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    public boolean addStudent(StudentFormBean st)
    {
        str="insert into tbl_Student(name,age,email,address,phone) values(?,?,?,?,?)";
        getConnection();
        try 
        {
            pstmt=conn.prepareStatement(str);
            pstmt.setString(1, st.getName());
            pstmt.setInt(2, st.getAge());
            pstmt.setString(3, st.getEmail());
            pstmt.setString(4, st.getAddress());
            pstmt.setString(5, st.getPhone());
            int executeUpdate = pstmt.executeUpdate();
            if (executeUpdate>0) 
            {
                check=true;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  check;
    }
    //Delete
    public boolean deleteStudent(int id)
    {
        str="delete from tbl_Student where id=?";
        getConnection();
        try 
        {
            pstmt=conn.prepareStatement(str);
            pstmt.setInt(1, id);
            int executeUpdate = pstmt.executeUpdate();
            if (executeUpdate>0) {
                check=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check;
    }
    //Edit Update
     public ArrayList<StudentFormBean> getStudentByID(int id) 
     {
        str = "SELECT * FROM tbl_Student where id=?";
        ArrayList<StudentFormBean> arr = new ArrayList<>();
        getConnection();
        //
        try {
            pstmt = conn.prepareStatement(str);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                StudentFormBean st = new StudentFormBean();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setAge(rs.getInt("age"));
                st.setAddress(rs.getString("address"));
                st.setEmail(rs.getString("email"));
                st.setPhone(rs.getString("phone"));
                arr.add(st);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
     //Update Student to database sQL
     public boolean updateStudent(StudentFormBean st)
    {
        str="update tbl_Student set name=?,age=?,email=?,address=?,phone=? where id=?";
        getConnection();
        try 
        {
            pstmt=conn.prepareStatement(str);
            pstmt.setString(1, st.getName());
            pstmt.setInt(2, st.getAge());
            pstmt.setString(3, st.getEmail());
            pstmt.setString(4, st.getAddress());
            pstmt.setString(5, st.getPhone());
            pstmt.setInt(6, st.getId());
            int executeUpdate = pstmt.executeUpdate();
            if (executeUpdate>0) 
            {
                check=true;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  check;
    }
    
//    public static void main(String[] args) {
//        //Test Connection - if return =1 OK
//        System.out.println(getConnection());
//    }

}
