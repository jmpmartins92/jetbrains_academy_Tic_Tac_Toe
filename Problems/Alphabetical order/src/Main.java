import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringIn = scanner.nextLine();
        String[] string = stringIn.split(" ");
        boolean test = false;
        for (int i = 0; i < string.length - 1; i++) {
            if (string[i].compareTo(string[i + 1]) > 0) {
                System.out.println(false);
                test = false;
                break;
            } else {
                test = true;
            }
        } if (test) {
            System.out.println(true);
        }

    }
}