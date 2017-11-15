package Algos;

public class ThreeFourFour_Reverse_String {
    public String reverseString(String s) {

        if (s == null || s.equals("")) {
            return "";
        }

        // with StringBuilder
        StringBuilder sb = new StringBuilder(s);
        // reverse the whole string
        sb.reverse();
        return sb.toString();
    }

    public String reverseString_swap(String s) {

        if (s == null || s.equals("")) {
            return "";
        }

        // swap char array
        char[] carr = s.toCharArray();

        // use two pointers to tag chars from head and back
        // move thses two pointers to each other after swapping chars
        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            char tmp = carr[begin];
            carr[begin] = carr[end];
            // System.arraycopy(carr,end,carr,begin,1);
            carr[end] = tmp;
            end--;
            begin++;
        }

        return new String(carr);

        // can be done with byte[] too, but it is little bit slower
        //         byte [] bytes = s.getBytes();
        //         int begin = 0;
        //         int end = bytes.length -1;

        //         while(begin < end){
        //             byte tmp = bytes[begin];
        //             bytes[begin] = bytes[end];
        //             bytes[end] = tmp;
        //             end--;
        //             begin++;
        //         }

        //         return new String(bytes);
    }

}
