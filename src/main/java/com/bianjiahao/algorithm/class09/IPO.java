package com.bianjiahao.algorithm.class09;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 项目投资问题
 * @author Obito
 */
public class IPO {

    public static class Program {
        public int invest;
        public int profit;

        public Program(int invest, int profit) {
            this.invest = invest;
            this.profit = profit;
        }
    }

    public static class MinInvestComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.invest - o2.invest;
        }
    }

    public static class MaxProfit implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o1.profit;
        }
    }

    /**
     * @param k       最多允许做几个项目
     * @param w       最初的预算是多少
     * @param profits 项目的利润集合
     * @param capital 项目的花费集合
     * @return 最后最大的收益
     */
    public static int findMaxProfit(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Program> minInvestQueue = new PriorityQueue<>(new MinInvestComparator());
        PriorityQueue<Program> maxProfitQueue = new PriorityQueue<>(new MaxProfit());
        for (int i = 0; i < profits.length; i++) {
            minInvestQueue.add(new Program(capital[i], profits[i]));
        }
        for (int i = 0; i < k; i++) {
            if (!minInvestQueue.isEmpty() && minInvestQueue.peek().invest <= w) {
                maxProfitQueue.add(minInvestQueue.poll());
            }
            if (maxProfitQueue.isEmpty()) {
                return w;
            }
            w += maxProfitQueue.poll().profit;
        }
        return w;
    }
}
