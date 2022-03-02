package com.cs.canvas;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Enter Command : ");
                String input = scanner.nextLine();
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(input);
                if(!matcher.matches()) {
                    System.out.println("Not matching");
                }
                if ("Q".equals(input.toUpperCase())) {
                    System.exit(0);
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
