import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = scanner.nextInt();
        }
        int[] newArray = new int[lenght];
        newArray[0] = array[lenght - 1];
        System.out.print(newArray[0] + " ");
        for (int j = 1; j < lenght; j++) {
            newArray[j] = array[j - 1];
            System.out.print(newArray[j] + " ");
        }

    }
}