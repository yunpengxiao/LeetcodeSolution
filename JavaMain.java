import java.lang.*;
import java.io.*;

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
}

public class JavaMain
{
	public static void main(String args[])
	{
		System.out.println("Yunpeng");
		Solutions s = new Solutions();
		System.out.println(s.reverseWords("? nhgpoulnntytmvpqe.rb.d ?s'o?bekcnb?jku?'fc' !ji xsn!ppbuso ei,kwkbhaenntkdqbutwa'a.lizwbtxnejicm t,dab,as.!hftamhwps.!.wkcgqfioxb?qubollgsd.wbjlvhr "));
	}
}