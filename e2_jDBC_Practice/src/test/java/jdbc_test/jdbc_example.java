package jdbc_test;

import org.testng.annotations.Test;

import java.sql.*;


    public class jdbc_example {

        String dbUrl ="jdbc:oracle:thin:@3.81.99.109:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        @Test
        public void test1() throws SQLException {

            //create the connection
            Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            //create statement object
            Statement statement = connection.createStatement();
            //run query and get the result in resultset object
            ResultSet resultSet = statement.executeQuery("select * from regions");

            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

            //=========================

            resultSet = statement.executeQuery("select * from departments");

            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

            //closing all connections
            resultSet.close();
            statement.close();
            connection.close();

        }

        @Test
        public void CountAndNavigate() throws SQLException {


            //create the connection
            Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            //create statement object
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //run query and get the result in resultset object
            ResultSet resultSet = statement.executeQuery("select * from departments");

            //how to find how many rows we have for the query
            //go to last row
            resultSet.last();
            //get the row count
            int rowCount = resultSet.getRow();

            System.out.println(rowCount);
            resultSet.beforeFirst();
            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

            //closing all connections
            resultSet.close();
            statement.close();
            connection.close();


        }


        @Test
        public  void metaData() throws SQLException{

             //create the connection
            Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            //create statement object
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //run query and get the result in resultset object
            ResultSet resultSet = statement.executeQuery("select * from countries");
            //relative database related data inside the metadata object

             DatabaseMetaData dbmetadata=connection.getMetaData();
            System.out.println("USER"+dbmetadata.getUserName());
            System.out.println("product name "+dbmetadata.getDatabaseProductName());
            System.out.println("version name"+dbmetadata.getDatabaseMajorVersion());
            System.out.println("Driver name "+dbmetadata.getDriverName());

          //get results metadata object
           ResultSetMetaData rsmetadata=resultSet.getMetaData();
            System.out.println("coloumn number"+rsmetadata.getColumnCount());
          //  System.out.println("coulumn name "+rsmetadata.getColumnName(4));
            //prin all the column names dynamicly
            int rsmetadatacoumlmn=rsmetadata.getColumnCount();
            for (int i =1;i<rsmetadatacoumlmn;i++){
                System.out.println(rsmetadata.getColumnName(i));
            }

            resultSet.close();
            statement.close();
            connection.close();

        }

    }