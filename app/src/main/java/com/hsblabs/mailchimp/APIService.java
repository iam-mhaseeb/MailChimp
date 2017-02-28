package com.hsblabs.mailchimp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

/**
 * Created by Muhammad Haseeb on 2/28/2017.
 */

public interface APIService {
    @Members("/3.0/lists/9e67587f52/members")
    @FormUrlEncoded
    Call<Members> savePost(@Field("email_address") String email,
                           @Field("status") String status);

}
