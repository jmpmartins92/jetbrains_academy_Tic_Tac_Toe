import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();

        int[][] matrixInput = new int[numRows][numCols];

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                matrixInput[rowIndex][colIndex] = scanner.nextInt();
            }
        }

        int i = scanner.nextInt();
        int j =  scanner.nextInt();

        int[][] matrixOutput = new int[numRows][numCols];


        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                if (colIndex == i) {
                    matrixOutput[rowIndex][colIndex] = matrixInput[rowIndex][j];
                } else if (colIndex == j) {
                    matrixOutput[rowIndex][colIndex] = matrixInput[rowIndex][i];
                } else {
                    matrixOutput[rowIndex][colIndex] = matrixInput[rowIndex][colIndex];
                }
            }
        }

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                System.out.print(matrixOutput[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }
    }
}