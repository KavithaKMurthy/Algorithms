import java.util.*;

class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitBasket = new HashMap<>();
        for(int windowEnd= 0; windowEnd <= arr.length-1; windowEnd++){
            fruitBasket.put(arr[windowEnd], fruitBasket.getOrDefault(arr[windowEnd],0) + 1);
            if(fruitBasket.size() > 2){
                fruitBasket.put(arr[windowStart],fruitBasket.getOrDefault(arr[windowStart],0) -1);
                if(fruitBasket.get(arr[windowStart]) == 0){
                    fruitBasket.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
