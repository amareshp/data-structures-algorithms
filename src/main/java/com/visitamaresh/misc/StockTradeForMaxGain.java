package com.visitamaresh.misc;

public class StockTradeForMaxGain {
    public static int[] maxGain(int[] stockPrices) {
        int buy = 0, sell = 0, i = 0;
        int maxGainDays[] = new int[2];
        maxGainDays[0] = 0;
        maxGainDays[1] = 0;
        while (i < stockPrices.length - 1) {
            while ( (i < stockPrices.length - 1) && (stockPrices[i+1] < stockPrices[i]) ) {
                buy = i + 1;
                i++;
            }
            while ( (i < stockPrices.length - 1) && (stockPrices[i+1] > stockPrices[i]) ) {
                sell = i + 1;
                i++;
            }

            if(sell > buy) {
                if( (stockPrices[sell] - stockPrices[buy]) > (stockPrices[sell] - stockPrices[maxGainDays[0]]) ) {
                    maxGainDays[0] = buy;
                    maxGainDays[1] = sell;
                } else {
                    maxGainDays[1] = sell;
                }
            }
        }
        return maxGainDays;
    }

    public static void testMaxGain() {
        int[] stockPrices = new int[] {50, 60, 70, 80, 75, 150, 90, 60, 50, 40, 200};
        int[] gainArr = maxGain(stockPrices);
        System.out.format("You should buy at day: %d and sell at day: %d to make %d%n", gainArr[0], gainArr[1], (stockPrices[gainArr[1]] - stockPrices[gainArr[0]]) );
    }
}
