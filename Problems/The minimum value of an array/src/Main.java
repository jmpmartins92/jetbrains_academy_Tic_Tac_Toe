import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int min = 9999999;
        for (int j = 0; j < length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.println(min);
    }
}