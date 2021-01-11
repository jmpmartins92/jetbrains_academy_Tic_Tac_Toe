package tictactoe;

        import java.util.Arrays;
        import java.util.Scanner;
        import java.util.regex.*;

public class Main {

    private static void printGameState(char[][] gameState) {
        System.out.println("---------");
        System.out.println("| " + gameState[0][0] + " " + gameState[0][1] + " " + gameState[0][2] + " |");
        System.out.println("| " + gameState[1][0] + " " + gameState[1][1] + " " + gameState[1][2] + " |");
        System.out.println("| " + gameState[2][0] + " " + gameState[2][1] + " " + gameState[2][2] + " |");
        System.out.println("---------");
    }

    private static int countChar(String mapping, char symbol) {
        int numSymbol = 0;
        for (int charIndex = 0; charIndex < mapping.length(); charIndex++) {
            if (mapping.charAt(charIndex) == symbol) {
                numSymbol++;
            }
        }
        return numSymbol;
    }

    private static boolean testImpossible(String mapping) {
        boolean test = false;
        if (countChar(mapping, 'X') - countChar(mapping, 'O') >= 2 ||
                countChar(mapping, 'O') - countChar(mapping, 'X') >= 2) {
            test = true;
            return test;
        }
        if (countChar(mapping, 'X') >= 3 && countChar(mapping, 'O') >= 3)
        {
            for (int stringIndex = 0; stringIndex < 4; stringIndex +=3) {
                if (mapping.charAt(stringIndex) != 'X' &&
                        mapping.charAt(stringIndex) == mapping.charAt(stringIndex + 1) &&
                        mapping.charAt(stringIndex + 1) == mapping.charAt(stringIndex + 2) &&
                        (mapping.charAt(stringIndex + 3) != mapping.charAt(stringIndex) &&
                                mapping.charAt(stringIndex + 3) == mapping.charAt(stringIndex + 4) &&
                                mapping.charAt(stringIndex + 4) == mapping.charAt(stringIndex + 5))) {
                    test = true;
                    return test;
                }
            }
            for (int colIndex = 0; colIndex < 2; colIndex ++) {
                if (mapping.charAt(colIndex) != ' ' &&
                        mapping.charAt(colIndex) == mapping.charAt(colIndex + 3) &&
                        mapping.charAt(colIndex + 3) == mapping.charAt(colIndex + 6) &&
                        (mapping.charAt(colIndex + 1) != mapping.charAt(colIndex) &&
                                mapping.charAt(colIndex + 1) == mapping.charAt(colIndex + 4) &&
                                mapping.charAt(colIndex + 4) == mapping.charAt(colIndex + 7))) {
                    test = true;
                    return test;
                }
            }
        }


        return test;
    }

    private static boolean testGameNotFinished(String mapping, char win) {
        boolean test = false;
        if (countChar(mapping, ' ') > 0 && win != 'X' && win != 'O') {
            test = true;
        }
        return test;
    }

    private static char win(char[][] gameState) {
        char symbolWin = 0;
        char[] winCol = new char[3];
        char[] winRow = new char[3];
        if (gameState[0][0] != '_' && gameState[0][0] == gameState[1][1] && gameState[1][1] == gameState[2][2]) {
            symbolWin = gameState[0][0];
            return symbolWin;
        } else if (gameState[0][0] != '_' && gameState[0][2] == gameState[1][1] && gameState[1][1] == gameState[2][0]) {
            symbolWin = gameState[0][2];
            return symbolWin;
        } else {
            for (int colCounter = 0; colCounter < 3; colCounter++) {
                for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
                    for (int colIndex = 0; colIndex < 3; colIndex++) {
                        winRow[colIndex] = gameState[rowIndex][colIndex];
                        if (colIndex == 2) {
                            if (winRow[0] == winRow[1] && winRow[1] == winRow[2] && winRow[0] != '_') {
                                symbolWin = winRow[0];
                                return symbolWin;
                            } else {
                                if (winRow[0] != winRow[1] || winRow[1] != winRow[2]) {
                                    Arrays.fill(winRow, '0');
                                }
                            }
                        }
                    }
                    winCol[rowIndex] = gameState[rowIndex][colCounter];
                    if (rowIndex == 2) {
                        if (winCol[0] == winCol[1] && winCol[1] == winCol[2] && winCol[0] != ' ') {
                            symbolWin = winCol[0];
                            return symbolWin;
                        } else {
                            if (winCol[0] != winCol[1] || winCol[1] != winCol[2]) {
                                Arrays.fill(winCol, '0');
                            }
                        }
                    }
                }
                colCounter++;
            }
        }
        return symbolWin;
    }


    private static String testInputUser(String inputUser, char[][] gameState) {
        String testResult = "Passed";
        int inputY = Character.getNumericValue(inputUser.charAt(0));
        int inputX = Character.getNumericValue(inputUser.charAt(2));
        if (Pattern.matches("\\D", inputUser)) {
            testResult = "You should enter numbers!";
            return testResult;
        }
        if (inputUser.length() > 3 || inputUser.charAt(1) != ' ') {
            testResult = "Coordinates should be from 1 to 3!";
            return testResult;
        }
        if (inputY > 3 || inputY < 1 || inputX > 3 || inputX < 1) {
            testResult = "Coordinates should be from 1 to 3!";
            return testResult;
        }
        if (gameState[inputY - 1][inputX - 1] != ' ') {
            testResult = "This cell is occupied! Choose another one!";
            return testResult;
        }
        testResult = "Passed";
        return testResult;
    }

    private static void testGameState (String mapping, char[][]gameState) {
        if (win(gameState) == 'X') {
            System.out.println("X wins");
        } else if (win(gameState) == 'O') {
            System.out.println("O wins");
        } else if (mapping.indexOf(' ') == -1) {
            System.out.println("Draw");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mapping = "         ";
        char[][] gameState = new char[3][3];


        int charIndex = 0;
        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int colIndex = 0; colIndex < 3; colIndex++) {
                gameState[rowIndex][colIndex] = mapping.charAt(charIndex);
                charIndex++;
            }
        }

        printGameState(gameState);
        int numPlayer = 1;
        char charPlayer = 'X';

        String inputUser = scanner.nextLine();
        int inputY = Character.getNumericValue(inputUser.charAt(0));
        int inputX = Character.getNumericValue(inputUser.charAt(2));

        while (testGameNotFinished(mapping, win(gameState))) {
            while (testInputUser(inputUser, gameState) != "Passed") {
                System.out.println(testInputUser(inputUser, gameState));
                inputUser = scanner.nextLine();
                inputY = Character.getNumericValue(inputUser.charAt(0));
                inputX = Character.getNumericValue(inputUser.charAt(2));
                testInputUser(inputUser, gameState);
            }
            if (testInputUser(inputUser, gameState) == "Passed") {
                gameState[inputY - 1][inputX - 1] = charPlayer;
                printGameState(gameState);
                int indexUpdated = (inputY - 1) * 3 + (inputX - 1);
                char[] mappingArray = mapping.toCharArray();
                mappingArray[indexUpdated] = charPlayer;
                mapping = String.valueOf(mappingArray);
                if (numPlayer == 2) {
                    charPlayer = 'O';
                    numPlayer--;
                } else {
                    charPlayer = 'X';
                    numPlayer++;
                }
            }


        }
        testGameState(mapping, gameState);

    }
}
