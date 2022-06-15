package apiTestsOnLocal;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Patch_Tests {



    @Test
    public void AssertUserCanUpdatePartialDataCourses(){
        JSONObject request = new JSONObject();
        request.put("title","c#");
        baseURI = "http://localhost:3000";
        given()
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/Courses2/1")
                .then()
                .statusCode(200)
                .log().all();

    }


}
