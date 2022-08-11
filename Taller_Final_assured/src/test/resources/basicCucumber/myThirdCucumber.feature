@Regression
Feature: Login

  Background:
    Given tengo acceso a whatsapp facebook instagram

  @Regression @SmokeTest @Priority1
  Scenario: Como un usuario Quiero..
  # este es un comentario
    When yo ingreso mi usuario: "eynar123"
    And yo ingreso mi password: abc123
    And hago click en el boton login
    Then deberia ingresar a la app

  Scenario: Como un usuario Quiero..

    When yo ingreso mi usuario: "eynar123"
    And hago click en el boton login
    Then no deberia ingresar a la app

  Scenario: Como un usuario Quiero..

    And yo ingreso mi password: abc123
    And hago click en el boton login
    Then no deberia ingresar a la app