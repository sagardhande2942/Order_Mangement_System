//STEP 1. Import required packages
package dbconnection;
import java.sql.*;

public class db {
   // JDBC driver name and database URL
   public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   public static final String DB_URL = "jdbc:mysql://instance-1.cnruxcy14rpo.us-east-1.rds.amazonaws.com/test";

   //  Database credentials
   public static final String USER = "master";
   public static final String PASS = "vishal29";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
//      
//      String sql = "INSERT INTO signup " +
//                   "VALUES (100, 'Zara', 'Ali')";
//      stmt.executeUpdate(sql);
//      sql = "INSERT INTO signup " +
//                   "VALUES (101, 'Mahnaz', 'Fatma')";
//      stmt.executeUpdate(sql);
      
      String sql = "select id, uname, pass from signup";
      ResultSet rs =  stmt.executeQuery(sql);
         while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         String username = rs.getString("uname");
         String password = rs.getString("pass");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", username: " + username);
         System.out.print(", password: " + password);
      }
      rs.close();

//      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample