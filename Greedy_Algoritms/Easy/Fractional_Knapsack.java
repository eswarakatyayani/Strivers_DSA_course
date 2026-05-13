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
/*

Item[] arr = {
    new Item(60, 10),
    new Item(100, 20),
    new Item(120, 30)
};

*/

/*
Method 1:
Item[] arr = new Item[3];

arr[0] = new Item(1, 2);
arr[1] = new Item(4, 5);
arr[2] = new Item(10, 3);

Method 2:
Item[] arr = {
    new Item(1, 2),
    new Item(4, 5),
    new Item(10, 3)
};

Method 3:
ArrayList<Item> list = new ArrayList<>();

list.add(new Item(1, 2));
list.add(new Item(4, 5));

Method 4:
ArrayList<Item> list = new ArrayList<>(Arrays.asList(
    new Item(1, 2),
    new Item(4, 5),
    new Item(10, 3)
));
*/
