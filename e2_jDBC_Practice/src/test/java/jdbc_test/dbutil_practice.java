package jdbc_test;

import org.testng.annotations.Test;
import utilities.DBUtilies;

import java.util.List;
import java.util.Map;

public class dbutil_practice {
    @Test
    public void test1(){
        DBUtilies.createConnection();

         List<Map<String, Object>>  querydata = DBUtilies.getQueryResultMap("SELECT *from department");
            for (Map<String,Object> row:querydata){
                System.out.println(row);
            }

        DBUtilies.destroy();
    }
    @Test
    public void test2(){

        DBUtilies.createConnection();

        Map<String, Object> rowMap = DBUtilies.getRowMap("select * from employees where employee_id =100");

        System.out.println(rowMap.toString());

        DBUtilies.destroy();


    }
}