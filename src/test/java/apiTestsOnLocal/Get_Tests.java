package apiTestsOnLocal;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Get_Tests {

    @Test
    public void UserCheckCanRetrieveAllCourses(){
        baseURI = "http://localhost:3000";
        given()
                .get("/Courses")
                .then()
                .statusCode(200).log().all();
    }
    @Test
    public void UserCanRetrievedCoursesDetails(){
        baseURI = "http://localhost:3000";
        given()

                .get("/Courses").
                then()
                .body("prim.title",hasItems("Selenium",null, "Appium","Robotium Course","java"))
                .body("prim.author",hasItems("moataz","moataz nabile",null, "ExecuteAutomation","ExecuteAutomat"));



    }

    @Test
    public void UserCanRetrievedCoursesIds(){
        baseURI = "http://localhost:3000";
        given()

                .get("/Courses/").
                then()
                .body("primary.id",hasItems("1","2","23","5","6"));
        // .body("author",equalTo("moataz"));


    }

    @Test
    public void CheckSchemaIsValidForCourses(){
        baseURI = "http://localhost:3000";
        given()
                .get("/Courses")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);


    }

}
