package com.alexamanov.utils;

import java.io.InputStream;

public class GetCurrentAmount
{
    public final static String CURRENT_AMOUNT_URI = "https://api.coinbase.com/v2/prices/spot?currency=USD";

    public float execute()
    {
        SendRequest sendRequest = new SendRequest();
        GetResponse getResponse = new GetResponse();
        JsonParser jsonParser = new JsonParser();

        InputStream stream = sendRequest.execute(CURRENT_AMOUNT_URI);

        String response = getResponse.execute(stream);

        return Float.parseFloat(jsonParser.parse(response, new String[]{"data", "amount"}));
    }
}
