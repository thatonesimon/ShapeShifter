package color;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class ColorWalk extends PAppletController implements Drawing {

    public ColorWalk(PApplet pApplet) {
        super(pApplet);

        squareSide = height/numRows;
        for(int i = 0; i < numRows; i++) {
            rowColor[i] = random(255);
        }
    }

    public void setup() {
        noStroke();

    }

    int numRows = 10;
    float[] rowColor = new float[numRows];
    float squareSide;

    public void draw() {
        pushMatrix();
        colorMode(HSB);

        int r = 0;
        for (float y = 0; y < height; y += squareSide) {
            int c = 0;
            for (float x = 0; x < width + squareSide; x += squareSide) {
                // float h = noise(y, x/1000.0f,  millis()/10000.0f);
                fill((rowColor[r] + c * 10) % 255, 255, 255);
                square(x, y, squareSide);
                c++;
            }
            r++;
        }

        popMatrix();
        colorMode(RGB);

        for (int i = 0; i < numRows; i++) {
            rowColor[i]+=random(2.0f);
        }
    }
}