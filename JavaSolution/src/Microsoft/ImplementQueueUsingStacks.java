package Microsoft;

/**
 * Created by xyunpeng on 2/21/16.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {                                  //每次要输出的时候就调用peek来导出所有的input
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}
