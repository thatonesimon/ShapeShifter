package grid;

import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class BaseGrid extends PAppletController implements Drawing {

    public BaseGrid(PApplet pApplet) {
        super(pApplet);
    }

    // default 30
    public int numX = 30;
    public int numY = 30;
    public PVector[][] points = new PVector[numX][numY];


    public abstract void draw();

    public abstract void setupPoints();

    public void keyPressed() {
        if(key() == ' ') {
            setupPoints();
        }
    }

    public void wobbleGrid() {
        for(int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                PVector p = points[i][j];
                // pVector.x+=(noise(i*j, 0, millis())-0.5);
                // pVector.y+=(noise(i*j, 1, millis())-0.5);
                p.x+=(noise(i*numX+j, 0, millis())-0.5);
                p.y+=(noise(i*numX+j, 1, millis())-0.5);}
        }
    }

    public void drawPoints() {
        stroke(Colors.WHITE);
        for(int i = 0; i < numX; i++) {
            for(int j = 0; j < numY+1; j++) {
                if(points[i][j] != null) {
                    PVector p = points[i][j];
                    ellipse(p.x, p.y, 5, 5);
                }
            }
        }
    }
}
