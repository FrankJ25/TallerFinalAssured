Feature: Login

  Scenario Outline: Como un usuario Quiero..

    Given tengo acceso a <app>
    When yo ingreso mi usuario: "<user>"
    And yo ingreso mi password: <pwd>
    And hago click en el boton login
    Then deberia ingresar a la app

    Examples:
      | app       | user     | pwd       |
      | facebook  | eynar    | 12345     |
      | whatsapp  | 70333333 | 54321     |
      | instagram | jose     | jose12345 |


