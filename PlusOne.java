public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length-1;
        for (int i = n; i>=0 ; i--){
            if(digits[i]<9) {
                digits[i] += 1;
                break;
            } 
            else if (i==0 && digits[i]==9){
                digits[i] = 0;
                int[] newDigits = new int[digits.length+1];
                for(int j=0; j<newDigits.length; j++){
                    if(j==0) newDigits[j] = 1;
                    else newDigits[j] = digits[j-1];
                }
                return newDigits;
            }
            else if (digits[i]==9){
                digits[i]=0;
            } 
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] digits = {1,2,9};
        for(int i : plusOne(digits)){
            System.out.println(i);
        }
    }
}
