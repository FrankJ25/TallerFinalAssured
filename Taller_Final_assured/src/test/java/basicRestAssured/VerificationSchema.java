package basicRestAssured;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
/*
* https://json-schema.org/draft-04/schema#
* https://www.liquid-technologies.com/online-json-to-schema-converter
 * */
public class VerificationSchema {

    @Test
    public void verifyCreateProjectWithVerification(){

        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();


        JSONObject body = new JSONObject();
        body.put("Content","SCHEMA");
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
                .body("Content",equalTo("SCHEMA"))
                .body("Icon",equalTo(8))
                .body(matchesJsonSchemaInClasspath("createSchema2.json").using(jsonSchemaFactory));
    }


}
