
## Demo

Live URL API : [https://nameless-plains-51062.herokuapp.com/geolocation](https://nameless-plains-51062.herokuapp.com/geolocation/home) 

Live URL Angular : https://geolocation-web.herokuapp.com/


## Getting started


#### Using Maven :

Follow these steps to get started:

#### Step 1: Clone this repository

```bash
$ git clone https://github.com/Istiaq-Hossain-Shawon/geolocation-api 

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
$ git clone https://github.com/Istiaq-Hossain-Shawon/geolocation-api 

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

This include 2 api endpoints.These are:

#### 1.geolocation/requesttoken[POST]
 * **Url**:
```
http://localhost:8095/geolocation/requesttoken
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

#### 2.geolocation/location[GET]

* **Url**:
```
http://localhost:8095/geolocation/location
```
 * **Body**:{}
 * **Add Bearer Token from previous api in Authorization**:
 * **Response**:
 ```
 [
     {
         "id": 1,
         "name": "Mohakhali, Dhaka, Bangladesh",
         "latitude": "23.777628",
         "longitude": "90.405449"
     },
     {
         "id": 2,
         "name": "Barisal District",
         "latitude": "22.7022",
         "longitude": "90.3696"
     },
     {
         "id": 3,
         "name": "Chittagong District",
         "latitude": "22.5150",
         "longitude": "91.7539"
     },
     {
         "id": 4,
         "name": "Comilla  District",
         "latitude": "23.4576",
         "longitude": "91.1809"
     },
     {
         "id": 5,
         "name": "Tangail  District",
         "latitude": "24.3917",
         "longitude": "89.9948"
     }
 ]
    
   ```
