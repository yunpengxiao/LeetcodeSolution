import java.lang.*;
import java.io.*;
import java.util.Stack;  


class Solutions
{
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
                if (i != "+" && i != "-" && i != "*" && i != "/")
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
                            s.push(a - b);
                            break;
                        case "*":
                            a = s.pop();
                            b = s.pop();
                            s.push(a * b);
                            break;
                        case "/":
                            a = s.pop();
                            b = s.pop();
                            s.push(a / b);
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
		String[] x = {"3", "+", "2"};
		System.out.println(s.reverseWords("Yunpeng is tiancai"));
		System.out.println(s.evalRPN(x));
	}
}
