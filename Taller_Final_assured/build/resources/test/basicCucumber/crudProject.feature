Feature: Project
  Scenario: create update read delete project

    Given yo tengo acceso al API de Todo.ly
    When envio un request POST https://todo.ly/api/projects.json con el body
    """
    {
      "Content":"Cucumber",
      "Icon" : 8
    }
    """
    Then el codigo de respuesta deberia ser 200
    And el nombre del proyecto deberia ser "Cucumber"
    And recupero el id del projecto en IdProy

    When envio un request PUT https://todo.ly/api/projects/IdProy.json con el body
    """
    {
      "Content":"Cucumber2",
      "Icon" : 8
    }
    """
    Then el codigo de respuesta deberia ser 200
    And el nombre del proyecto deberia ser "Cucumber2"

    When envio un request GET https://todo.ly/api/projects/IdProy.json
    Then el codigo de respuesta deberia ser 200
    And el nombre del proyecto deberia ser "Cucumber2"

    When envio un request DELETE https://todo.ly/api/projects/IdProy.json
    Then el codigo de respuesta deberia ser 200
    And el nombre del proyecto deberia ser "Cucumber2"