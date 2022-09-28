package com.alexamanov;

import com.alexamanov.utils.GetCurrentAmount;

public class App
{
    public static void main(String[] args)
    {
        GetCurrentAmount getCurrentAmount = new GetCurrentAmount();

        float currentAmount = getCurrentAmount.execute();

        System.out.println(currentAmount);
    }
}
