package com.alexamanov.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser
{
    public String parse(String json, String[] keys)
    {
        try {
            String result = null;
            Object jsonObject = new JSONParser().parse(json);
            JSONObject tmpObject = (JSONObject) jsonObject;

            for (String key : keys) {
                if (key.equals(keys[keys.length - 1])) {
                    result = tmpObject.get(key).toString();

                    break;
                }

                tmpObject = (JSONObject) tmpObject.get(key);
            }

            return result;
        } catch (ParseException e) {
            return null;
        }
    }
}
