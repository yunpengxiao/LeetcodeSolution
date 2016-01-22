package FaceBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyunpeng on 1/21/16.
 */
public class LetterCombinationsofPhoneNumber {
    static String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        helper(digits, new StringBuilder(""), result);
        return result;
    }

    private void helper(String digits, StringBuilder item, List<String> result) {
        if (digits.length() == 0) {
            result.add(item.toString());
            return ;
        }

        String charsOfNum = mapping[digits.charAt(0) - '0' - 2];
        for (int i = 0; i < charsOfNum.length(); i++) {
            item.append(charsOfNum.charAt(i));
            helper(digits.substring(1), item, result);
            item.deleteCharAt(item.length() - 1);
        }
    }
}

//还是一次过,今天状态不错啊