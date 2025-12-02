package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = sc.nextLine();
        State result = Test.process(input);
        System.out.println("Кінцевий стан: " + result);
    }
}