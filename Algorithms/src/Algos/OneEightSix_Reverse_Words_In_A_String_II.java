package Algos;

public class OneEightSix_Reverse_Words_In_A_String_II {

    public void reverseWords(char[] str) {

        if(str == null || str.length == 0){
            return;
        }

        // if(new String(str).indexOf(' ')==-1) return; // same effect as the if(prev == -1) return; below

        // reverse sub strings
        int fast = 0;
        int prev = -1;
        for(int i = 0; i < str.length; i++){
            if(str[i] == ' '){
                fast = i - 1;
                reverse(str,prev+1,fast);
                prev = i;
            }
        }

        // if prev is -1 which means there is no space,
        // so there is no words in the string are needed to be reversed
        if(prev == -1) return;

        // reverse the last words
        fast = str.length-1;
        reverse(str,prev+1,fast);

        // reverse whole char array
        int begin = 0;
        int end = str.length - 1;
        reverse(str,begin,end);
    }

    public void reverse(char[] str, int begin, int end){
        while(begin < end){
            char tmp = str[begin];
            str[begin] = str[end];
            str[end] = tmp;
            end--;
            begin++;
        }
    }
}
