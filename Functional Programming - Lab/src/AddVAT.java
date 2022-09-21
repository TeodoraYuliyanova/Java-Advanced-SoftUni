import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Double> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVat = number -> number * 1.20;

        System.out.println("Prices with VAT:");

        for (Double number : numbers) {
           double priceWithVat =  addVat.apply(number);
            System.out.printf("%.2f%n" , priceWithVat);
        }
    }
}
