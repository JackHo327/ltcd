
/**
 *
 * @author Renzhi He
 */
public class TwoNineTwo_NimGame {

    public static void main(String[] args) {

        boolean canWN = false;
        canWN = canWinNim(5);
        System.out.println(canWN);
    }

    public static boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
