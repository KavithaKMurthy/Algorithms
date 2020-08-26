import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str, int k){
        int windowStart = 0, maxLength=0, maxRepeatLetterCount =0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for(int windowEnd=0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            characterIntegerMap.put(rightChar, characterIntegerMap.getOrDefault(rightChar,0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount,characterIntegerMap.get(rightChar));
            if(windowEnd - windowStart + 1 - maxRepeatLetterCount > k ){
               char leftChar = str.charAt(windowStart);
               characterIntegerMap.put(leftChar, characterIntegerMap.get(leftChar) -1);
               windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));

    }
}

