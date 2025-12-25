import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public static int solution(int[] apple, int[] capacity){
        int totalApples = 0;
        int totalCapacity = 0;
        Arrays.sort(capacity);
        int left = 0;
        int right = capacity.length-1;
        while(left < right){
            int temp = capacity[left];
            capacity[left] = capacity[right];
            capacity[right] = temp;
            left++;
            right--;
        }


        for(int a : apple) totalApples += a;
        for(int i=0; i<capacity.length;i++){
            totalCapacity += capacity[i];
            if(totalCapacity >= totalApples){
                return i+1;
            }
        }

        return 0;
    }    

    public static void main(String[] args) {
        int[] apple = {1,2,3,4,5};
        int[] capacity = {5,5,5,5,5};
        System.out.println(solution(apple, capacity));
    }
}
