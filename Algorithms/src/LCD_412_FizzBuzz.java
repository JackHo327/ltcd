
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Renzhi He
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output 鈥淔izz鈥� instead of the number and for the multiples of five output 鈥淏uzz鈥�.  * For numbers which are multiples of both three and five output 鈥淔izzBuzz鈥�.
 */
public class LCD_412_FizzBuzz {
    public List<String> FizzBuzz(int n){
        
        final int THREE = 3;
        final int FIVE = 5;
        final int FIFTEEN = 15;
        List <String> aList = new ArrayList<String>() {};
        
        for(int i = 1; i <= n ; i ++){
            if(i % THREE == 0){
                if(i >= THREE && i % FIFTEEN == 0){
                    aList.add("FizzBuzz");
                }else{
                    aList.add("Fizz");
                }
            }else if(i % FIVE == 0){
                if(i > FIVE && i % FIFTEEN == 0){
                    aList.add("FizzBuzz");
                }else{
                    aList.add("Buzz");
                }
            }else{
                aList.add(String.valueOf(i));
            }
            
        }
        
        return aList;
    }
    
    public static void main(String[] args){
        LCD_412_FizzBuzz FB = new LCD_412_FizzBuzz();
        List<String> FBList = FB.FizzBuzz(15);
        for(String i:FBList){
            System.out.println("\""+i+"\"");
        }
    }
}
