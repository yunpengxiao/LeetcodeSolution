import java.lang.*;
import java.io.*;

class Solutions
{
	public String reverseWords(String s) 
	{
		String t = "";
		int index = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (i == 0 && s.charAt(i) == ' ') continue;
			else 
			{

				if (s.charAt(i) == ' ' && s.charAt(i) == s.charAt(i - 1)) continue;
				else
				{
					t += s.charAt(i);
				}
			}
		}
		String[] parts = t.split(" ");
		String result = "";
		for (int i = parts.length - 1; i >= 0; i--)
		{
			result += parts[i];
			if (i != 0) result += " ";
		}
		return result;
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