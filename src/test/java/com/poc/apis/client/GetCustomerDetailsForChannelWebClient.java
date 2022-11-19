package com.poc.apis.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface GetCustomerDetailsForChannelWebClient {

    List<Map<String, List<Map<String, String>>>> getCustomerDetailsForCustomerWeb(String customerid) throws IOException;
}
