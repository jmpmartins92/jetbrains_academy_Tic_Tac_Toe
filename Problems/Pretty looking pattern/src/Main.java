import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        char[][] matrix = new char[4][4];
        for (int i = 0; i < 4; i++) {
            String inputString = scanner.nextLine();
            matrix[i] = inputString.toCharArray();
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (matrix[i - 1][j - 1] == matrix[i - 1][j] &&
                        matrix[i - 1][j - 1] == matrix[i][j - 1] &&
                        matrix[i - 1][j - 1] == matrix[i][j]) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }
        System.out.println("YES");
    }
}