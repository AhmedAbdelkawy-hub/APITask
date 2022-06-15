package apiTestsOnLocal;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Delete_Tests {



    @Test
    public void AssertUserCanDeleteSomeCourses(){
        baseURI = "http://localhost:3000";
        when()
                .delete("/Courses2/3")
                .then()
                .statusCode(200)
                .log().all();
    }

}
