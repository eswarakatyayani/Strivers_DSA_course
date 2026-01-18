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
-------------------------------------------------------------------------------------
//Two pointer with hashmap
public class FruitInBasket {

  int totalFruit(int[] fruits) {

    Map<Integer, Integer> basket = new HashMap<>();
    int left = 0;
    int right = 0;
    int maxFruits = 0;

    for (right = 0; right < fruits.length; right++) {
      // Add current to basket
      int currentCount = basket.getOrDefault(fruits[right], 0);
      basket.put(fruits[right], currentCount + 1);

      // If basket has more than 2 type of fruits,
      // start emptying the basket
      while (basket.size() > 2) {
        int fruitCount = basket.get(fruits[left]);
        if (fruitCount == 1)
          basket.remove(fruits[left]);
        else
          basket.put(fruits[left], fruitCount - 1);
        left++;
      }

      maxFruits = Math.max(maxFruits, right - left + 1);
    }
    return maxFruits;
  }

}
