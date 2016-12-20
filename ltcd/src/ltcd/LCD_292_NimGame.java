/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltcd;

/**
 *
 * @author Renzhi He
 */
public class LCD_292_NimGame {

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
