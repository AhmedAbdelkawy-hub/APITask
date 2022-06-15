package apiTestsOnLocal;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Post_Tests {



    @Test
    public void AssertUserCanAddCourse(){
        JSONObject request = new JSONObject();
        request.put("title","java");
        request.put("Author","Sayed moham");
        request.put("subjectId",16);
        baseURI = "http://localhost:3000";
        given()
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/Courses2")
                .then()
                .statusCode(201)
                .log().all();

    }


}
