import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String linesInput = new String();


        while (scanner.hasNextInt()) {
            linesInput += scanner.nextLine();
            linesInput += "\n";
        }

        String[] lines = linesInput.split("\n");
        int numRows = lines.length;
        int numCols = lines[0].split(" ").length;
        int[][] inputMatrix = new int[numRows][numCols];

        for (int lineID = 0; lineID < lines.length; lineID++) {
            String[] line = lines[lineID].split(" ");
            for (int columnID = 0; columnID < line.length; columnID++) {
                inputMatrix[lineID][columnID] = Integer.parseInt(line[columnID]);
            }
        }

        int[][] newMatrix = new int[numRows][numCols];
        int[][] auxMatrix = new int[numRows + 2][numCols + 2];
        for (int rowAuxMatrix = 0; rowAuxMatrix < numRows + 2; rowAuxMatrix++) {
            for (int colAuxMatrix = 0; colAuxMatrix < numCols + 2; colAuxMatrix++) {
                if (rowAuxMatrix == 0 && 0 < colAuxMatrix && colAuxMatrix < numCols + 1) {
                    auxMatrix[0][colAuxMatrix] = inputMatrix[numRows - 1][colAuxMatrix - 1];

                } else if (rowAuxMatrix == numRows + 1 && 0 < colAuxMatrix && colAuxMatrix < numCols + 1) {
                    auxMatrix[numRows + 1][colAuxMatrix] = inputMatrix[0][colAuxMatrix - 1];

                } else if (colAuxMatrix == 0 && 0 < rowAuxMatrix && rowAuxMatrix < numRows + 1) {
                    auxMatrix[rowAuxMatrix][0] = inputMatrix[rowAuxMatrix - 1][numCols - 1];

                } else if (colAuxMatrix == numCols + 1 && 0 < rowAuxMatrix && rowAuxMatrix < numRows + 1) {
                    auxMatrix[rowAuxMatrix][colAuxMatrix] = inputMatrix[rowAuxMatrix - 1][0];

                } else if (rowAuxMatrix > 0 && rowAuxMatrix < numRows + 1 &&
                        colAuxMatrix > 0 && colAuxMatrix < numCols + 1) {
                    auxMatrix[rowAuxMatrix][colAuxMatrix] = inputMatrix[rowAuxMatrix - 1][colAuxMatrix - 1];
                }

            }
        }

        for (int rowAuxMatrix = 0; rowAuxMatrix < numRows + 2; rowAuxMatrix++) {
            for (int colAuxMatrix = 0; colAuxMatrix < numCols + 2; colAuxMatrix++) {
                if (rowAuxMatrix > 0 && rowAuxMatrix < numRows + 1 &&
                        colAuxMatrix > 0 && colAuxMatrix < numCols + 1) {
                    newMatrix[rowAuxMatrix - 1][colAuxMatrix - 1] = auxMatrix[rowAuxMatrix - 1][colAuxMatrix] +
                            auxMatrix[rowAuxMatrix + 1][colAuxMatrix] +
                            auxMatrix[rowAuxMatrix][colAuxMatrix - 1] +
                            auxMatrix[rowAuxMatrix][colAuxMatrix + 1];
                }
            }
        }

        System.out.println();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
