// credits to http://www.vogella.com/articles/MySQLJava/article.html
package persistenz;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SqlConnecter {

	 private Connection connect = null;
	 private Statement statement = null;
	 private ResultSet resultSet = null;
	
	 public void readDataBase() throws Exception {
		    try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost/test?"
		              + "user=kbrusch&password=");

		      // Statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      // Result set get the result of the SQL query
		      resultSet = statement
		          .executeQuery("select * from test.Gast");
		      writeResultSet(resultSet);
		      writeMetaData(resultSet);
		      
		    } catch (Exception e) {
		      throw e;
		    } finally {
		      close();
		    }
	
		   

		    } 
	 private void close() {
	        try {
	          if (resultSet != null) {
	            resultSet.close();
	          }

	          if (statement != null) {
	            statement.close();
	          }

	          if (connect != null) {
	            connect.close();
	          }
	        } catch (Exception e) {

	        }
	      }


	 private void writeMetaData(ResultSet resultSet) throws SQLException {
		    //   Now get some metadata from the database
		    // Result set get the result of the SQL query
		    
		    System.out.println("The columns in the table are: ");
		    
		    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
		      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		    }
		  }

		  private void writeResultSet(ResultSet resultSet) throws SQLException {
		    // ResultSet is initially before the first data set
		    while (resultSet.next()) {
		      // It is possible to get the columns via name
		      // also possible to get the columns via the column number
		      // which starts at 1
		      // e.g. resultSet.getSTring(2);
		      String nr = resultSet.getString("Nr");
		      String name = resultSet.getString("Name");
		      String email = resultSet.getString("Email");
		      
		      
		      System.out.println("Nummer: " + nr);
		      System.out.println("name: " + name);
		      System.out.println("email: " + email);
		    
		  }



		  }
}