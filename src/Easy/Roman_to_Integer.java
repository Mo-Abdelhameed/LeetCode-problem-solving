package Easy;

import java.util.HashMap;

public class Roman_to_Integer {

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for(int i = 0; i < s.length(); i++){

            if(i == s.length()-1) {
                sum += map.get(s.charAt(i));
                break;
            }

            char first = s.charAt(i);
            char second = s.charAt(i+1);
            int firstValue = map.get(first);
            int secondValue = map.get(second);

            if(secondValue > firstValue) {
                sum += secondValue - firstValue;
                i++;
            }
            else
                sum += firstValue;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IVIII"));
    }
}
