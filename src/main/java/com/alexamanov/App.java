package com.alexamanov;

import com.alexamanov.utils.GetCurrentAmount;
import com.alexamanov.utils.GetFullData;
import com.alexamanov.utils.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Date;

public class App
{
    public static void main(String[] args)
    {
        GetFullData getFullData = new GetFullData();
        GetCurrentAmount getCurrentAmount = new GetCurrentAmount();
        JsonParser jsonParser = new JsonParser();

        float currentAmount = getCurrentAmount.execute();

        System.out.println(currentAmount);

        String fullJsonData = getFullData.execute();

        JSONArray jsonArray = jsonParser.parseJsonArray(fullJsonData);

        for (Object object: jsonArray) {
            String openAmount = (String) ((JSONObject) object).get("open");
            String timestamp = (String) ((JSONObject) object).get("date");

            System.out.println(new Date(Long.parseLong(timestamp)).toString());
            System.out.println(openAmount);
            System.out.println();
        }
    }
}
