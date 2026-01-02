public class RotateString {
    public static boolean rotateString(String s, String goal) {
        // for(int i =1; i<=s.length(); i++){
        //     String newS = s.substring(i) + s.substring(0, i);
        //     if(newS.equals(goal)) {
        //         System.out.println(newS);
        //         return true;
        //     }
        // }
        // return false;
        if (s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "abced";
        System.out.println(rotateString(s, goal));
    }
}
