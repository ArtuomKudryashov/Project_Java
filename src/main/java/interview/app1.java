package interview;

import java.util.Random;

public class app1 {
    public static void main(String[] args) {
        int[] dices = getRandomDices(7);
        int count = 0;
        for (int dice: dices) {
            System.out.println(dice);
            if (dice == 1){
                count =count+2;
                continue;

            }
            if(dice!=6){
                count++;
                continue;
            }
        }
        System.out.println("count = " + count);


    }

    public static int[] getRandomDices(int n) {
        int[] dices = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            dices[i] = random.nextInt(6) + 1;

        }
        return dices;
    }
}

