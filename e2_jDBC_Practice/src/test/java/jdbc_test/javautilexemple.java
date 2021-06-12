package jdbc_test;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;

public class javautilexemple {
    String dbUrl ="jdbc:oracle:thin:@3.81.99.109:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

        @Test
        public  void metaData() throws SQLException {

            //create the connection
            Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            //create statement object
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //run query and get the result in resultset object
            ResultSet resultSet = statement.executeQuery("select *from department");
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


           List<Map<String,Object>> Querydata=new ArrayList<>();

            Map<String ,Object> row1=new HashMap<>();
            row1.put("first_name","steven");
            row1.put("last_name","murat");
            row1.put("job_id","it-2900");
            row1.put("salary",800000);
            System.out.println(row1.toString());
            System.out.println(row1.get("first_name"));



            Map<String ,Object> row2=new HashMap<>();
            row2.put("first_name","murat");
            row2.put("last_name","osman");
            row2.put("job_id","math-2900");
            row2.put("salary",800000);
            System.out.println(row1.toString());
            System.out.println(row1.get("first_name"));



            Querydata.add(row1);
            Querydata.add(row2);
            System.out.println(Querydata.get(0).get("job_id"));
            resultSet.close();
            statement.close();
            connection.close();

        }


    @Test
    public  void metaData2() throws SQLException {

        //create the connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("Select first_name,last_name,salary,job_id\n" +"from employees\n" +
                                "where rownum<6");
        //relative database related data inside the metadata object



        List<Map<String,Object>> Querydata=new ArrayList<>();





        Map<String ,Object> row1=new HashMap<>();
        resultSet.next();
        row1.put(resultSet.getMetaData().getColumnName(1),resultSet.getString(1));
        row1.put(resultSet.getMetaData().getColumnName(2),resultSet.getString(2));
        row1.put(resultSet.getMetaData().getColumnName(3),resultSet.getString(3));
        row1.put(resultSet.getMetaData().getColumnName(4),resultSet.getString(4));
        System.out.println(row1.toString());
        System.out.println(row1.get("first_name"));



        Map<String ,Object> row2=new HashMap<>();
        resultSet.next();
        row2.put(resultSet.getMetaData().getColumnName(1),resultSet.getString(1));
        row2.put(resultSet.getMetaData().getColumnName(2),resultSet.getString(2));
        row2.put(resultSet.getMetaData().getColumnName(3),resultSet.getString(3));
        row2.put(resultSet.getMetaData().getColumnName(4),resultSet.getString(4));
        System.out.println(row1.toString());
        System.out.println(row1.get("first_name"));



        Querydata.add(row1);
        Querydata.add(row2);
        System.out.println(Querydata.get(0).get("job_id"));
        resultSet.close();
        statement.close();
        connection.close();

    }

}

