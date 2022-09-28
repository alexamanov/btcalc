package com.alexamanov.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetFullData
{
    public final String RESOURCE = "https://poloniex.com/public?";

    public String execute()
    {
        HashMap<String, String> params = new HashMap<>();
        StringBuilder uri = new StringBuilder(RESOURCE);

        params.put("command", "returnChartData");
        params.put("currencyPair", "USDT_BTC");

        /*
          86400 second = 1 day
          1609448518 unix ts = 1 Jan 2021
         */
        params.put("period", "86400");
        params.put("start", "1609448518");
        params.put("end", "9999999999");

        Set<Map.Entry<String, String>> paramsSet = params.entrySet();

        for (Map.Entry<String, String> param: paramsSet) {
            uri.append("&")
                    .append(param.getKey())
                    .append("=")
                    .append(param.getValue());
        }

        return new SendRequestAndGetResponse().execute(uri.toString());
    }
}
