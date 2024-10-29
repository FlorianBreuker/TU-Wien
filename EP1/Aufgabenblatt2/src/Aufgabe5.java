import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.TextFormat;

import java.awt.*;

/*
    Aufgabe 5) Kreativaufgabe
*/
public class Aufgabe5 {

    public static void main(String[] args) {

        //TODO: Implementieren Sie hier Ihre Lösung für die KREATIVAUFGABE
        int hs = 660;
        int ws = 600;

        CodeDraw tetrisCanvas = new CodeDraw(ws, hs);
        TextFormat tetrisText = new TextFormat();
        tetrisCanvas.setTextFormat(tetrisText);

        tetrisCanvas.setCanvasPositionX(1700);
        tetrisCanvas.setCanvasPositionY(300);

        double stoneLength = 30;
        double playFieldBorderWidth = 10;
        double shapeBorderWidth = 3;

        Color fillerStoneColor = Palette.fromRGB(50, 50, 50);
        Color borderColor = Palette.fromRGB(204, 255, 255);
        Color fieldColor = Palette.fromRGB(0, 0, 0);
        Color sShapeColor = Palette.fromRGB(153, 255, 204);
        Color iShapeColor = Palette.fromRGB(204, 229, 255);
        Color textColor = Palette.WHITE;

        fillField(tetrisCanvas, 0, 0, ws, hs, fillerStoneColor);

        double playFieldX = stoneLength - shapeBorderWidth / 2;
        double playFieldWidth = 10 * stoneLength + shapeBorderWidth * 2;
        double playFieldHeight = 20 * stoneLength + shapeBorderWidth / 2;

        fillField(tetrisCanvas, playFieldX, stoneLength, playFieldWidth, playFieldHeight, fieldColor);

        double borderRectX = stoneLength / 2 + playFieldBorderWidth - shapeBorderWidth;
        double borderRectY = stoneLength / 2 + playFieldBorderWidth;
        double borderRectWidth = 10 * stoneLength + playFieldBorderWidth + shapeBorderWidth * 2;
        double borderRectHeight = 20 * stoneLength + playFieldBorderWidth + shapeBorderWidth;

        drawBorder(tetrisCanvas, borderRectX, borderRectY, borderRectWidth, borderRectHeight, borderColor, playFieldBorderWidth);

        double nextShapeIndicatorWidth = 4 * stoneLength;
        double nextShapeIndicatorHeight = 6 * stoneLength;
        double nextShapeIndicatorX = 12 * stoneLength;
        double nextShapeIndicatorY = (hs / 2.0) - nextShapeIndicatorHeight / 2;

        fillField(tetrisCanvas, nextShapeIndicatorX, nextShapeIndicatorY, nextShapeIndicatorWidth, nextShapeIndicatorHeight, fieldColor);
        drawBorder(tetrisCanvas, nextShapeIndicatorX, nextShapeIndicatorY, nextShapeIndicatorWidth, nextShapeIndicatorHeight, borderColor, 5);



        double nextShapeX = nextShapeIndicatorX + (nextShapeIndicatorWidth / 2) - stoneLength / 2;
        double nextShapeY = nextShapeIndicatorY + nextShapeIndicatorHeight - (1.5 * stoneLength);

        drawVerticalIShape(tetrisCanvas, nextShapeX, nextShapeY, stoneLength, iShapeColor, 3);


        double scoreIndicatorWidth = 7 * stoneLength;
        double scoreIndicatorHeight = 6 * stoneLength;

        fillField(tetrisCanvas, nextShapeIndicatorX, stoneLength, scoreIndicatorWidth, scoreIndicatorHeight, fieldColor);
        drawBorder(tetrisCanvas, nextShapeIndicatorX, stoneLength, scoreIndicatorWidth, scoreIndicatorHeight, borderColor, 2);




        double levelIndicatorWidth = 6 * stoneLength;
        double levelIndicatorHeight = 3 * stoneLength;
        double levelIndicatorY = nextShapeIndicatorY + nextShapeIndicatorHeight + stoneLength;

        fillField(tetrisCanvas, nextShapeIndicatorX, levelIndicatorY, levelIndicatorWidth, levelIndicatorHeight, fieldColor);
        drawBorder(tetrisCanvas, nextShapeIndicatorX, levelIndicatorY, levelIndicatorWidth, levelIndicatorHeight, borderColor, 2);



        drawHorizontalSShape(tetrisCanvas, stoneLength, hs - 2 * stoneLength, stoneLength, sShapeColor, 3);
        drawVerticalIShape(tetrisCanvas, 10 * stoneLength, hs - 2 * stoneLength, stoneLength, iShapeColor, 3);

        tetrisCanvas.setTextFormat(tetrisText);
        tetrisText.setFontSize(25);
        tetrisText.setBold(true);
        tetrisCanvas.setColor(textColor);
        tetrisCanvas.drawText(nextShapeIndicatorX + stoneLength / 2, 2 * stoneLength, "TOP\n726000\nSCORE\nB91200");
        tetrisCanvas.drawText(nextShapeIndicatorX + stoneLength / 2, nextShapeIndicatorY + stoneLength / 2, "NEXT");
        tetrisCanvas.drawText(nextShapeIndicatorX + stoneLength / 2, levelIndicatorY + 0.5 * stoneLength, "LEVEL\n01");


        tetrisCanvas.show();
    }

    private static void drawBorder(CodeDraw canvas, double x, double y, double width, double height, Color color, double lineWidth) {
        canvas.setColor(color);
        canvas.setLineWidth(lineWidth);
        canvas.drawRectangle(x, y, width, height);
        canvas.resetProperties();
    }

    private static void fillField(CodeDraw canvas, double x, double y, double width, double height, Color color) {
        canvas.setColor(color);
        canvas.fillRectangle(x, y, width, height);
        canvas.resetProperties();
    }

    private static void drawHorizontalSShape(CodeDraw canvas, double x, double y, double blockSize, Color color, double lineWidth) {
        Color shapeBorderColor = Palette.BLACK;
        for (double i = x; i < x + (3 * blockSize); i += blockSize) {
            if (i <= x + blockSize) {
                fillField(canvas, i, y, blockSize, blockSize, color);
                drawBorder(canvas, i, y, blockSize, blockSize, shapeBorderColor, lineWidth);
            }
            if (i >= x + blockSize) {
                fillField(canvas, i, y - blockSize, blockSize, blockSize, color);
                drawBorder(canvas, i, y - blockSize, blockSize, blockSize, shapeBorderColor, lineWidth);
            }
        }
    }

    private static void drawVerticalIShape(CodeDraw canvas, double x, double y, double blockSize, Color color, double lineWidth) {
        Color shapeBorderColor = Palette.BLACK;
        for (double i = y; i > y - (4 * blockSize); i -= blockSize) {
            fillField(canvas, x, i, blockSize, blockSize, color);
            drawBorder(canvas, x, i, blockSize, blockSize, shapeBorderColor, lineWidth);
        }
    }
}