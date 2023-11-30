package interview;

import java.util.Arrays;

public class App5 {
    public static void main(String[] args) {
        System.out.println(isAnagram("zzzzwwww","wwwwzzzz"));

    }
    public static boolean isAnagram(String word1, String word2){
        if(word1.length()!=word2.length()){
            return false;

        }
        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        for (int i = 0; i < w1.length; i++) {
            if(w1[i]!= w2[i]){
                return false;
            }

        }
        return true;
    }
}
