import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int x = 321;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        long result = 0;
        List<Long> list = new ArrayList<>();
        long powten = 1;

        if(x <= -2147483648){
            return 0;
        }

        while(x != 0){
            list.add((long) (x%10));
            x /=10;
        }

        Collections.reverse(list);

        for (Long integer : list) {
            result += integer * powten;
            powten *= 10;
        }

        if(result > 2147483647 || result < -2147483648){
            return 0;
        }else{
            return (int) result;
        }
    }
}
