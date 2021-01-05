import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int[] arraySorted = Arrays.copyOf(array, length);
        Arrays.sort(arraySorted);
        if (Arrays.compare(array, arraySorted) == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


    }
}