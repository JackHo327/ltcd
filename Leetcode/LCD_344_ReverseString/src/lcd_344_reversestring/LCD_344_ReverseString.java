package lcd_344_reversestring;
import java.util.Scanner;
/**
 *
 * @author Renzhi He
 * @mission Write a function that takes a string as input and returns the string reversed.
 * @example: Given s = "hello", return "olleh".
 */
public class LCD_344_ReverseString {
//    !!! Time Limit Exceeded
//    public String reverseString(String s) {
//        String reverseStr = new String();
//        for(int i = (s.length()-1); i >= 0 ; i --){
//           reverseStr= reverseStr + s.charAt(i);
//        }
//        return reverseStr;
//    }

    public String reverseString(String s) {
        char [] charArry = s.toCharArray();
//.toCharArray()
//public char[] toCharArray()
//Converts this string to a new character array.
//Returns:
//a newly allocated character array whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string.
        int start = 0;
        int end = charArry.length - 1;
        while(start < end){
            char tmp = charArry[start];
            charArry[start] = charArry[end];
            charArry[end] = tmp;
            start++;
            end--;
        }
        return new String(charArry);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter sth here.");
        Scanner scnr = new Scanner(System.in);
        String str = scnr.nextLine();
        LCD_344_ReverseString new344 = new LCD_344_ReverseString();
        String reverseS = new344.reverseString(str);
        System.out.println(reverseS);
    }
}
