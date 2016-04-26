package Google;

/**
 * Created by xyunpeng on 4/25/16.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words.length == 0) {
            return 0;
        }

        int n = words.length;
        int[] dic = new int[n];
        for (int i = 0; i < n; i++) {
            for (Character c : words[i].toCharArray()) {
                dic[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((dic[i] & dic[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
