package interview;

public class App3 {
    public static void main(String[] args) {
        fizzbuzz(50);

    }
    public static void fizzbuzz(int bound){
        for (int i = 0; i < bound; i++) {
            if (i % 3 == 0 && i % 5 == 0 ){
                System.out.println("FizzBuzz");
            }
            if ( i %  3 == 0){
                System.out.println("Fizz");

            }
            if (i % 5 == 0) {
                System.out.println("Buzz");

            }
            System.out.println(i);

        }
    }
}
