import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int counter = 1;
        int direction = 1;
        int rightCount = 0;
        int downCount = 0;
        int leftCount = 0;
        int upCount = 0;

        int[][] matrix = new int[n][n];


        while (counter <= n * n) {
            if (direction == 1) {
                for (int i = upCount; i < n - downCount; i++) {
                    matrix[rightCount][i] = counter;
                    counter++;
                }
                rightCount++;
                direction = 2;
                continue;
            }

            if (direction == 2) {
                for (int i = rightCount; i < n - leftCount; i++) {
                    matrix[i][n - 1 - downCount] = counter;
                    counter++;
                }
                downCount++;
                direction = 3;
                continue;
            }

            if (direction == 3) {
                for (int i = n - 1 - downCount; i >= upCount; i--) {
                    matrix[n - 1 - leftCount][i] = counter;
                    counter++;
                }
                leftCount++;
                direction = 4;
                continue;
            }

            if (direction == 4) {
                for (int i = n - 1 - leftCount; i >= rightCount; i--) {
                    matrix[i][upCount] = counter;
                    counter++;
                }
                upCount++;
                direction = 1;
                continue;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}