package Google;

/**
 * Created by xyunpeng on 5/4/16.
 */
public class NestedIterator {
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger t = stack.peek();
            if (t.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = t.getList().size() - 1; i >= 0; i--) {
                stack.push(t.getList().get(i));
            }
        }
        return false;
    }
}
