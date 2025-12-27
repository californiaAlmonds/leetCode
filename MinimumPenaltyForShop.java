public class MinimumPenaltyForShop {
    public static int bestClosingTime(String customers) {
        int penalty=Integer.MAX_VALUE;
        int calPenalty=0, bestClosingHour = 0;
        for(int i=0; i<=customers.length(); i++){
            calPenalty=0;
            for(int j=i;j<customers.length();j++){
                if(customers.charAt(j) == 'Y')  calPenalty++;
            }
            if(i>0){
                for(int j=0;j<i;j++){
                if(customers.charAt(j) == 'N')   calPenalty++;
            }
            }
            if(calPenalty<penalty) {
                penalty = calPenalty;
                bestClosingHour = i;
            }
        }
        return bestClosingHour;
    }
    public static int bestClosingTimeOptimized(String customers){
        int totalY=0;
        int minPenlty = Integer.MAX_VALUE;
        int n = customers.length();
        int bestClosingHour=0;
        int[] prefixY = new int[n+1];
        for(int i=1; i<=n; i++){
            if(customers.charAt(i-1) == 'Y')    totalY++;
            prefixY[i] = totalY;
        }
        for(int i=0;i<=n;i++){
            int openPenalty = i - prefixY[i];
            int closePenalty = totalY - prefixY[i];
            int totalPenalty = openPenalty + closePenalty;
            if(totalPenalty<minPenlty){
                minPenlty = totalPenalty;
                bestClosingHour = i;
            }
        }
        return bestClosingHour;
    }
    public static void main(String[] args) {
        String test = "NNNNN";
        System.out.println(bestClosingTime(test));
    }

}
