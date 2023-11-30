package interview;


public class App6 {
    public static void main(String[] args) {
        printPrimes(100);
    }

    private static void printPrimes(int bound) {
        for (int i = 2; i <= bound; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }

        }

    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number%i==0){
                return false;
            }

        }
        return true;
    }
}
