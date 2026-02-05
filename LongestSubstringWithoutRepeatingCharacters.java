import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int left = 0;
        HashMap<Character,Integer> charMap = new HashMap<>();
        for(int right = 0; right<s.length(); right++){
            if(charMap.containsKey(s.charAt(right))){
                left = Math.max(left, charMap.get(s.charAt(right))+1);
            }
            charMap.put(s.charAt(right), right);
            maxSize = Math.max(maxSize, right-left+1);
        }
        return maxSize;
    }
    public static void main(String[] args) {
        String s = "abba";
        System.out.println("\sLength is : "+ lengthOfLongestSubstring(s));
    }
}
