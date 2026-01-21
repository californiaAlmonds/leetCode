public class PowOfXN {
    public static double myPowRecur(double x, int n) { //stack overflow issue, not reliable
        if(n==0) return 1.0;
        if(n>0){
            double half = myPowRecur(x, n/2);
            if(n%2==0) return half*half;
            return x*half*half;
        }
        else if(n<0){
            return 1.0/myPowRecur(x, -n);
        }
        return x;
    }
    public static double myPow(double x, int n){
        double result = 1.0;
        long exp = n;
        if(exp < 0){
            x = 1.0/x;
            exp = -exp;
        }
        while(exp > 0){
            if(exp % 2 == 1) 
                result *= x;
            x *= x;
            exp /= 2;
        }
        return result;
    }
    public static void main(String[] args) {
        double x = 2.000;
        int n = 10;
        System.out.println(myPow(x,n));
    }
}
