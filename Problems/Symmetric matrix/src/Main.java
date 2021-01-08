import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        boolean test = true;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] != matrix[j][i]) {
                    test = false;
                    break;
                }
            }
            if (!test) {
                System.out.println("NO");
                break;
            }
        }
        if (test) {
            System.out.println("YES");
        }
    }
}