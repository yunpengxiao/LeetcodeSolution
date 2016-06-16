package Google;

/**
 * Created by xyunpeng on 5/14/16.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, target, "", 0, 0, result);
        return result;
    }

    private void helper(String num, int target, String path, long curVal, long pre, List<String> result) {
        if (curVal == target && num.length() == 0) {
            result.add(path);
        }

        for (int i = 1; i <= num.length(); i++) {
            String currNum = num.substring(0, i);
            if (currNum.length() > 1 && currNum.charAt(0) == '0') {
                return ;
            }
            long cnum = Long.parseLong(currNum);
            String next = num.substring(i);
            if (path.length() != 0) {
                helper(next, target, path + '+' + currNum, curVal + cnum, cnum, result);
                helper(next, target, path + '-' + currNum, curVal - cnum, -cnum, result);
                helper(next, target, path + '*' + currNum, curVal - pre + pre * cnum, pre * cnum, result);
            } else {
                helper(next, target, currNum, cnum, cnum, result);
            }
        }
    }
}


//比较好的一个解释:https://segmentfault.com/a/1190000003797204