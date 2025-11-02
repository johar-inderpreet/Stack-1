import java.util.Stack;

//TC: O(n), SC: O(n)
//Approach: We keep all the elements in the stack until we have not found an element > than the top of the stack
//we keep popping the elements from the stack until the current element > stack.peek
//the distance between the temp's is current - indexOfTemp
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temp) {
        final Stack<Integer> stack = new Stack<>();
        final int[] result = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {

            while (!stack.isEmpty() && temp[i] > stack.peek()) {
                int popped = stack.pop();
                result[popped] = i - popped;
            }

            stack.push(i);
        }

        return result;
    }
}
