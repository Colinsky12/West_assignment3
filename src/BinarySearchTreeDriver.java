import java.util.Scanner;

public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String listType = scanner.nextLine();
        boolean typeSelected = false;
        while (!typeSelected) {
            if (listType.equals("i")) {
                BinarySearchTree<Integer> tree = new BinarySearchTree<>();
                typeSelected = true;
                runCompatible(scanner, tree, listType);
            } else if (listType.equals("d")) {
                BinarySearchTree<Double> tree = new BinarySearchTree<>();
                typeSelected = true;
                runCompatible(scanner, tree, listType);
            } else if (listType.equals("s")) {
                BinarySearchTree<String> tree = new BinarySearchTree<>();
                typeSelected = true;
                runCompatible(scanner, tree, listType);
            } else {
                System.out.print("Invalid list type. Please try again: ");
                listType = scanner.nextLine();
            } //if-else 
        } //while type not selected
    } //main

    private static <T extends Comparable<T>> void runCompatible(Scanner scanner, BinarySearchTree<T> tree, String listType) {
        System.out.println("Commands:\n(i) - Insert Item\n(d) - Delete Item\n(p) - Print Tree\n(r) - Retrieve Item\n(l) - Count Leaf Nodes\n(s) - Find Single Parents\n(c) - Find Cousins\n(q) - Quit Program"); 
        String previous = "i";
        String input = doCommandCycle(scanner, previous, tree, listType);
        while (!input.equalsIgnoreCase("q")) {
            previous = input;
            input = doCommandCycle(scanner, previous, tree, listType);
        } //while user hasn't quit
    } //runCompatible

    private static <T extends Comparable<T>> String doCommandCycle(Scanner scanner, String previous, BinarySearchTree<T> tree, String listType) {
        if (!previous.equalsIgnoreCase("invalid")) {
            System.out.print("Enter a command: ");
        } //if
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("i")) {
            tree.inOrder();
            tree.setPrintDuplicates(true);
            if(listType.equals("s")) {
                System.out.print("Enter a string to insert: ");
                T insertionVal = (T) scanner.nextLine();
                tree.insert(insertionVal);
            } else {
                System.out.print("Enter a number to insert: ");
                if (listType.equals("i")) {
                    T insertionVal = (T) Integer.valueOf(scanner.nextLine());
                    tree.insert(insertionVal);
                } else {
                    T insertionVal = (T) Double.valueOf(scanner.nextLine());
                    tree.insert(insertionVal);
                } //if-else list is int
            } //if-else list is string
            tree.inOrder();
        } else if (input.equalsIgnoreCase("d")) {
            tree.inOrder();
            tree.setPrintDuplicates(true);
            if(listType.equals("s")) {
                System.out.print("Enter a string to delete: ");
                T insertionVal = (T) scanner.nextLine();
                tree.delete(insertionVal);
            } else {
                System.out.print("Enter a number to delete: ");
                if (listType.equals("i")) {
                    T insertionVal = (T) Integer.valueOf(scanner.nextLine());
                    tree.delete(insertionVal);
                } else {
                    T insertionVal = (T) Double.valueOf(scanner.nextLine());
                    tree.delete(insertionVal);
                } //if-else list is int
            } //if-else list is string
            tree.inOrder();
        } else if (input.equalsIgnoreCase("p")) {
            tree.inOrder();
        } else if (input.equalsIgnoreCase("r")) {
            tree.inOrder();
            if(listType.equals("s")) {
                System.out.print("Enter a string to search: ");
                T insertionVal = (T) scanner.nextLine();
                tree.retrieve(insertionVal);
            } else {
                System.out.print("Enter a number to search: ");
                if (listType.equals("i")) {
                    T insertionVal = (T) Integer.valueOf(scanner.nextLine());
                    tree.retrieve(insertionVal);
                } else {
                    T insertionVal = (T) Double.valueOf(scanner.nextLine());
                    tree.retrieve(insertionVal);
                } //if-else list is int
            } //if-else list is string
            tree.setPrintDuplicates(true);
        } else if (input.equalsIgnoreCase("l")) {
        } else if (input.equalsIgnoreCase("s")) {
            tree.inOrder();
            tree.getSingleParent();
        } else if (input.equalsIgnoreCase("c")) {
        } else if (input.equalsIgnoreCase("q")) {
            System.out.println("Exiting the program...");
        } else {
            System.out.print("Invalid command. Please try again. ");
            input = "invalid";
        } //if-else
        return input;
    } //doCommandCycle
    } //BinarySearchTreeDriver
