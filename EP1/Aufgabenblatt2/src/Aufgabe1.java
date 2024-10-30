/*
    Aufgabe 1) Verschachtelte Schleifen - Optische Täuschung
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe1 {

    public static void main(String[] args) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int ws = 400;
        double r = (1.0 / 60.0) * ws;
        double bigSquareLength = 0.5 * ws - 2 * r;
        double bigSquareStartPosition = 0.25 * ws + r;
        double smallSquareLength = 2 * r;

        CodeDraw myDrawObj = new CodeDraw(ws, ws);

        myDrawObj.setCanvasPositionX(1700);
        myDrawObj.setCanvasPositionY(300);

        //fills the canvas with grey bordered black circles
        for (double i = 2 * r; i < ws; i += 4 * r) {
            for (double j = 2 * r; j < ws; j += 4 * r) {
                //draws the black part
                myDrawObj.setColor(Palette.BLACK);
                myDrawObj.fillCircle(j, i, r);
                //draws the grey part
                myDrawObj.setColor(Palette.GRAY);
                myDrawObj.setLineWidth(3);
                myDrawObj.drawCircle(j, i, r);
                myDrawObj.resetProperties();
            }
        }

        //fills the big white square int the middle of the canvas
        myDrawObj.setColor(Color.WHITE);
        myDrawObj.fillSquare(bigSquareStartPosition, bigSquareStartPosition, bigSquareLength);
        //draws the black border around the middle square
        myDrawObj.setColor(Color.BLACK);
        myDrawObj.setLineWidth(1);
        myDrawObj.drawSquare(bigSquareStartPosition, bigSquareStartPosition, bigSquareLength);

        //draws the small squares inside the middle square
        //starting from top left corner with a padding of r
        for (double i = bigSquareStartPosition + r; i < ws - bigSquareStartPosition; i += smallSquareLength * 2) {
            for (double j = bigSquareStartPosition + r; j < ws - bigSquareStartPosition; j += smallSquareLength * 2) {
                myDrawObj.drawSquare(j, i, smallSquareLength);
            }
        }
        myDrawObj.show();
    }
}
