import java.util.HashMap;

public class MaximumLengthSubstring {
    public static int maximumLengthSubstring(String s){
        int length = s.length();
        int maxLength = 0;
        int start = 0;
        int subLength = 0;
        int i=0;
        HashMap<Character, Integer> letters = new HashMap<>();
        while(i<length){
            char c = s.charAt(i);
            if(letters.get(c) == null || letters.get(c) < 2 ){
                int curCount = letters.get(c) == null ? 0 : letters.get(c);
                letters.put(c, curCount+1);
                subLength++;
                i++;
            } else{
                start++;
                i=start;
                maxLength = Math.max(subLength, maxLength);
                subLength = 0;
                letters.clear();
            }
        }
        maxLength = Math.max(subLength, maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s));
    }
}
