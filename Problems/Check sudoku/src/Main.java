import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallSquare = scanner.nextInt();
        int fullSquare = smallSquare * smallSquare;

        int[][] sudoku = new int[fullSquare][fullSquare]; //reading Sudoku Table
        for (int i = 0; i < fullSquare; i++) {
            for (int j = 0; j < fullSquare; j++) {
                sudoku[i][j] = scanner.nextInt();
            }
        }

        int[]sortedArray = new int[fullSquare]; //creating comparision array with sorted numbers from 1 to N
        for (int i = 1; i <= fullSquare; i++) {
            sortedArray[i - 1] = i;
        }

        int[] numInSmallSquare = new int[fullSquare]; //creating arrays that will hold values of each test cases
        int[] numInRow = new int[fullSquare];
        int[] numInCol = new int[fullSquare];
        int counter = 0; //auxiliary counter

        //running through each small square
        for (int squareRow = 0; squareRow < fullSquare; squareRow = squareRow + smallSquare) {
            for (int squareCol = 0; squareCol < fullSquare; squareCol = squareCol + smallSquare) {
                //adding values of small square to auxiliary array
                for (int i = 0; i < smallSquare; i++) {
                    for (int j = 0; j < smallSquare; j++) {
                        numInSmallSquare[counter] = sudoku[i + squareRow][j + squareCol];
                        counter++;
                    }
                }
                //checking if there are any repeated numbers inside each small squares
                Arrays.sort(numInSmallSquare);
                if (!Arrays.equals(numInSmallSquare, sortedArray)) {
                    System.out.println("NO");
                    System.exit(0);
                } else {
                    Arrays.fill(numInSmallSquare, 0);
                    counter = 0;
                }

            }
        }

        for (int i = 0; i < fullSquare; i++) {
            for (int j = 0; j < fullSquare; j++) {
                numInRow[j] = sudoku[i][j]; //adding values of Rows to auxiliary array
            }
            //checking if there are any repeated numbers inside each row
            Arrays.sort(numInRow);
            if (!Arrays.equals(numInRow, sortedArray)) {
                System.out.println("NO");
                System.exit(0);
            }

        }


        for (int numCol = 0; numCol < fullSquare; numCol++) {
            for (int i = 0; i < fullSquare; i++) {
                for (int j = 0; j < fullSquare; j++) {
                    for (int k = 0; k < fullSquare; k++) {
                        numInCol[k] = sudoku[k][i]; //adding values of Cols to auxiliary array
                    }
                }
            }
            //checking if there are any repeated numbers inside each col
            Arrays.sort(numInCol);
            if (!Arrays.equals(numInCol, sortedArray)) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }
}




