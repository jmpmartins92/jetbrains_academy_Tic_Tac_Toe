import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int counter = 1;
        int counterMax = 1;
        for (int i = 1; i < length; i++) {
            if (array[i] >= array[i - 1]) {
                counter++;
                if (counterMax < counter) {
                    counterMax = counter;
                }
            } else {
                counter = 1;
            }
        }
        System.out.println(counterMax);
    }
}