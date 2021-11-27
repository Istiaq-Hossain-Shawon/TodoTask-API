

## Getting started


#### Using Maven :

Follow these steps to get started:

#### Step 1: Clone this repository

```bash
$ git clone https://github.com/Istiaq-Hossain-Shawon/TodoTask-API

```
#### Step 2: Go to project root directory and open cmd

#### Step 3: Build Spring Boot Project with Maven
```bash
mvn install 
```
#### Step 4: Run Spring Boot app using Maven:
```bash
mvn spring-boot:run

```
### Run Using Eclipse:

Follow these steps to get started:

#### Step 1: Configuring Eclipse IDE for Java

You need to download the last version of Eclipse IDE for Java EE Developers, for example [Lunar](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr2) version. Make sure that Eclipse has installed the Maven plugin.


#### Step 2: Clone this repository

```bash
$ git clone https://github.com/Istiaq-Hossain-Shawon/TodoTask-API

```

#### Step 3: Import geolocation-api  Maven Project into Eclipse

To import an existing Maven project into Eclipse, just right-click the Package Explorer and go to:

`
Import... > Existing Maven Projects > Select root directory > Finish
`

It's possible that you need to update Maven project. To do it, just right-click the project and go to:

`
Maven > Update Project...
`

#### Step 4: Provide Mysql Username and password.

To provide mysql username and password , go to application-dev.yml  file from resources  and changes it :

`
url: jdbc:mysql://localhost:3306/todotask?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSL=false
username: *****
password: *****
`

#### Step 5: Run Java application

## Api Documentation

This include 7 api endpoints.These are:

#### 1.todotask/requesttoken[POST]
 * **Url**:
```
http://localhost:8095/todotask/requesttoken
```
 * **Body**:
 ```
 {
    "username":"user1",
    "password":"123456"
}
    
   ```
   * **Response**:
 ```
{
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNzgyNjU4MiwiaWF0IjoxNjE3NzkwNTgyfQ.g1Z8_BxbTmq07vpsPU5ppuLSv8Mmqa2IAf445hI2BFQ"
}
    
   ```

#### 2.Get All Tasks: todotask/todoTasks?page=0&size=10[GET]

* **Url**:
```
http://localhost:8095/todotask/todoTasks?page=0&size=10
```
 * **Body**:{}
 * **Add Bearer Token from requesttoken api in Authorization**:
 * **Response**:
 ```
 {
    "payload": [
        {
            "id": 17,
            "description": "Task 12234",
            "isDone": true,
            "piorityName": "high",
            "createdBy": "user1"
        },
        {
            "id": 18,
            "description": "Task ABC34",
            "isDone": true,
            "piorityName": "high",
            "createdBy": "user1"
        },
        {
            "id": 5,
            "description": "Task 5",
            "isDone": false,
            "piorityName": "high",
            "createdBy": null
        },
        {
            "id": 6,
            "description": "Task 1234",
            "isDone": true,
            "piorityName": "high",
            "createdBy": null
        }
    ],
    "pageSize": 10,
    "pageNumber": 0,
    "totalElements": 4
}

 ```


#### 3.Get Only Done Task : todotask/todoTasks?page=0&size=10&isDone=true [GET]

* **Url**:
```
http://localhost:8095/todotask/todoTasks?page=0&size=10&isDone=true
```
 * **Body**:{}
 * **Add Bearer Token from requesttoken api in Authorization**:
 * **Response**:
 ```
 {
    "payload": [
        {
            "id": 6,
            "description": "Task 1234",
            "isDone": true,
            "piorityName": "high",
            "createdBy": "user1"
        }
    ],
    "pageSize": 10,
    "pageNumber": 0,
    "totalElements": 1
}

 ```
 
 
 
 

#### 4.Get Single Task By ID: /todoTask?id= [GET]

* **Url**:
```
http://localhost:8095/todotask/todoTask?id=8
```
 * **Body**:
 ```{}
```
   
 * **Add Bearer Token from requesttoken api in Authorization**:
 * **Response**:
 ```
{
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 18:18:27",
    "payload": [
        {
            "id": 8,
            "description": "Task 2",
            "isDone": false,
            "piorityName": "high",
            "createdBy": "user1"
            
        }
    ]
}

```
 
 

#### 5.Update Task : todotask/addTask [POST]

* **Url**:
```
http://localhost:8095/todotask/addTask
```
 * **Body**:
 ```{
   "description":"Task 11222234",
   "isDone": false,
   "piorityName":"high"
}
```
   
 * **Add Bearer Token from requesttoken api in Authorization**:
 * **Response**:
 ```
 {
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 18:35:17",
    "payload": [
        {
            "id": 13,
            "description": "Task 11222234",
            "isDone": true,
            "piorityName": "high",
            "createdBy": "user1"
        }
    ]
}

```

#### 6.Update Task Status : todotask/updateTask [POST]

* **Url**:
```
http://localhost:8095/todotask/updateTask
```
 * **Body**:
 ```{
   "description":"Task 12234",
   "isDone": true,
   "piorityName":"high",
   "id":12
}
```
   
 * **Add Bearer Token from requesttoken api in Authorization**:
 * **Response**:
 ```
 {
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 18:33:10",
    "payload": [
        {
            "id": 12,
            "description": "Task 12234",
            "isDone": true,
            "piorityName": "high",
            "createdBy": null
        }
    ]
}


 ```

#### 7.Delete  Task Status : todotask/deleteTask [POST]

* **Url**:
```
http://localhost:8095/todotask/deleteTask
```
 * **Body**:
 ```{
   "id":1
}
```
   
 * **Add Bearer Token from requesttoken api in Authorization**:
 * **Response**:
 ```
 {
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 12:38:34"
}


 ```
 