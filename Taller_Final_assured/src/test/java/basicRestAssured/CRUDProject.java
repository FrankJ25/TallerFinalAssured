package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDProject {


    @Test
    public void verifyCRUDProject(){
        // create
        JSONObject body = new JSONObject();
        body.put("Content","crudProject");
        body.put("Icon",9);

        Response response = given()
                                .auth()
                                .preemptive()
                                .basic("jbapi@jbapi.com","12345")
                                .body(body.toString())
                                .log().all()
                            .when().post("https://todo.ly/api/projects.json");
        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("crudProject"))
                .body("Icon",equalTo(9));

        int idProj= response.then().extract().path("Id");

        // update
        body.put("Content","update");
        body.put("Icon",7);

        response = given()
                    .auth()
                    .preemptive()
                    .basic("jbapi@jbapi.com","12345")
                    .body(body.toString())
                    .log().all()
                .when().put("https://todo.ly/api/projects/"+idProj+".json");
        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("update"))
                .body("Icon",equalTo(7));
        // read

        response = given()
                    .auth()
                    .preemptive()
                    .basic("jbapi@jbapi.com","12345")
                    .log().all()
                .when().get("https://todo.ly/api/projects/"+idProj+".json");
        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("update"))
                .body("Icon",equalTo(7));


        // delete
        response = given()
                    .auth()
                    .preemptive()
                    .basic("jbapi@jbapi.com","12345")
                    .log().all()
                .when().delete("https://todo.ly/api/projects/"+idProj+".json");
        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("update"))
                .body("Icon",equalTo(7))
                .body("Deleted",equalTo(true));

    }


}
