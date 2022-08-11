Feature: Login
  Scenario: Login

    Given yo tengo una lista de usuarios
         |eynar1|
         |eynar2|
         |eynar3|
         |eynar4|
    When verifico sus correos electronicos
         |eynar1|eynar1@eynar1.com |
         |eynar2|eynar2@eynar2.com |
         |eynar3|eynar3@eynar3.com |
         |eynar4|eynar1@eynar4.com |
    Then envio el json a mi aplicacion
    """
       {
         "user1":"eynar1",
         "user2":"eynar2",
         "user3":"eynar3",
         "user4":"eynar4"
       }
    """
