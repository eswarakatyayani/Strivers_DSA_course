class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            // Customer gives $5
            if (bill == 5) {
                five++;
            }

            // Customer gives $10
            else if (bill == 10) {

                // Need to give $5 change
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }

            // Customer gives $20
            else {

                // Prefer giving 10 + 5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                // Otherwise give three $5 bills
                else if (five >= 3) {
                    five -= 3;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }
}

//Time complexity: O(n)
//space complexity: O(1)
