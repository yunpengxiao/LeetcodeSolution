#include <iostream>
using namespace std;

class Solution 
{
public:
    bool isNumber(const char *s) 
    {
    	if (s == NULL)
    		return false;
    	const char *p = s;
    	string st = "";
    	while (*p != '\0')
    	{
    		if (*p == ' ')
    		{
    			p++;
    			continue;
    		}
    		st += *p;
    		p++;
    	}
    	if (st == "")
    		return false;
    	bool dotFlag = false;
    	bool eFlag = false;
    	int count = 0;
    	p = &st[0];
    	while (*p != '\0')
    	{
    		switch(*p)
    		{
    			case '.':
    			    if (dotFlag || eFlag || count == 0 || *(p - 1) <= '0' || *(p - 1) >= '9' || *(p + 1) == '\0' || *(p + 1) <= '0' || *(p + 1) >= '9')
    			    	return false;
    			    dotFlag = true;
    			    break;
    			case '+':
    			case '-':
    			    if ((count > 0 && *(p - 1) != 'e' && *(p - 1) != 'E') || *(p + 1) <= '0' || *(p + 1) >= '9')
    			    	return false;
    			    break;
    			case 'e':
    			case 'E':
    			    if (eFlag || count == 0 || *(p + 1) == '\0')
    			    	return false;
    			    eFlag = true;
    			    break;
    			case '0':
    			case '1':
    			case '2':
    			case '3':
    			case '4':
    			case '5':
    			case '6':
    			case '7':
    			case '8':
    			case '9':
    			    break;
    			default:
    			    return false;
    		}
    		count++;
    		p++;
    	}
    	return true;
    }
};

int main()
{

	return 0;
}