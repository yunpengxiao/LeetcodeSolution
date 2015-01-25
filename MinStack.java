import java.io.*;
import java.util.ArrayList;

class MinStack
{
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    public void push(int x)
    {
        stack.add(x);
        if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x)
            minStack.add(x);
    }

    public void pop()
    {
        if (stack.isEmpty())
            return ;
        int elem = stack.remove(stack.size() - 1);
        if (!minStack.isEmpty() && elem == minStack.get(minStack.size() - 1))
            minStack.remove(minStack.size() - 1);
    }

    public int top()
    {
        return stack.get(stack.size() - 1);
    }

    public int getMin()
    {
        return minStack.get(minStack.size() - 1);
    }
}
