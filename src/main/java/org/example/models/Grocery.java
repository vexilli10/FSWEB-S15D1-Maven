package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {
        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.print("Enter choice (0 quit, 1 add, 2 remove): ");
            String line = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, try again.");
                continue;
            }
            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Exiting grocery app.");
                    break;
                case 1:
                    System.out.print("Enter item(s) to add (comma separated or single): ");
                    addItems(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter item(s) to remove (comma separated or single): ");
                    removeItems(scanner.nextLine());
                    break;
                default:
                    System.out.println("Unknown option.");
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nGrocery App Commands:");
        System.out.println("  0 - Quit");
        System.out.println("  1 - Add item(s)");
        System.out.println("  2 - Remove item(s)\n");
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String raw : items) {
            String item = raw.trim();
            if (checkItemIsInList(item)) {
                System.out.println(item + " is already in the list.");
            } else {
                groceryList.add(item);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String raw : items) {
            String item = raw.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " is not in the list.");
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\nCurrent grocery list:");
        for (String item : groceryList) {
            System.out.println("  - " + item);
        }
        System.out.println();
    }
}
