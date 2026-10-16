class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            int currMax = num;
            while (!stack.isEmpty() && stack.peek() > num) {
                currMax = Math.max(currMax, stack.pop());
            }
            stack.push(currMax);
        }
        return stack.size();
    }
}