package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mapping = scan.nextLine();


        System.out.println("---------");
        System.out.println("| " + mapping.charAt(0) + " " + mapping.charAt(1) + " " + mapping.charAt(2) + " |");
        System.out.println("| " + mapping.charAt(3) + " " + mapping.charAt(4) + " " + mapping.charAt(5) + " |");
        System.out.println("| " + mapping.charAt(6) + " " + mapping.charAt(7) + " " + mapping.charAt(8) + " |");
        System.out.println("---------");
    }
}
