package Apitest;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

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
import utilities.ConfigurationReader;

import java.util.List;
public class hamcrestMatchersApiTest {
    /*
    given accept type is Json
    And path param id is 15
    When user sends a get request to spartans/{id}
    Then status code is 200
    And content type is Json
    And json data has following
        "id": 15,
        "name": "Meta",
        "gender": "Female",
        "phone": 1938695106
     */


    @Test
    public void OneSpartanwithHamcrest(){
        given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .and().auth().basic("admin", "admin").
                when().get("http://100.25.34.235:8000/api/spartans/{id}")
                .then().statusCode(200)
                .assertThat().contentType("application/json;charset=UTF-8")
                .and().assertThat().body("id", equalTo(15),
                "name",equalTo("Meta"),
                "gender",equalTo("Female"),
                "phone",equalTo(1938695106));



    }

    @Test
    public void teacherData(){
        given().accept(ContentType.JSON)
                .pathParam("id",6884)
                .when().get("http://api.cybertektraining.com/teacher/{id}")
                .then().assertThat().statusCode(200)
                .and().contentType("application/json;charset=UTF-8")
                .and().body("teachers.firstName[0]",equalTo("Harold"),
                "teachers.lastName[0]",equalTo("Kim"),
                "teachers.gender[0]",equalTo("Male"));





        }




}