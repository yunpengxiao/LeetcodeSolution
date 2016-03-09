/**
 * Created by xyunpeng on 3/8/16.
 */
public class BestTimetoBuyandSellStockII {
    if (prices == null || prices.length == 0) {
        return 0;
    }

    int pre = prices[0];
    int sum = 0;

    for (int i = 1; i < prices.length; i++) {
        if (prices[i] < prices[i - 1]) {
            sum += prices[i - 1] - pre;
            pre = prices[i];
        }
    }

    sum += prices[prices.length - 1] - pre;

    return sum;
}
