package basicRestAssured;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BasicRestAssured {
    /*
        given() --> configuration params/headers/body/auth
        when() --> configuracion url - method (get/put/post/etc)
        then() --> manipulacion respuesta (body/msg/code/headers)
               --> extraer datos  / verification
        log() --> internamete --> no necesitamos una libreria ext
     */

    @Test
    public void verifyCreateProject(){
            given()
                    .auth()
                    .preemptive()
                    .basic("jbapi@jbapi.com","12345")
                    .body("{\n" +
                            "  \"Content\":\"RESTAssured\",\n" +
                            "  \"Icon\" : 7\n" +
                            "}")
                    .log()
                    .all()
            .when()
                    .post("https://todo.ly/api/projects.json")
            .then()
                    .log()
                    .all();
    }


    @Test
    public void verifyCreateProjectWithExternalFile(){
        String filePath=new File("").getAbsolutePath()+"/src/test/resources/bodyCreateProject.json";

        given()
                .auth()
                .preemptive()
                .basic("jbapi@jbapi.com","12345")
                .body(new File(filePath))
                .log()
                .all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log()
                .all();
    }



    @Test
    public void verifyCreateProjectWithJSONObject(){

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
                .all();
    }

}
