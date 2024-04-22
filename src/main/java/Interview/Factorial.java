package Interview;

public class Factorial {
    public static int factorial(int N){

        if (N==0||N==1){
            return 1;
        }
        else {
            return N*factorial(N-1);
        }

    }
    public static void main(String[] args) {
        int N = 10;
        int result = factorial(N);
        System.out.println(result);
    }
}
