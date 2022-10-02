package com.alexamanov.strategy;

import java.util.ArrayList;
import java.util.HashMap;

public class Simple implements StrategyInterface
{
    private final int[] USD_INTEREST = new int[]{20, 30, 50};
    private final int[] BTC_STABLE_INTEREST = new int[]{2, 7, 12};
    private final int[] BTC_DANGEROUS_INTEREST = new int[]{5, 15, 27};

    @Override
    public HashMap<String, ArrayList<Float>> execute(int marketType, float deposit, float currentBtcAmount)
    {
        HashMap<String, ArrayList<Float>> result = new HashMap<>();
        int numberOfOrders = USD_INTEREST.length;
        int[] btcInterest;

        ArrayList<Float> buy = new ArrayList<>();
        ArrayList<Float> sell = new ArrayList<>();
        ArrayList<Float> btc = new ArrayList<>();

        float myBtc = 0, myUsd = 0;

        if (StrategyInterface.STABLE_TYPE == marketType) {
            btcInterest = this.BTC_STABLE_INTEREST;
        } else if (StrategyInterface.DANGEROUS_TYPE == marketType) {
            btcInterest = this.BTC_DANGEROUS_INTEREST;
        } else {
            return null;
        }

        for (int i = 0; i < numberOfOrders; i++) {
            float usd = btcInterest[i] * currentBtcAmount / 100;

            float newBtcAmount = currentBtcAmount - usd;

            buy.add(newBtcAmount);

            myBtc += USD_INTEREST[i] * deposit / (newBtcAmount * 100);
            btc.add(myBtc);
        }

        for (int i = 0; i < numberOfOrders; i++) {
            float usd = USD_INTEREST[i] * deposit / 100;
            float usdWithProfit = usd + (StrategyInterface.DEFAULT_PROFIT * usd / 100);
            myUsd += usdWithProfit;

            sell.add(myUsd / btc.get(i));
        }

        result.put("buy", buy);
        result.put("sell", sell);

        return result;
    }
}
