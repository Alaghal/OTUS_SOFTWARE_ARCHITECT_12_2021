Feature: Test user controller

  Scenario: get users from controller
    Given we have contrell with api "/v1/users"
    When the client calls GET for api
    Then the client receives status code of 200
