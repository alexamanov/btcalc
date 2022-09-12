package com.alexamanov;

import java.io.InputStream;

import com.alexamanov.utils.GetResponse;
import com.alexamanov.utils.JsonParser;
import com.alexamanov.utils.SendRequest;

public class App
{
    public final static String CURRENT_AMOUNT_URI = "https://api.coinbase.com/v2/prices/spot?currency=USD";

    public static void main(String[] args)
    {
        SendRequest sendRequest = new SendRequest();
        GetResponse getResponse = new GetResponse();
        JsonParser jsonParser = new JsonParser();

        InputStream stream = sendRequest.execute(
                CURRENT_AMOUNT_URI
        );

        String response = getResponse.execute(stream);

        response = jsonParser.parse(response, new String[]{"data", "amount"});

        System.out.println(response);
    }
}
