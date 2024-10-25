/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe5 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int pixelWidth = 300;
        int pixelHeight = 300;

        double numSquares = 5;
        double squareLength = pixelHeight / numSquares;

        if (numSquares % 2 == 0 || numSquares < 5 || numSquares > 19) {
            System.out.println("The number of squares must be an uneven number between 5 and 19 (incl. 5 and 19)");
        } else {
            CodeDraw myDrawObj = new CodeDraw(pixelWidth, pixelHeight);

            myDrawObj.setCanvasPositionX(1500);
            myDrawObj.setCanvasPositionY(300);

            //draws the blue square in the bottom left of each canvas
            myDrawObj.setColor(Palette.BLUE);
            myDrawObj.setLineWidth(2);
            myDrawObj.drawSquare(0, pixelHeight - squareLength, squareLength);
            // draws the red squares in the top line
            // iterates to the end of the top line minus one full square
            for (double i = 0; i <= Math.ceil(pixelWidth - (squareLength * 2)); i += squareLength) {
                myDrawObj.setColor(Palette.RED);
                myDrawObj.setLineWidth(4);
                myDrawObj.drawSquare(i, 0, squareLength);
                //draws the red squares in the bottom line of the canvas, starting by the second full square
                if (i >= squareLength && i <= Math.ceil(((pixelWidth / 2.0)) - (squareLength / 2.0) - squareLength)) {
                    myDrawObj.drawSquare(i, pixelHeight - squareLength, squareLength);
                }
            }
            // draws the diagonal blue squares, iterates from x max back to the middle of the canvas
            for (double i = pixelWidth - squareLength; i >= Math.ceil(pixelWidth / 2.0) - squareLength; i -= squareLength) {
                myDrawObj.setColor(Palette.BLUE);
                myDrawObj.setLineWidth(2);
                //adds square length to the y position of the square for every x gone left
                myDrawObj.drawSquare(i, pixelHeight - i - squareLength, squareLength);
            }
            // draws the red squares, from the bottom up to the last blue square.(beginning in the middle of the canvas)
            for (double i = pixelHeight - squareLength; i >= (pixelWidth / 2.0); i -= squareLength) {
                myDrawObj.setColor(Palette.RED);
                myDrawObj.setLineWidth(4);
                //the x stays the same, y gets added squareLength in every iteration until reaching the mid
                myDrawObj.drawSquare(pixelWidth / 2.0 - (squareLength / 2), i, squareLength);
            }
            myDrawObj.show();
        }
    }
}