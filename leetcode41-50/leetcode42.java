class Solution {
  // Understanding how to draw the diagram before understanding the code.
  // we need to maintain the shape of the water container.
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int last = 0;
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                res += (height[stack.peek()] - last) * (i - stack.peek() - 1);
                last = height[stack.peek()];
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                res += (i - stack.peek() - 1) * (height[i] - last);
            }
            stack.push(i);
        }
        return res;
    }
}
