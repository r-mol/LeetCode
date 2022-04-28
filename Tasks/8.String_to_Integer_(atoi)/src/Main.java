public class Main {
    public static void main(String[] args) {
        String s = "    43";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        boolean negative = false;
        double result = 0;
        if (s.length() > 0 &&s.charAt(0) == '-') {
            negative = true;
        }
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result = result * 10 + (s.charAt(i) - 48);
            } else if (!(s.charAt(0) == '-' || s.charAt(0) == '+')) {
                break;
            }else if(i>0){
                break;
            }
        }

        if (negative) {
            result *= -1;
        }

        if(result > 2147483647){
            return 2147483647;
        }
        else if(result < -2147483648){
            return -2147483648;
        }
        return (int)result;
    }
}

