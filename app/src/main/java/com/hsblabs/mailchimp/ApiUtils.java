package com.hsblabs.mailchimp;

/**
 * Created by Muhammad Haseeb on 2/28/2017.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://usX.api.mailchimp.com";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
