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
        //info: the positions and widths are hard coded to get close to
        //https://static.independent.co.uk/s3fs-public/thumbnails/image/2014/06/05/14/Tetris_NES_play.png?quality=75&width=768&crop=3%3A2%2Csmart&auto=webp
        //the shapes are generated dynamically based on the parameters (THERE IS NO CHECK IF THEY OVERLAP WITH OBJECTS)

        int hs = 660;
        int ws = 600;

        //creates a new canvas and the textFormat
        CodeDraw tetrisCanvas = new CodeDraw(ws, hs);
        TextFormat tetrisText = new TextFormat();
        tetrisCanvas.setTextFormat(tetrisText);

        tetrisCanvas.setCanvasPositionX(1700);
        tetrisCanvas.setCanvasPositionY(300);

        double brickLength = 30;
        double playFieldBorderWidth = 10;
        double shapeBorderWidth = 3;

        //defines the colors used inside the project
        Color fillerStoneColor = Palette.fromRGB(50, 50, 50);
        Color borderColor = Palette.fromRGB(204, 255, 255);
        Color fieldColor = Palette.fromRGB(0, 0, 0);
        Color sShapeColor = Palette.fromRGB(153, 255, 204);
        Color iShapeColor = Palette.fromRGB(204, 229, 255);
        Color textColor = Palette.WHITE;

        //fills the background in dark grey
        fillField(tetrisCanvas, 0, 0, ws, hs, fillerStoneColor);

        //draws the play field
        double playFieldX = brickLength - shapeBorderWidth / 2;
        double playFieldWidth = 10 * brickLength + shapeBorderWidth * 2;
        double playFieldHeight = 20 * brickLength + shapeBorderWidth / 2;

        fillField(tetrisCanvas, playFieldX, brickLength, playFieldWidth, playFieldHeight, fieldColor);

        //draws the border around the play field
        double borderRectX = brickLength / 2 + playFieldBorderWidth - shapeBorderWidth;
        double borderRectY = brickLength / 2 + playFieldBorderWidth;
        double borderRectWidth = 10 * brickLength + playFieldBorderWidth + shapeBorderWidth * 2;
        double borderRectHeight = 20 * brickLength + playFieldBorderWidth + shapeBorderWidth;

        drawBorder(tetrisCanvas, borderRectX, borderRectY, borderRectWidth, borderRectHeight, borderColor, playFieldBorderWidth);

        //draws the display showing the next shape
        double nextShapeIndicatorWidth = 4 * brickLength;
        double nextShapeIndicatorHeight = 6 * brickLength;
        double nextShapeIndicatorX = 12 * brickLength;
        double nextShapeIndicatorY = (hs / 2.0) - nextShapeIndicatorHeight / 2;

        fillField(tetrisCanvas, nextShapeIndicatorX, nextShapeIndicatorY, nextShapeIndicatorWidth, nextShapeIndicatorHeight, fieldColor);
        drawBorder(tetrisCanvas, nextShapeIndicatorX, nextShapeIndicatorY, nextShapeIndicatorWidth, nextShapeIndicatorHeight, borderColor, 5);

        //draws an iShape as the next shape
        double nextShapeX = nextShapeIndicatorX + (nextShapeIndicatorWidth / 2) - brickLength / 2;
        double nextShapeY = nextShapeIndicatorY + nextShapeIndicatorHeight - (1.5 * brickLength);

        drawVerticalIShape(tetrisCanvas, nextShapeX, nextShapeY, brickLength, iShapeColor, 3);

        //draws the score display incl. border
        double scoreIndicatorWidth = 7 * brickLength;
        double scoreIndicatorHeight = 6 * brickLength;

        fillField(tetrisCanvas, nextShapeIndicatorX, brickLength, scoreIndicatorWidth, scoreIndicatorHeight, fieldColor);
        drawBorder(tetrisCanvas, nextShapeIndicatorX, brickLength, scoreIndicatorWidth, scoreIndicatorHeight, borderColor, 2);

        //draws the level display incl. border
        double levelIndicatorWidth = 6 * brickLength;
        double levelIndicatorHeight = 3 * brickLength;
        double levelIndicatorY = nextShapeIndicatorY + nextShapeIndicatorHeight + brickLength;

        fillField(tetrisCanvas, nextShapeIndicatorX, levelIndicatorY, levelIndicatorWidth, levelIndicatorHeight, fieldColor);
        drawBorder(tetrisCanvas, nextShapeIndicatorX, levelIndicatorY, levelIndicatorWidth, levelIndicatorHeight, borderColor, 2);

        //draws the two shapes in the play field
        drawHorizontalSShape(tetrisCanvas, brickLength, hs - 2 * brickLength, brickLength, sShapeColor, 3);
        drawVerticalIShape(tetrisCanvas, 10 * brickLength, hs - 2 * brickLength, brickLength, iShapeColor, 3);

        //draws the text needed for the information displays
        tetrisCanvas.setTextFormat(tetrisText);
        tetrisText.setFontSize(25);
        tetrisText.setBold(true);
        tetrisCanvas.setColor(textColor);
        tetrisCanvas.drawText(nextShapeIndicatorX + brickLength / 2, 2 * brickLength, "TOP\n726000\nSCORE\nB91200");
        tetrisCanvas.drawText(nextShapeIndicatorX + brickLength / 2, nextShapeIndicatorY + brickLength / 2, "NEXT");
        tetrisCanvas.drawText(nextShapeIndicatorX + brickLength / 2, levelIndicatorY + 0.5 * brickLength, "LEVEL\n01");

        tetrisCanvas.show();
    }

    //Draws a rectangle with the advantage of not redefining the codeDraw properties
    private static void drawBorder(CodeDraw canvas, double x, double y, double width, double height, Color color, double lineWidth) {
        canvas.setColor(color);
        canvas.setLineWidth(lineWidth);
        canvas.drawRectangle(x, y, width, height);
        canvas.resetProperties();
    }

    //Fills a rectangle with the advantage of not redefining the codeDraw properties
    private static void fillField(CodeDraw canvas, double x, double y, double width, double height, Color color) {
        canvas.setColor(color);
        canvas.fillRectangle(x, y, width, height);
        canvas.resetProperties();
    }


    private static void drawHorizontalSShape(CodeDraw canvas, double x, double y, double blockSize, Color color, double lineWidth) {
        Color shapeBorderColor = Palette.BLACK;
        //iterates from the starting x position until the length of the sShape is reached
        for (double i = x; i < x + (3 * blockSize); i += blockSize) {
            //places the bottom layer of the S
            //this will happen in iteration 1 and 2
            if (i <= x + blockSize) {
                fillField(canvas, i, y, blockSize, blockSize, color);
                drawBorder(canvas, i, y, blockSize, blockSize, shapeBorderColor, lineWidth);
            }
            //places the upper layer of the S by subtracting one element from the y coordinate
            //this will happen in iteration 2 and 3
            if (i >= x + blockSize) {
                fillField(canvas, i, y - blockSize, blockSize, blockSize, color);
                drawBorder(canvas, i, y - blockSize, blockSize, blockSize, shapeBorderColor, lineWidth);
            }
        }
    }

    private static void drawVerticalIShape(CodeDraw canvas, double x, double y, double blockSize, Color color, double lineWidth) {
        Color shapeBorderColor = Palette.BLACK;
        //draws a vertical line of bricks beginning from the bottom
        for (double i = y; i > y - (4 * blockSize); i -= blockSize) {
            fillField(canvas, x, i, blockSize, blockSize, color);
            drawBorder(canvas, x, i, blockSize, blockSize, shapeBorderColor, lineWidth);
        }
    }
}