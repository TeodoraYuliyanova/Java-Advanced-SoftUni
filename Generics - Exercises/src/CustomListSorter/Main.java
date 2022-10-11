package CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] commandsParts = line.split("\\s+");
            String command = commandsParts[0];

            switch (command) {

                case "Add":
                    String elementToAdd = commandsParts[1];
                    list.add(elementToAdd);

                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(commandsParts[1]);
                    list.remove(indexToRemove);

                    break;

                case "Contains":
                    String element = commandsParts[1];
                    System.out.println(list.contains(element));

                    break;

                case "Swap":
                    int index1 = Integer.parseInt(commandsParts[1]);
                    int index2 = Integer.parseInt(commandsParts[2]);
                    list.swap(index1, index2);

                    break;

                case "Greater":
                    String elementToCompare = commandsParts[1];
                    System.out.println(list.countGreaterThan(elementToCompare));

                    break;

                case "Max":
                    System.out.println(list.getMax());

                    break;

                case "Min":
                    System.out.println(list.getMin());

                    break;

                case "Sort":
                    Sorter.sort(list);
                    break;

                case "Print":
                    System.out.println(list);

                    break;

            }
            line = scanner.nextLine();
        }

    }
}
