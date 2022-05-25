package Easy;
/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/
public class Add_Binary {

    public static String reverse(String s){
        String result = "";
        for(int i = 0; i < s.length(); i++)
            result = s.charAt(i) + result;
        return result;
    }

    public static String addBinary(String a, String b) {
        int min = Math.min(a.length(), b.length());
        String a1 = reverse(a), b1 = reverse(b);
        String longer = a.length() > b.length() ? a1 : b1;
        String result = "";
        int i = 0, carry = 0;
        for(i = 0; i < min; i++){
            char c1 = a1.charAt(i);
            char c2 = b1.charAt(i);

            if(c1 != c2){
                if(carry == 1)
                    result += '0';
                else
                    result += '1';
            }
            else if(c1 == '1'){
                if(carry == 1)
                    result += '1';
                else {
                    result += '0';
                    carry = 1;
                }
            }
            else{
                if(carry == 1){
                    result += '1';
                    carry = 0;
                }
                else{
                    result += '0';
                }
            }

        }

        while(i < longer.length()){
            if(carry == 1){
                if(longer.charAt(i) == '0'){
                    result += '1';
                    carry = 0;
                }
                else
                    result += '0';
            }
            else
                result += longer.charAt(i);
            i++;
        }

        if(carry == 1)
            result += '1';

        return reverse(result);
    }
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }
}
