//3477. Fruits Into Baskets II

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        int n = baskets.length;

        for(int f : fruits){
            int j = 0;
            while(j<n){
                if(baskets[j] >= f){
                    baskets[j] = 0;
                    break;
                }
                j++;
            }
            if(j == n)
                ans++;
        }

        return ans;
    }
}
