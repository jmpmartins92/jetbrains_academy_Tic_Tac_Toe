import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int max = -999_999;
        for (int i = 1; i < length; i++) {
            int product = array[i] * array[i - 1];
            if (product > max) {
                max = product;
            }
        }
        System.out.println(max);
    }
}