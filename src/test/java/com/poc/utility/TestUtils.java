package com.poc.utility;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class TestUtils {

    public static org.json.JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String conFileName = new File(filename).getCanonicalPath();
        String content = new String(Files.readAllBytes(Paths.get(conFileName)));
        return new org.json.JSONObject(content);
    }


    public static RequestSpecification given() {
        RequestSpecification request = RestAssured.given();
        RestAssured.useRelaxedHTTPSValidation();
        return request.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

//    public static RequestSpecification requestSpec(String sessionToken) {
//        RequestSpecification request = RestAssured.given().header(TestConstants.X_WP_CORRELATION_ID_HEADER, UUID.randomUUID().toString())
//                .header("Authorization", sessionToken);
//        RestAssured.useRelaxedHTTPSValidation();
//        return request.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//    }
}
