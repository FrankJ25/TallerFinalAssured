Feature: Project

  @Clean
  Scenario: as a user i want to create, update, read and delete the project so having the control on this


    Given I have access to Todo.ly API
    * I get the token to use in the next request
    When I send a POST request /api/projects.json with body
    """
      {
        "Content":"cleanCucumber",
        "Icon" : 8
      }
    """
    Then the response code should be 200
    And the response body should be
    """
    {
        "Id": "IGNORE",
        "Content": "cleanCucumber",
        "ItemsCount": 0,
        "Icon": 8,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [

        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    And I save the "Id" in the variable: "ID_PROJ"
    When I send a PUT request /api/projects/ID_PROJ.json with body
    """
     {
        "Content":"cleanUpdate",
        "Icon" : 7
      }
    """
    Then the response code should be 200
    And the value of "Content" should be "cleanUpdate"
    When I send a GET request /api/projects/ID_PROJ.json with body
    """
    """
    Then the response code should be 200
    And the response body should be
     """
    {
        "Id": ID_PROJ,
        "Content": "cleanUpdate",
        "ItemsCount": 0,
        "Icon": 7,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [

        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """

    When I send a DELETE request /api/projects/ID_PROJ.json with body
    """
    """
    Then the response code should be 200
    And the response body should be
     """
    {
        "Id": "IGNORE",
        "Content": "cleanUpdate",
        "ItemsCount": 0,
        "Icon": 7,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [

        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": true,
        "SyncClientCreationId": null
    }
    """