import java.util.ArrayList;
import java.util.List;

class FourDivsors{

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int n : nums){
            List<Integer> divisors = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {     
                if (n % i == 0) {
                    divisors.add(i);               
                    if (i != n / i) {              
                        divisors.add(n / i);       
                    }
                }
            }
            if(divisors.size() == 4){
                sum += divisors.stream()
                       .mapToInt(Integer::intValue)  // convert to IntStream
                       .sum();   
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        System.out.println(sumFourDivisors(nums));
    }
}