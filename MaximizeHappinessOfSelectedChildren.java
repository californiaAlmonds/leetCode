import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long totalHappiness = 0;
        for(int i = 0; i<k; i++){
            totalHappiness += Math.max(0, (happiness[happiness.length - 1 - i]-i));
        }
        return totalHappiness;
    }

    public static void main(String[] args) {
        int[] happiness = {1,1,1,1};
        int k = 2;
        System.out.println(maximumHappinessSum(happiness, k));
    }
    
}
