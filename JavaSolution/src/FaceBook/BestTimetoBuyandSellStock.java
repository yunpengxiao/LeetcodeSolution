package FaceBook;

/**
 * Created by xyunpeng on 1/19/16.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int local = 0;
        int global = 0;
        for (int i = 1; i < prices.length; i++) {
            local = Math.max(local + prices[i] - prices[i - 1], 0);
            global = Math.max(local, global);
        }

        return global;
    }
}
