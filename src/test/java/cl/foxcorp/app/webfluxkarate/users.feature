Feature: Testing user service

Background:
  * def baseUrl = 'http://localhost:8080/api/v1/users'
  * def userId = '64f3e02ae5a34a5e1e4ae3d9'

# getAllUsers
Scenario: Get list of users
  Given url baseUrl
  When method GET
  Then status 200
  * match each response contains { id: '#string', username: '#string', email: '#string', state: '#boolean' }

# getUserById
Scenario: Get user by id
  Given url baseUrl + '/' + userId
  When method GET
  Then status 200
  *  match response contains { username: 'sarah', email: 'sarah@correo.cl', state: true }

# getUserbyState
  Scenario: Get list of users with state true
    Given url baseUrl + '/state/true'
    When method GET
    Then status 200
    * match each response contains { id: '#string', username: '#string', email: '#string', state: true }

# addUser
Scenario: Add a new user
  Given url baseUrl
  And request {"username": "alan","email": "alan@correo.cl","state": true}
  When method POST
  Then status 201
  *  match response contains { username: 'alan', email: 'alan@correo.cl', state: true }

# updateUser
Scenario: Update a user
  Given url baseUrl + '/' + userId
  And request {"username": "sarah","email": "sarah@newcorreo.com","state": false}
  When method PUT
  Then status 200
  *  match response contains { username: 'sarah', email: 'sarah@newcorreo.com', state: false }

# deleteUser
  Scenario: Delete a user
    Given url baseUrl + '/' + userId
    When method DELETE
    Then status 204