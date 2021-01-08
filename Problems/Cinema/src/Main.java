import java.util.Scanner;
import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int[] seats = new int[k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - seats.length + 1; j++) {
                int[] subArray = copyOfRange(matrix[i], j, j + seats.length);
                if (Arrays.equals(subArray, seats)) {
                    System.out.println(i + 1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}