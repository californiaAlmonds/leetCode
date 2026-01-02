public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length-1;
        for (int i = n; i>=0 ; i--){
            if(digits[i]<9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        for(int i : plusOne(digits)){
            System.out.print(i);
        }
    }
}
