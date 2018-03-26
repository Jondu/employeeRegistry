## employeeRegistry
A simple spring rest CRUD app demo. Built with Gradle, Spring Boot 2 and H2 database.

### endpoints:
1. "/employee-registry/create"  for creating users
2. "/employee-registry/update"  for updating users
3. "/employee-registry/delete"  for removing user
4. "/employee-registry/info/{employeeId}"  for getting info on specific employee
5. "/employee-registry/employeeList/{supervisorId}"  for getting a list of epmployees under a specific supervisor

### initial supervisor ID's
1. 8987
2. 2987

### initial employee ID's
1. 1990
2. 1922
3. 1420

### known issues
1. no way to add or change supervisors.
2. no way to create new connections between employees and supervisors.
3. no unit tests included.
4. no integration tests included.
