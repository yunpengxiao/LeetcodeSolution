package Google;

/**
 * Created by xyunpeng on 3/5/16.
 */
public class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }

        normal.push(x);
    }

    public void pop() {
        int t = normal.pop();
        if (t == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
