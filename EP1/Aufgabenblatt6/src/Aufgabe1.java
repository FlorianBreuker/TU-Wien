/*
    Aufgabe 1) Zweidimensionale Arrays und Rekursion - Game "TicTacToe"
*/

import codedraw.*;

import java.util.Scanner;

public class Aufgabe1 {
    public static void main(String[] args) {
        int size = 600;
        boolean twoPlayer = false; //true ... human vs. human, false ... human vs. computer
        boolean player = true; //(1Player) human = true, computer = false, (2Player) human1 = true, human2 = false
        int maxDepth = 8;
        boolean gameRunning = true;

        CodeDraw canvas = new CodeDraw(size, size);
        canvas.setTitle("Tic Tac Toe");
        EventScanner myEventSC = canvas.getEventScanner();

        char[][] gameBoard = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        while (!canvas.isClosed() && gameRunning) {
            if (myEventSC.hasMouseClickEvent()) {
                // TODO: Implementieren Sie hier Ihre Lösung für den if-Zweig
                MouseClickEvent clickEvent = myEventSC.nextMouseClickEvent();
                int currentX = clickEvent.getX();
                int currentY = clickEvent.getY();

                player = makeAPlayerMove(canvas, gameBoard, player, currentX, currentY);
            } else if (!twoPlayer && !player) {
                // TODO: Implementieren Sie hier Ihre Lösung für den else-if-Zweig
                int[] computersMove = minimax(gameBoard, player, maxDepth);
                int computerRow = computersMove[0];
                int computerCol = computersMove[1];

                gameBoard[computerRow][computerCol] = 'O';
                player = true;
            } else {
                myEventSC.nextEvent();
            }

            if (checkIfWinner(gameBoard, !player)) {
                gameRunning = false;
                System.out.println("Player " + !player + " wins");
            } else if (checkIfFull(gameBoard)) {
                gameRunning = false;
                System.out.println("Tie!");
            }
            canvas.clear();
            drawGameBoard(canvas, gameBoard);
        }
    }

    private static int[] minimax(char[][] gameBoard, boolean player, int depth) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[] retArray = new int[3];

        if (player) {
            retArray[2] = Integer.MAX_VALUE;
        } else {
            retArray[2] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    if (player) {
                        gameBoard[i][j] = 'X';
                    } else {
                        gameBoard[i][j] = 'O';
                    }
                    if (checkIfWinner(gameBoard, true)) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = -1;
                    } else if (checkIfWinner(gameBoard, false)) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = 1;
                    } else if (checkIfFull(gameBoard) || depth - 1 == 0) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = 0;
                    } else {
                        int[] tempArray = minimax(gameBoard, !player, depth - 1);
                        if (player) {
                            if (tempArray[2] < retArray[2]) {
                                retArray[0] = i;
                                retArray[1] = j;
                                retArray[2] = tempArray[2];
                            }
                        } else {
                            if (tempArray[2] > retArray[2]) {
                                retArray[0] = i;
                                retArray[1] = j;
                                retArray[2] = tempArray[2];
                            }
                        }
                    }
                    gameBoard[i][j] = ' ';
                }
            }
        }
        return retArray; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean checkIfFull(char[][] gameBoard) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean checkIfWinner(char[][] gameBoard, boolean player) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        char[] triggerSelection = new char[]{'X', 'O'};
        char trigger = triggerSelection[0];

        if (!player) {
            trigger = triggerSelection[1];
        }

        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0] == trigger && gameBoard[i][1] == trigger && gameBoard[i][2] == trigger) {
                return true;
            }
        }

        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[0][i] == trigger && gameBoard[1][i] == trigger && gameBoard[2][i] == trigger) {
                return true;
            }
        }

        if (gameBoard[0][0] == trigger && gameBoard[1][1] == trigger && gameBoard[2][2] == trigger) {
            return true;
        }

        if (gameBoard[0][2] == trigger && gameBoard[1][1] == trigger && gameBoard[2][0] == trigger) {
            return true;
        }

        return false; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean makeAPlayerMove(CodeDraw canvas, char[][] gameBoard, boolean player, int x, int y) {
        char[] currentShapeSelection = new char[]{'X', 'O'};
        char currentShape = currentShapeSelection[0];
        int firstSector = canvas.getWidth() / 3;
        int secondSector = (canvas.getHeight() / 3) * 2;
        if (!player) {
            currentShape = currentShapeSelection[1];
        }

        //[{X,0,0}, {0,0,0}, {0,0,0}]
        if (x >= 0 && x <= firstSector && y >= 0 && y <= firstSector && gameBoard[0][0] == ' ') {
            gameBoard[0][0] = currentShape;
        }
        //[{0,X,0}, {0,0,0}, {0,0,0}]
        else if (x > firstSector && x <= secondSector && y >= 0 && y <= firstSector && gameBoard[0][1] == ' ') {
            gameBoard[0][1] = currentShape;
        }
        //[{0,0,X}, {0,0,0}, {0,0,0}]
        else if (x > secondSector && x <= canvas.getWidth() && y >= 0 && y <= firstSector && gameBoard[0][2] == ' ') {
            gameBoard[0][2] = currentShape;
        }
        //[{0,0,0}, {X,0,0}, {0,0,0}]
        else if (x >= 0 && x <= firstSector && y > firstSector && y <= secondSector && gameBoard[1][0] == ' ') {
            gameBoard[1][0] = currentShape;
        }
        //[{0,0,0}, {0,X,0}, {0,0,0}]
        else if (x > firstSector && x <= secondSector && y > firstSector && y <= secondSector && gameBoard[1][1] == ' ') {
            gameBoard[1][1] = currentShape;
        }
        //[{0,0,0}, {0,0,X}, {0,0,0}]
        else if (x > secondSector && x <= canvas.getWidth() && y > firstSector && y <= secondSector && gameBoard[1][2] == ' ') {
            gameBoard[1][2] = currentShape;
        }
        //[{0,0,0}, {0,0,0}, {X,0,0}]
        else if (x >= 0 && x <= firstSector && y > secondSector && y <= canvas.getHeight() && gameBoard[2][0] == ' ') {
            gameBoard[2][0] = currentShape;
        }
        //[{0,0,0}, {0,0,0}, {0,X,0}]
        else if (x > firstSector && x <= secondSector && y > secondSector && y <= canvas.getHeight() && gameBoard[2][1] == ' ') {
            gameBoard[2][1] = currentShape;
        }
        //[{0,0,0}, {0,0,0}, {0,0,X}]
        else if (x > secondSector && x <= canvas.getWidth() && y > secondSector && y <= canvas.getHeight() && gameBoard[2][2] == ' ') {
            gameBoard[2][2] = currentShape;
        } else {
            // e.g. if field gets clicked the 2nd time
            return player;
        }
        return !player;
    }

    private static void drawMoves(CodeDraw canvas, boolean player, int startX, int startY, int endX, int endY) {
        if (player) {
            canvas.drawLine(startX, startY, endX, endY);
            canvas.drawLine(endX, startY, startX, endY);
        } else {
            double centerX = (startX + endX) / 2.0;
            double centerY = (startY + endY) / 2.0;
            double radius = (endX - startX) / 2.0;
            canvas.drawCircle(centerX, centerY, radius);
        }
    }

    private static void drawGameBoard(CodeDraw canvas, char[][] gameBoard) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int fieldSize = canvas.getHeight();
        int borderDistance = fieldSize / gameBoard.length;
        for (int i = 0; i < fieldSize; i += borderDistance) {
            canvas.drawLine(0, i, fieldSize, i);
            canvas.drawLine(i, 0, i, fieldSize);
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                int startX = j * fieldSize / 3;
                int startY = i * fieldSize / 3;
                int endX = (j + 1) * fieldSize / 3;
                int endY = (i + 1) * fieldSize / 3;

                if (gameBoard[i][j] == 'X') {
                    drawMoves(canvas, true, startX, startY, endX, endY);
                } else if (gameBoard[i][j] == 'O') {
                    drawMoves(canvas, false, startX, startY, endX, endY);
                }
            }
        }
        canvas.show();
    }

}
