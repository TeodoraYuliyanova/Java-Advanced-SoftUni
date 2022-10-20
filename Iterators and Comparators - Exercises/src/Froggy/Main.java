package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {

            numbers = Arrays.stream(line.split(", ")).map(Integer::parseInt).collect(Collectors.toList());

            line = scanner.nextLine();

        }

        Lake lake = new Lake(numbers);

        List<String> result = new ArrayList<>();

        for (Integer integer : lake) {
            result.add(integer + "");
        }

        System.out.println(String.join(", " , result));
    }
}
