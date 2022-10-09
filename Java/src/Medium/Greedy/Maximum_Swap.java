package Medium.Greedy;

/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.
Return the maximum valued number you can get.

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.

Constraints:

0 <= num <= 108
*/

public class Maximum_Swap {
    public static int maximumSwap(int num) {
        String number = num + "";
        int maxIndex = -1;
        boolean found = false;
        for(int i = 0; i < number.length()-1; i++){
            char current = number.charAt(i);
            char next = number.charAt(i+1);
            if(current < next)
                found = true;
            if(found && (maxIndex == -1 || number.charAt(maxIndex) <= next))
                maxIndex = i+1;
        }
        if(!found)
            return num;

        System.out.println(maxIndex);
        int swappedIndex = -1;
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) < number.charAt(maxIndex)){
                swappedIndex = i;
                break;
            }
        }
        String result = "";
        for(int i = 0; i < number.length(); i++){
            if(i == maxIndex)
                result += number.charAt(swappedIndex);
            else if(i == swappedIndex)
                result += number.charAt(maxIndex);
            else
                result += number.charAt(i);
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }
}
