package FaceBook;

/**
 * Created by xyunpeng on 1/7/16.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        StringBuilder sa = new StringBuilder(a).reverse();
        StringBuilder sb = new StringBuilder(b).reverse();

        StringBuilder res = new StringBuilder("");
        int next = 0;
        for (int i = 0; i < sa.length() || i < sb.length(); i++) {
            int ad = i >= sa.length()? 0: sa.charAt(i) - '0';
            int bd = i >= sb.length()? 0: sb.charAt(i) - '0';
            res.append(((ad + bd + next) % 2));                         //注意StringBuilder的append是可以自动把int转成char的
            next = (ad + bd + next) / 2;
        }

        if (next != 0) {
            res.append(next);
        }
        return res.reverse().toString();
    }
}


//别人家的代码