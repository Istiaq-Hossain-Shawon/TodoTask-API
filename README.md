

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


#### Step 4: Run Java application

## Api Documentation

This include 6 api endpoints.These are:

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
 * **Add Bearer Token from previous api in Authorization**:
 * **Response**:
 ```
 {
    "content": [
        {
            "id": 2,
            "description": "Task 2",
            "piority": {
                "piorityId": 3,
                "name": "high"
            },
            "isDone": false
        },
        {
            "id": 5,
            "description": "Task 5",
            "piority": {
                "piorityId": 3,
                "name": "high"
            },
            "isDone": false
        },
        {
            "id": 4,
            "description": "Task 4",
            "piority": {
                "piorityId": 2,
                "name": "medium"
            },
            "isDone": false
        },
        {
            "id": 3,
            "description": "Task 3",
            "piority": {
                "piorityId": 1,
                "name": "low"
            },
            "isDone": false
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 4,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 4,
    "empty": false
}

 ```


#### 3.Get Only Done Task :todotask/todoTasks?page=0&size=10&isDone=true [GET]

* **Url**:
```
http://localhost:8095/todotask/todoTasks?page=0&size=10&isDone=true
```
 * **Body**:{}
 * **Add Bearer Token from previous api in Authorization**:
 * **Response**:
 ```
 {
    "content": [
        {
            "id": 6,
            "description": "Task 1234",
            "piority": {
                "piorityId": 3,
                "name": "high"
            },
            "isDone": true
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}

 ```
 
 

#### 4.Update Task :todotask/saveTask [POST]

* **Url**:
```
http://localhost:8095/todotask/saveTask
```
 * **Body**:
 ```{
   "description":"Task 1234",
   "isDone": false,
   "piorityName":"high"
}
```
   
 * **Add Bearer Token from previous api in Authorization**:
 * **Response**:
 ```
 {
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 12:38:34"
}

```

#### 5.Update Task Status :todotask/saveTask [POST]

* **Url**:
```
http://localhost:8095/todotask/saveTask
```
 * **Body**:
 ```{
   "description":"Task 1234",
   "isDone": true,
   "piorityName":"high"
}
```
   
 * **Add Bearer Token from previous api in Authorization**:
 * **Response**:
 ```
 {
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 12:38:34"
}


 ```

#### 6.Delete  Task Status :todotask/deleteTask [POST]

* **Url**:
```
http://localhost:8095/todotask/deleteTask
```
 * **Body**:
 ```{
   "id":1
}
```
   
 * **Add Bearer Token from previous api in Authorization**:
 * **Response**:
 ```
 {
    "errorcode": 0,
    "errormsg": "SUCCESS",
    "requesttimestamp": "27/11/2021 12:38:34"
}


 ```
 