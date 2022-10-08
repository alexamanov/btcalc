package com.alexamanov;

import com.alexamanov.strategy.Simple;
import com.alexamanov.utils.GetCurrentAmount;
import com.alexamanov.utils.GetFullData;
import com.alexamanov.utils.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.alexamanov.strategy.StrategyInterface;

import java.util.*;

/*
    TODO: 1. сделать чтобы стратегию и депозит мог вводить пользователь.
          2. определить минимальное и максимальное значение за определённый период.
          3. когда цены будут сформированы, надо определить сколько было касаний за определённый период.
          4. после надо к каждой из сформированных цен добавить и отнять X$ и определить там кол-во касаний.
          5. если кол-во касаний будет больше, то сделать корректеровку сформированных цен.
             потому что если для второго оредра кол-во касаний 0, то это не совсем ок.
 */
public class App
{
    private final static String OPEN_KEY = "open";
    private final static String DATE_KEY = "date";

    public static void main(String[] args)
    {
        GetFullData getFullData = new GetFullData();
        GetCurrentAmount getCurrentAmount = new GetCurrentAmount();
        JsonParser jsonParser = new JsonParser();

        float currentAmount = getCurrentAmount.execute();

        System.out.println("Current amount: " + currentAmount);

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

        HashMap<String, ArrayList<Float>> result = simpleStrategy.execute(
                StrategyInterface.STABLE_TYPE,
                1000,
                currentAmount
        );

        Set<Map.Entry<String, ArrayList<Float>>> resultSet = result.entrySet();

        for (Map.Entry<String, ArrayList<Float>> resultElement: resultSet) {
            System.out.println(resultElement.getKey() + ": " + resultElement.getValue().toString());
        }
    }
}
