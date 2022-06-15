package apiTestsOnLocal;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Put_Tests {



    @Test
    public void AssertUserCanUpdateCourses(){
        JSONObject request = new JSONObject();
        request.put("title","c++");
        request.put("Author","Sayed Aliu");
        request.put("subjectId",99);
        baseURI = "http://localhost:3000";
        given()
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/Courses2/1")
                .then()
                .statusCode(200)
                .log().all();

    }


}
