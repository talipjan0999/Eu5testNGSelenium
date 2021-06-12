package Apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetRequest {

   String  HRURL="http://100.25.34.235:1000/ords/hr/regions";
    @Test
    public void test1(){

        Response response = RestAssured.get(HRURL);
        System.out.println(response.statusCode());
       // System.out.println(response.body().asString());
        System.out.println(response.prettyPrint());


    }
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(HRURL);

        //verify response status code is 200
        Assert.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        System.out.println("res = " + response.contentType());
        Assert.assertEquals(response.contentType(),"application/xml");

    }

    @Test
    public void test3(){
        RestAssured.given().accept(ContentType.JSON)
                .when().get(HRURL).then()
                .assertThat().statusCode(200)
                .and().contentType("application/json");





    }
   /* Given accept type is json
    When user sends get request to regions/2
    Then response status code must be 200
    and body is json format
    and response body contains Americas
     */

    @Test
    public void test4(){
        Response response =RestAssured. given().accept(ContentType.JSON)
                .when().get(HRURL+ "/2");
        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //verify content type
        Assert.assertEquals(response.contentType(),"application/json");

        //verify body includes Americas
        Assert.assertTrue(response.body().asString().contains("Americas"));


    }






}