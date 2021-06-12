package Apitest;
import com.sun.xml.xsom.impl.scd.Iterators;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpartanWithParameters {
    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = "http://3.81.99.109:8000";
    }

    /*
      Given accept type is Json
      And Id parameter value is 5
      When user sends GET request to /api/spartans/{id}
      Then response status code should be 200
      And response content-type: application/json;charset=UTF-8
      And "Blythe" should be in response payload
   */

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .and().pathParam("id",5)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        assertTrue(response.body().asString().contains("Blythe"));

    }


    @Test
    public void test3(){

        Response response =  given().accept(ContentType.JSON).and().auth().basic("admin","admin").and().
                queryParam("gender","female").
                queryParam("nameContains","e").when().get("/api/spartans/search");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        assertTrue(response.body().asString().contains("female"));
        assertTrue(response.body().asString().contains("Janette"));
    }
    @Test
    public void positiveTestWithQueryParamWithMaps(){
        //create a map and add parameters
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("gender","Female");
        queryMap.put("nameContains","e");

        Response response = given().accept(ContentType.JSON).and()
                .auth().basic("admin", "admin")
                .queryParams(queryMap)
                .when().get("/api/spartans/search");

        //response verification
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        //verify body contains
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));
    }

    @Test
    public void getAllSpartanWithPath(){

        Response response = given().auth().basic("admin", "admin")
                .when().get("/api/spartans");

        assertEquals(response.statusCode(),200);
        //verify content type
        System.out.println(response.getHeader("Content-Type"));
        assertEquals(response.getHeader("Content-Type"),"application/json;charset=UTF-8");


        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        String firstName = response.path("name[0]");
        System.out.println("firstName = " + firstName);

        String lastFirstName = response.path("name[-1]");
        System.out.println("lastFirstName = " + lastFirstName);

        //print all first names from spartans
        List<String> names = response.path("name");
        System.out.println(names);

        List<Object> phones = response.path("phone");

        for (Object phone : phones) {
            System.out.println(phone);
        }


    }



}



