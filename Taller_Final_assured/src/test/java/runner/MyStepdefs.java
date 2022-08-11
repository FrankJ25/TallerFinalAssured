package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MyStepdefs {

    /*
    *  {} --> remplaza cualquier valor
    *  {string} --> remplaza cualquier cadena dentro de "VALOR VALOR"
    *  {word} ---> remplaza 1 palabra en nuestra oracion
    *  {int} ---> remplaza valores numericos enteros
    *  {float} ---> remplaza valores numerico flotantes
    *
    *  expresiones regulares
    * */


    @Given("tengo acceso a {}")
    public void tengoAccesoAFacebook(String nombreApp) {
    }

    @When("yo ingreso mi usuario: {string}")
    public void yoIngresoMiUsuarioEynar(String user) {
    }

    @And("yo ingreso mi password: {word}")
    public void yoIngresoMiPasswordAbc(String pwd) {
    }

    @And("hago click en el boton login")
    public void hagoClickEnElBotonLogin() {
    }

    @Then("deberia ingresar a la app")
    public void deberiaIngresarALaApp() {
    }

    @Then("no deberia ingresar a la app")
    public void noDeberiaIngresarALaApp() {
    }

    @Given("yo tengo una lista de usuarios")
    public void yoTengoUnaListaDeUsuarios(List<String> usuarios) {
        for (String user:usuarios
             ) {
            System.out.println("user: "+user);
        }


    }

    @When("verifico sus correos electronicos")
    public void verificoSusCorreosElectronicos(Map<String,String> emails) {
        for (String key: emails.keySet()
             ) {
            System.out.println("user: "+key+ " email: "+emails.get(key));
        }


    }

    @Then("envio el json a mi aplicacion")
    public void envioElJsonAMiAplicacion(String json) {
        System.out.println(json);
    }
}
