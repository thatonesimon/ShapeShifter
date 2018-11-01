package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public class BaseGrid extends PAppletController implements Drawing {

    public BaseGrid(PApplet pApplet) {
        super(pApplet);

        points = new PVector[numX][numY];

        for(int i = 0; i < numX; i++) {
            for(int j = 0; j < numY; j++) {
                float x = i*((float) width)/(numX-1);
                float y = j*((float) height)/(numY-1);
                points[i][j] = new PVector(x, y);
            }
        }
    }

    public void setup() {
        noStroke();
    }

    // number of points going in whatever direction
    // if numX == numY == 3, we'll end up with 2x2 boxes
    int numX = 3;
    int numY = 3;

    PVector[][] points;

    public void draw() {
        for(int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                println(points[i][j].toString());
            }
        }
    }
}
