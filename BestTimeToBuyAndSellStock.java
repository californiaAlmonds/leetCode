public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE, profit = 0; 
        for(int price: prices){
            profit = price - minPrice;
            if(price < minPrice) minPrice = price;
            if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
