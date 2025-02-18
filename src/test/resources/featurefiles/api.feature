Feature: API Testing

  Scenario: Verify GET API
    Given baseurl
    When user send endpath "/inventory"
    When user send a GET request
    Then the  status code should be 200
    And the response should contain "available"

  Scenario: Verify Post API
    Given baseurl
    When user send endpath "/order"
    When user send a POST request
    Then the  status code should be 200
    And the response should contain "complete"

  Scenario: Verify Get with id API
    Given baseurl
    When user send endpath "/order/3"
    When user send a GET request 3
    Then the  status code should be 200
    And the response should contain "id"

  Scenario: Verify Delete API
    Given baseurl
    When user send endpath "/order/3"
    When user send a DELETE request with id  3
    Then the  status code should be 200
    And the response should contain "code"
