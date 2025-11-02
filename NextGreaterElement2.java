import java.util.Arrays;
import java.util.Stack;

//TC: O(n), SC: O(n)
//Approach: We need to traverse the array twice to find out the next greater element for a given number
//because the next greater element for the number at the end may be at the beginning of the array
//we keep all the elements for which we have not found the next greater element in the stack
//if we don't find the number greater than that element, the result array is pre-filled with -1
public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        final int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        final int n = nums.length;

        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!stack.isEmpty() && nums[i % n] > stack.peek()) {
                int popped = stack.pop();
                result[popped] = nums[i % n];
            }

            if (i < n) stack.push(i);
        }

        return result;
    }
}
