package com.poc.apis.client;

import com.poc.utility.TestUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.poc.utility.TestConstants.BASE_URL;
import static com.poc.utility.TestConstants.CHANNEL_WEB_URL;

public class GetCustomerDetailsForChannelWebClientImpl implements GetCustomerDetailsForChannelWebClient {


    @Override
    public List<Map<String, List<Map<String, String>>>> getCustomerDetailsForCustomerWeb(String customerId) throws IOException {
        JSONObject requestBody = TestUtils.parseJSONFile("/requestPayload/channelWebRequest.json");

        requestBody.put("CustomerID", customerId);
        return TestUtils.given()
                .baseUri(BASE_URL + CHANNEL_WEB_URL)
                .body(requestBody.toString())
                .contentType("application/json")
                .when().post()
                .then()
                .extract().response().path("ContainerList[:0].NextBestActions");
    }

}
