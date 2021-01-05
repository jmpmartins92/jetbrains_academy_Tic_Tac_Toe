import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int count = 0;
        for (int j = 0; j < length - 2; j++) {
            if (array[j + 2] == array[j + 1] + 1 && array[j + 1] == array[j] + 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}