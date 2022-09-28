package com.alexamanov;

import com.alexamanov.utils.GetCurrentAmount;
import com.alexamanov.utils.GetFullData;

public class App
{
    public static void main(String[] args)
    {
        GetFullData getFullData = new GetFullData();
        GetCurrentAmount getCurrentAmount = new GetCurrentAmount();

        float currentAmount = getCurrentAmount.execute();

        System.out.println(currentAmount);

        String fullData = getFullData.execute();

        System.out.println(fullData);
    }
}
