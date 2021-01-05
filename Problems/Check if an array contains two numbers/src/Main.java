import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean test = true;
        for (int j = 0; j < length - 1; j++) {
            if (array[j] == n && array[j + 1] == m) {
                System.out.println(true);
                test = true;
                break;
            } else if (array[j] == m && array[j + 1] == n) {
                System.out.println(true);
                test = true;
                break;
            } else {
                test = false;
            }
        } if (!test) {
            System.out.println(false);
        }
    }
}