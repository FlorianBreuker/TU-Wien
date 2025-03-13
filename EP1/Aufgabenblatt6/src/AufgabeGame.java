/*
    Aufgabe 1) Zweidimensionale Arrays und Rekursion - Game "TicTacToe"
*/

import codedraw.*;

import java.awt.*;

public class AufgabeGame {
    public static void main(String[] args) {
        int size = 600;

        CodeDraw canvas = new CodeDraw(size, size);
        canvas.setTitle("Tic Tac Toe");
        EventScanner eventScanner = canvas.getEventScanner();

        boolean gameRunning = true;

        while(!canvas.isClosed()) {
            canvas.clear();
            boolean playersChoice = getLobbyInput(eventScanner, canvas);
            boolean[] gameResult = game(canvas, eventScanner, playersChoice);

            postGame(canvas, gameResult[0], gameResult[1], eventScanner);
        }
    }

    private static boolean getLobbyInput(EventScanner scanner, CodeDraw canvas) {
        TextFormat textFormat = new TextFormat();
        canvas.setTextFormat(textFormat);
        textFormat.setFontSize(40);
        textFormat.setBold(true);

        double playButtonWidth = 200;
        double playButtonHeight = 60;
        double playButtonX = (double) canvas.getWidth() / 2 - playButtonWidth / 2;
        double playButtonY = canvas.getHeight() - playButtonWidth;

        drawPlayButton(canvas, playButtonX, playButtonY, playButtonWidth, playButtonHeight);

        double selectGameModeSize = 100;
        double selectGameModeX = (double) canvas.getWidth() / 3 - selectGameModeSize / 2;
        double selectGameModeY = 200;

        drawGameMode(canvas, selectGameModeX, selectGameModeY, selectGameModeSize, "=1", Color.lightGray);
        drawGameMode(canvas, selectGameModeX * 2 + selectGameModeSize / 2, selectGameModeY, selectGameModeSize,
                ">1", Color.gray);

        canvas.show();

        // true ... multiplayer, false ... single player vs bot
        boolean gameMode = true;
        boolean selectPlay = false;

        while (!canvas.isClosed() && !selectPlay) {
            if (scanner.hasMouseClickEvent()) {
                MouseClickEvent mouseClickEvent = scanner.nextMouseClickEvent();
                int x = mouseClickEvent.getX();
                int y = mouseClickEvent.getY();

                if (x >= playButtonX && x <= playButtonX + playButtonWidth && y >= playButtonY &&
                        y <= playButtonY + playButtonHeight) {
                    selectPlay = true;
                }
                if (x >= selectGameModeX && x <= selectGameModeX + selectGameModeSize && y >= selectGameModeY &&
                        y <= selectGameModeY + selectGameModeSize) {
                    gameMode = false;

                    drawGameMode(canvas, selectGameModeX, selectGameModeY, selectGameModeSize, "=1", Color.gray);
                    drawGameMode(canvas, selectGameModeX * 2 + selectGameModeSize / 2, selectGameModeY,
                            selectGameModeSize, ">1", Color.lightGray);
                }
                if (x >= selectGameModeX * 2 + selectGameModeSize / 2 &&
                        x <= selectGameModeX * 2 + selectGameModeSize * 1.5 &&
                        y >= selectGameModeY && y <= selectGameModeY + selectGameModeSize) {
                    gameMode = true;

                    drawGameMode(canvas, selectGameModeX, selectGameModeY, selectGameModeSize,
                            "=1", Color.lightGray);
                    drawGameMode(canvas, selectGameModeX * 2 + selectGameModeSize / 2, selectGameModeY,
                            selectGameModeSize, ">1", Color.gray);
                }
            } else {
                scanner.nextEvent();
            }
            canvas.show();
        }
        return gameMode;
    }

    private static void drawPlayButton(CodeDraw canvas, double x, double y, double width, double height) {
        canvas.drawRectangle(x, y, width, height);
        canvas.setColor(Color.GREEN);
        canvas.fillRectangle(x, y, width, height);
        canvas.setColor(Color.BLACK);
        canvas.drawText(x + 50, y + 12, "PLAY");
    }

    private static void drawGameMode(CodeDraw canvas, double x, double y, double size, String text, Color color) {
        canvas.setColor(color);
        canvas.fillSquare(x, y, size);
        canvas.setColor(Color.BLACK);
        canvas.drawText(x + 10, y + 10, text);
    }

    private static boolean[] game(CodeDraw canvas, EventScanner eventScanner, boolean gameMode) {
        //gameMode: true ... human vs. human, false ... human vs. computer
        boolean player = true; //(1Player) human = true, computer = false, (2Player) human1 = true, human2 = false
        int maxDepth = 8;
        boolean gameRunning = true;
        boolean isWin = false;

        char[][] gameBoard = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        while (!canvas.isClosed() && gameRunning) {
            if (eventScanner.hasMouseClickEvent()) {
                // TODO: Implementieren Sie hier Ihre Lösung für den if-Zweig
                MouseClickEvent clickEvent = eventScanner.nextMouseClickEvent();
                int currentX = clickEvent.getX();
                int currentY = clickEvent.getY();

                player = makeAPlayerMove(canvas, gameBoard, player, currentX, currentY);
            } else if (!gameMode && !player) {
                // TODO: Implementieren Sie hier Ihre Lösung für den else-if-Zweig
                int[] computersMove = minimax(gameBoard, player, maxDepth);
                int computerRow = computersMove[0];
                int computerCol = computersMove[1];

                gameBoard[computerRow][computerCol] = 'O';
                player = true;
            } else {
                eventScanner.nextEvent();
            }

            if (checkIfWinner(gameBoard, !player)) {
                gameRunning = false;
                isWin = true;
            } else if (checkIfFull(gameBoard)) {
                gameRunning = false;
            }
            canvas.clear();
            drawGameBoard(canvas, gameBoard);
        }
        canvas.show();

        return new boolean[]{player, isWin};
    }

    private static void postGame(CodeDraw canvas, boolean player, boolean isWin, EventScanner eventScanner) {
        String winnerText = "";
        double gameOverY = canvas.getHeight() / 2.0 - canvas.getTextFormat().getFontSize();
        double halfGameField = canvas.getHeight() / 2.0;

        double playAgainWidth = 200;
        double playAgainHeight = 60;

        boolean newGame = false;


        if (isWin) {
            if (!player) {
                winnerText = "Player X wins";
            } else {
                winnerText = "Player O wins";
            }
            canvas.drawText(halfGameField - 125, gameOverY, winnerText);

        } else {
            canvas.drawText(halfGameField - 30, gameOverY, "Tie!");
        }

        canvas.setColor(Palette.MEDIUM_PURPLE);
        canvas.fillRectangle(halfGameField - playAgainWidth / 2, gameOverY + 2 * playAgainHeight,
                playAgainWidth, playAgainHeight);

        canvas.setColor(Palette.BLACK);
        canvas.getTextFormat().setFontSize(25);
        canvas.drawText(halfGameField - 75, gameOverY + 2 * playAgainHeight + 20, "Play Again?");

        canvas.show();

        while (!canvas.isClosed() && !newGame) {
            if (eventScanner.hasMouseClickEvent()) {
                MouseClickEvent clickEvent = eventScanner.nextMouseClickEvent();
                int x = clickEvent.getX();
                int y = clickEvent.getY();

                if (x >= halfGameField - playAgainWidth / 2 && x <= halfGameField + playAgainWidth / 2 &&
                        y >= gameOverY + 2 * playAgainHeight && y <= gameOverY + 3 * playAgainHeight) {
                    newGame = true;
                }

            } else {
                eventScanner.nextEvent();
            }
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
        for (char[] chars : gameBoard) {
            for (char aChar : chars) {
                if (aChar == ' ') {
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

        for (char[] chars : gameBoard) {
            if (chars[0] == trigger && chars[1] == trigger && chars[2] == trigger) {
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
