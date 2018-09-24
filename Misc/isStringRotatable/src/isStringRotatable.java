import java.util.HashMap;

public class isStringRotatable {

    public static void main (String[] args){

        System.out.println(is_String_Rotatable("0861980"));
        System.out.println(is_String_Rotatable("0011"));
        System.out.println(is_String_Rotatable("aa"));
        System.out.println(is_String_Rotatable("089680"));

    }

    public static boolean is_String_Rotatable (String s){

        if (s == null || s.length() == 0){
            throw new IllegalArgumentException("Cannot be Empty");
        }

        String numRegex = "\\d+";
        if (!s.matches(numRegex)){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            char key = s.charAt(left);
            if (map.containsKey(key)){
                if (map.get(key) != s.charAt(right)){
                    return false;
                }
            } else {
                if (key != s.charAt(right)){
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }
}
