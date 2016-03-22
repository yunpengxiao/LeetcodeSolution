package Google;

/**
 * Created by xyunpeng on 3/20/16.
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder("");

        if (denominator == 0) {
            return result.toString();
        }

        Map<Long, Integer> pre = new HashMap<>();
        long above = Math.abs((long) numerator);
        long below = Math.abs((long) denominator);

        result.append(above / below);
        long quo = above % below;                             //在进循环前解决小数点
        if (quo != 0) {
            result.append('.');
            int index = result.length();
            while (quo != 0) {
                if (pre.containsKey(quo)) {
                    result.insert((int) pre.get(quo), '(');
                    result.append(')');
                    break;
                }
                pre.put(quo, index++);
                quo *= 10;
                result.append(quo / below);
                quo %= below;

            }
        }

        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            result.insert(0, '-');
        }

        return result.toString();
    }
}


//这一题要注意的情形: 正负, 整数的最大值