import java.util.Scanner;
/**
 *
 * @author Renzhi He
 */
public class LCD_345_ReverseVowels_String {

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int vowel_head = 0;
        int vowel_tail = chars.length - 1;
        java.util.ArrayList a = new java.util.ArrayList();

        char c1 = 'a';
        char c2 = 'e';
        char c3 = 'i';
        char c4 = 'o';
        char c5 = 'u';
        char c6 = 'A';
        char c7 = 'E';
        char c8 = 'I';
        char c9 = 'O';
        char c10 = 'U';

        a.add(c1);
        a.add(c2);
        a.add(c3);
        a.add(c4);
        a.add(c5);
        a.add(c6);
        a.add(c7);
        a.add(c8);
        a.add(c9);
        a.add(c10);

        for(int i = 0; i < chars.length; i ++){
            System.out.println(i +"."+chars[i]+": "+a.contains(chars[i]));
        }
        for(int i = 0; i < vowel_tail; i ++){
            start:
            if(a.contains(chars[vowel_head])){
//                System.out.println(chars[vowel_head]+" charhead");
                for(int k = chars.length - 1; k>vowel_head; k--){
                    if(a.contains(chars[vowel_tail])){
//                        System.out.println(chars[vowel_tail]+" chartail");
                        char tmp = chars[vowel_head];
                        chars[vowel_head] = chars[vowel_tail];
                        chars[vowel_tail] = tmp;
                        vowel_tail--;
//                        System.out.println(chars[vowel_tail+1]+" (chartail) changed to "+ chars[vowel_tail]);
                        break start;
                    }else{
                        vowel_tail--;
                    }
                    
                }
            }
            vowel_head++;
        }
        return new String(chars);
    }

    public static void main(String[] args){
        LCD_345_ReverseVowels_String neLCD = new LCD_345_ReverseVowels_String();
        String newStr = neLCD.reverseVowels("race a car");
        System.out.println(newStr);
    }
}
