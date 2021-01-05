import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lenght = scan.nextInt();
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = scan.nextInt();
        }
        int n = scan.nextInt();
        int counter = 0;
        for (int j = 0; j < lenght; j++) {
            if (array[j] == n) {
                counter++;
            }
        }
        System.out.println(counter);

    }
}