import java.lang.*;
import java.io.*;
import java.util.Stack;
import java.util.HashMap;
import java.util.Iterator;

class Point
{
    int x;
    int y;
    Point()
    {
        x = 0;
        y = 0;
    }
    Point(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Solutions
{
    public int maxPoints(Point[] points)
    {
        if (points.length == 0) return 0;
        int max = 1;
        int same;
        float ma = (float)10000000000.00;
        for (int i = 0; i < points.length; i++)
        {
            same = 0;
            HashMap<Float, Integer> hm = new HashMap<Float, Integer>();
            hm.put(ma, 1);
            for (int j = i + 1; j < points.length; j++)
            {
                if (points[j].x == points[i].x && points[j].y == points[i].y)
                {
                    same++;
                    continue;
                }
                if (points[j].x == points[i].x)
                {
                    int p = hm.get(ma);
                    p++;
                    hm.put(ma, p);
                    continue;
                }
                float x = ((float)(points[j].y - points[i].y)) / (float)(points[j].x - points[i].x);
                if (x == 0.0) x = (float)0.0;
                if (hm.containsKey(x))
                {
                    int n = hm.get(x);
                    n++;
                    hm.put(x, n);
                }
                else
                {
                    hm.put(x, 2);
                }
            }
            //Iterator iter = hm.keySet().iterator();
            if (max < same) max += same;
            for (int k : hm.values())
            {
                if (k + same > max) max = k + same;
            }
            /*while (iter.hasNext())
            {
                float m = (float)iter.next();
                System.out.println(m + "has " + hm.get(m));
                
                }*/
        }
        return max;
    }
    
    public String reverseWords(String s)
    {
        StringBuilder t = new StringBuilder("");
        int index = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (i == 0 && s.charAt(i) == ' ') continue;
            else
            {
                if (s.charAt(i) == ' ' && s.charAt(i) == s.charAt(i - 1)) continue;
                else
                {
                    t.append(s.charAt(i));
                }
            }
        }
        String[] parts = t.toString().split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = parts.length - 1; i >= 0; i--)
        {
            result.append(parts[i]);
            if (i != 0) result.append(" ");
        }
        return result.toString();
    }

    public int evalRPN(String[] tokens)
    {
        int sum;
        int a;
        int b;
        Stack<Integer> s = new Stack<Integer>();
        for (String i: tokens)
        {
            if (i.compareTo("+") != 0 && i.compareTo("-") != 0 && i.compareTo("*") != 0 && i.compareTo("/") != 0)
            {
                s.push(Integer.parseInt(i));
            }
            else
            {
                switch (i)
                {
                case "+":
                    a = s.pop();
                    b = s.pop();
                    s.push(a + b);
                    break;
                case "-":
                    a = s.pop();
                    b = s.pop();
                    s.push(b - a);
                    break;
                case "*":
                    a = s.pop();
                    b = s.pop();
                    s.push(a * b);
                    break;
                case "/":
                    a = s.pop();
                    b = s.pop();
                    s.push(b / a);
                    break;
                }
            }
        }
        return s.pop();
    }
}

public class JavaMain
{
    public static void main(String args[])
    {
        //System.out.println("Yunpeng");
        Solutions s = new Solutions();
        //String[] x = {"0", "3", "/"};
        Point[] p = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        //System.out.println(s.reverseWords("Yunpeng is tiancai"));
        //System.out.println(s.evalRPN(x));
        System.out.println(s.maxPoints(p));
    }
}
