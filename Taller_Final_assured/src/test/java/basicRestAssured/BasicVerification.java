package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicVerification {

    @Test
    public void verifyCreateProjectWithVerification(){

        JSONObject body = new JSONObject();
        body.put("Content","JsonObject");
        body.put("Icon",8);

        given()
                .auth()
                .preemptive()
                .basic("jbapi@jbapi.com","12345")
                .body(body.toString())
                .log()
                .all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("JsonObject"))
                .body("Icon",equalTo(8));
    }

    @Test
    public void verifyCreateProjectExtractValue(){

        JSONObject body = new JSONObject();
        body.put("Content","JsonObject");
        body.put("Icon",8);

        Response response=given()
                                    .auth()
                                    .preemptive()
                                    .basic("jbapi@jbapi.com","12345")
                                    .body(body.toString())
                                    .log()
                                    .all()
                            .when()
                                    .post("https://todo.ly/api/projects.json");
        response.then()
                    .log()
                    .all()
                    .statusCode(200)
                    .body("Content",equalTo("JsonObject"))
                    .body("Icon",equalTo(8));

        String nameProj = response.then().extract().path("Content");

        System.out.println("INFO > nombre de project extraido: [ "+nameProj+" ]");
    }
}
