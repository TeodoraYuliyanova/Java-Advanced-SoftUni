package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer [] arr = ArrayCreator.create(4,10);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

        String[] arr2 = ArrayCreator.create(String.class, 5,"hello");
        for (String str : arr2) {
            System.out.println(str);
        }
    }
}
