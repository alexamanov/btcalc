package com.alexamanov;

import com.alexamanov.strategy.Simple;
import com.alexamanov.utils.GetCurrentAmount;
import com.alexamanov.utils.GetFullData;
import com.alexamanov.utils.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class App
{
    private final static String OPEN_KEY = "open";
    private final static String DATE_KEY = "date";

    public static void main(String[] args)
    {
        GetFullData getFullData = new GetFullData();
        GetCurrentAmount getCurrentAmount = new GetCurrentAmount();
        JsonParser jsonParser = new JsonParser();

        //float currentAmount = getCurrentAmount.execute();

        //System.out.println(currentAmount);

//        String fullJsonData = getFullData.execute();
//
//        JSONArray jsonArray = jsonParser.parseJsonArray(fullJsonData);
//
//        for (Object object: jsonArray) {
//            String openAmount = (String) ((JSONObject) object).get(OPEN_KEY);
//            String timestamp = (String) ((JSONObject) object).get(DATE_KEY);
//
//            System.out.println(new Date(Long.parseLong(timestamp)).toString());
//            System.out.println(openAmount);
//            System.out.println();
//        }

        Simple simpleStrategy = new Simple();

        HashMap<String, ArrayList<Float>> result = simpleStrategy.execute(1, 1000, 20000);

        Set<Map.Entry<String, ArrayList<Float>>> resultSet = result.entrySet();

        for (Map.Entry<String, ArrayList<Float>> resultElement: resultSet) {
            System.out.println(resultElement.getKey());
            System.out.println(resultElement.getValue().toString());
        }
    }
}
