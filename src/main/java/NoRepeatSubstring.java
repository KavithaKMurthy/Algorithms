import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public static int findLength(String str) {
       int windowStart =0 , maxLength = 0;
       Map<Character, Integer> characterMap = new HashMap<>();
       for(int windowEnd = 0; windowEnd <= str.length()-1; windowEnd++)
       {
           char rightChar = str.charAt(windowEnd);
           if(characterMap.containsKey(rightChar)){
               windowStart = Math.max(windowStart,characterMap.get(rightChar) +1 );
           }
           characterMap.put(rightChar, windowEnd);
           maxLength = Math.max(maxLength, windowEnd-windowStart +1);
       }
       return maxLength;
    }

        public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));

    }
}
