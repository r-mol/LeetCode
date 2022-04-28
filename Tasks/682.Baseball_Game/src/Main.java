import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] str ={"5","2","C","D","+"};
        System.out.println(calPoints(str));
    }

    public static int calPoints(String[] ops) {

        List<Integer> list = new ArrayList<>();

        for(String op : ops){
            if(isNumeric(op)){
                list.add(Integer.parseInt(op));
            }else{
                switch(op){
                    case "+":
                        list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
                        break;
                    case "C":
                        list.remove(list.size() - 1);
                        break;
                    case "D":
                        list.add(2*list.get(list.size() - 1));
                        break;
                    default: break;
                }
            }
        }




        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
