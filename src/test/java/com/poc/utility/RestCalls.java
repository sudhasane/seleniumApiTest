package com.poc.utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestCalls {

    public void getActualResult(String customerid){
        RestAssured.baseURI = "https://";

        String actualResult = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(customerid).then().log().all().extract().response().path("").toString();

    }
}
