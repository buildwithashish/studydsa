package com.mixer;

public class Practice {

    public static void main(String []a) {
        int[] coins = {2,3,5,6};
        int sum = 10;
        String ans = "";
        coinChangeCombination(coins, sum, ans, 0);
    }

    private static void coinChangeCombination(int[] coins, int sum, String ans, int lastIdx) {
        if(sum == 0) {
            System.out.println(ans);
            return;
        }

        for(int i=lastIdx; i<coins.length; i++) {
            if(sum >= coins[i]) {
                coinChangeCombination(coins, sum-coins[i], ans+coins[i], i);
            }
        }
    }
}
