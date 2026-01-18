/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
*/
class Solution {
    public int totalFruit(int[] fruits) {
      HashMap<Integer,Integer> map=new HashMap<>();
      int l=0,c=0,max=0;
      for(int r=0;r<fruits.length;r++)
      {
          map.put(fruits[r],r);
     if(map.size()> 2)
      {
                int minIndex = Integer.MAX_VALUE;
                int removeKey = -1;

                // find fruit with smallest last index
                for (int key : map.keySet()) {
                    if (map.get(key) < minIndex) {
                        minIndex = map.get(key);
                        removeKey = key;
                    }
                }

                // remove that fruit type
                map.remove(removeKey);
                l = minIndex + 1;
           
      }
    
        max=Math.max(max,r-l+1);
      } 
      return max;
    }
}
