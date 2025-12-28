class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;
            while (!s.isEmpty() && asteroids[i] < 0 && s.peek() > 0) {
                int top = s.peek();
                if (Math.abs(asteroids[i]) == top) {
                    s.pop();
                    alive = false;
                    break;
                }
                else if (Math.abs(asteroids[i]) < top) {
                    alive = false;
                    break;
                }
                else {
                    // |a[i]| > top → pop and while loop
                    s.pop();
                }
            }

            if (alive) {
                s.push(asteroids[i]);
            }
        }
      
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}
