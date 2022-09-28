package com.alexamanov.utils;

import java.io.InputStream;

public class SendRequestAndGetResponse
{
    public String execute(String url)
    {
        SendRequest sendRequest = new SendRequest();
        GetResponse getResponse = new GetResponse();

        InputStream stream = sendRequest.execute(url);

        return getResponse.execute(stream);
    }
}
