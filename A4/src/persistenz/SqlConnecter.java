// credits to http://www.vogella.com/articles/MySQLJava/article.html
package persistenz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class SqlConnecter {

  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private PreparedStatement preparedStatement = null;

  public SqlConnecter() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.connect = DriverManager
          .getConnection("jdbc:mysql://localhost/test?"
              + "user=kbrusch&password=");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public void readFromDB(String name, String table,String identifier) throws Exception {
    try {

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query

      
      // writeMetaData(resultSet)
      //query builder
      String query = "select * from " + table
          + " where "+identifier +" = ".concat("'" + name + "'");
      // print query for debugging
      System.out.println(query);
      
      resultSet = statement.executeQuery(query);
      
      writeResultSet(resultSet);
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }
  }

  // abstact the gast away
  // give list of parameters not specific ones

  public void insertIntoDB(String table, ArrayList<String> list)
      throws Exception {
    try {

      if (table == "gast") {

        preparedStatement = connect
            .prepareStatement("insert into gast values(default, ?,?,?);");
        preparedStatement.setString(1, list.get(0));
        preparedStatement.setString(2, list.get(1));
        preparedStatement.setBoolean(3, false);

        preparedStatement.executeUpdate();
      }
      //construction going on here
      if (table == "reservierung") {

        preparedStatement = connect
            .prepareStatement("insert into gast values(default, ?;");
        preparedStatement.setString(1, list.get(0));

        preparedStatement.executeUpdate();
      }
      //construction going on here
      if (table == "zusastzleistung") {

        preparedStatement = connect
            .prepareStatement("insert into gast values(default, ?;");
        preparedStatement.setString(1, list.get(0));

        preparedStatement.executeUpdate();

      }
    } catch (Exception e) {
      throw e;
    } finally {
      close();

    }
  }

  public void updateEntryFromDB(String table, String identifier ,ArrayList<String> list)
      throws Exception {
    try {

      if (table == "gast") {
        String updateString = prepareUpdateString(list); 
        preparedStatement = connect
            .prepareStatement("update gast set "+updateString+" where name"+"'"+identifier+"'");
        preparedStatement.setString(1, "");

        preparedStatement.executeUpdate();
      }
      //construction going on here
      if (table == "reservierung") {
        preparedStatement = connect
            .prepareStatement("update reservierung set  = where name="
                + identifier + ";");
        preparedStatement.setString(1, "");

        preparedStatement.executeUpdate();
      }
      //construction going on here
      if (table == "zusastzleistung") {
        preparedStatement = connect
            .prepareStatement("update zusatzleistung set  = where name="
                + identifier + ";");
        preparedStatement.setString(1, "");

        preparedStatement.executeUpdate();

      }

    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }
  }

  private String prepareUpdateString(ArrayList<String> list) {
    
    StringBuilder result = new StringBuilder();
    for (String object : list) {
      if (object.length() == 0) {
        result.append("");
      } else {
        if(object == "")
        result.append(",?");
      }
    }
    return result.toString();
  }

  public void removeFromDB(String name, String table) throws Exception {
    try {
      preparedStatement = connect.prepareStatement("delete from " + table
          + " where name = ? ;");
      preparedStatement.setString(1, name);

      preparedStatement.executeUpdate();

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
    // Now get some metadata from the database
    // Result set get the result of the SQL query

    System.out.println("The columns in the table are: ");

    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
      System.out.println("Column " + i + " "
          + resultSet.getMetaData().getColumnName(i));
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