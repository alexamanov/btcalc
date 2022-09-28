package com.alexamanov.utils;

public class GetCurrentAmount
{
    public final static String CURRENT_AMOUNT_URI = "https://api.coinbase.com/v2/prices/spot?currency=USD";

    public float execute()
    {
        JsonParser jsonParser = new JsonParser();

        String response = new SendRequestAndGetResponse().execute(CURRENT_AMOUNT_URI);

        return Float.parseFloat(jsonParser.getValueByPath(response, new String[]{"data", "amount"}));
    }
}
