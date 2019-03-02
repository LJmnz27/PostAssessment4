package com.rusili.assessment4post.list.network;

import com.rusili.assessment4post.list.model.EchinodermResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EchinodermsService {
    String ECHINODERMS_ENDPOINT = "JDVila/storybook/master/echinoderms.json";

    /**
     * What is an endpoint
     * Know difference between GET/POST/??
     * What type is this interface returning?
     */
    @GET(ECHINODERMS_ENDPOINT)
    Call<EchinodermResponse> getMessage();
}
