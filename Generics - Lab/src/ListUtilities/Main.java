package ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1 , 2 , 3 ,4);

        System.out.println(ListUtil.getMin(numbers));
        System.out.println(ListUtil.getMax(numbers));

        List<String> strings = List.of("d" , "f" ,  "g");
        System.out.println(ListUtil.getMax(strings));
        System.out.println(ListUtil.getMin(strings));
    }
}
