package com.alexamanov.strategy;

import java.util.ArrayList;
import java.util.HashMap;

public interface StrategyInterface
{
    public final int STABLE_TYPE = 1;
    public final int DANGEROUS_TYPE = 2;

    public final float DEFAULT_PROFIT = 2.5F;

    public HashMap<String, ArrayList<Float>> execute(int marketType, float deposit, float currentBtcAmount);
}
