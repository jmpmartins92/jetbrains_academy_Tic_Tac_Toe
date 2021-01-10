import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        char[][] star = new char[size][size];

        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            for (int colIndex = 0; colIndex < size; colIndex++) {
                if (rowIndex == colIndex ||
                        rowIndex  == size / 2 ||
                        colIndex  == size / 2 ||
                        rowIndex == size - colIndex - 1) {
                    star[rowIndex][colIndex] = '*';
                } else {
                    star[rowIndex][colIndex] = '.';
                }

            }
        }

        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            for (int colIndex = 0; colIndex < size; colIndex++) {
                System.out.print(star[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }
    }
}