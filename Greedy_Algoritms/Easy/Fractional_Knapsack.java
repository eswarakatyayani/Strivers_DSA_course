import java.util.*;

// Item class
class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Solution {

    // Function to return maximum value
    double fractionalKnapsack(Item[] arr, int W) {

        // Sort based on value/weight ratio in descending order
        Arrays.sort(arr, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double totalValue = 0.0;
        for (int i = 0; i < arr.length; i++) {
            // Take whole item
            if (arr[i].weight <= W) {
                totalValue += arr[i].value;
                W -= arr[i].weight;

            } else {
                // Take fractional part
                double fraction = (double) W / arr[i].weight;
                totalValue += arr[i].value * fraction;
                break;
            }
        }
        return totalValue;
    }
}
