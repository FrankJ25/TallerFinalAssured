package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepBasicRequest {
    Response response;
    int idProj;
    @Given("yo tengo acceso al API de Todo.ly")
    public void yoTengoAccesoAlAPIDeTodoLy() {
    }

    @When("envio un request POST {} con el body")
    public void envioUnRequestPOSTHttpsTodoLyApiProjectsJsonConElBody(String url,String body) {
        response = given()
                        .auth()
                        .preemptive()
                        .basic("jbapi@jbapi.com","12345")
                        .body(body)
                        .log().all()
                .when().post(url);
        response.then()
                .log().all();
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int expectedResult) {
        response.then()
                .statusCode(expectedResult);
    }

    @And("el nombre del proyecto deberia ser {string}")
    public void elNombreDelProyectoDeberiaSer(String expectedNameProj) {
        response.then()
                .body("Content",equalTo(expectedNameProj));
    }

    @And("recupero el id del projecto en IdProy")
    public void recuperoElIdDelProjectoEnIdProy() {
        idProj= response.then().extract().path("Id");
    }

    @When("envio un request PUT {} con el body")
    public void envioUnRequestPUTHttpsTodoLyApiProjectsIdProyJsonConElBody(String url,String body) {
        response = given()
                        .auth()
                        .preemptive()
                        .basic("jbapi@jbapi.com","12345")
                        .body(body)
                        .log().all()
                .when().put(url.replace("IdProy",idProj+""));
        response.then()
                .log().all();
    }

    @When("envio un request GET {}")
    public void envioUnRequestGETHttpsTodoLyApiProjectsIdProyJson(String url) {
        response = given()
                    .auth()
                    .preemptive()
                    .basic("jbapi@jbapi.com","12345")
                    .log().all()
                .when().get(url.replace("IdProy",idProj+""));
        response.then()
                .log().all();
    }

    @When("envio un request DELETE {}")
    public void envioUnRequestDELETEHttpsTodoLyApiProjectsIdProyJson(String url) {
        response = given()
                    .auth()
                    .preemptive()
                    .basic("jbapi@jbapi.com","12345")
                    .log().all()
                .when().delete(url.replace("IdProy",idProj+""));
        response.then()
                .log().all();
    }
}
