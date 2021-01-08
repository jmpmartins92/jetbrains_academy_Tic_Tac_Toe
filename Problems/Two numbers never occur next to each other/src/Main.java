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
        for (int i = 1; i < length; i++) {
            if (array[i] == n) {
                if (array[i - 1] == m) {
                    test = false;
                    break;
                }
            } else if (array[i] == m) {
                if (array[i - 1] == n) {
                    test = false;
                    break;
                }
            }
        }
        System.out.println(test);
    }
}