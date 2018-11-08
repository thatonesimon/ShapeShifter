package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class BaseGrid extends PAppletController implements Drawing {

    public BaseGrid(PApplet pApplet) {
        super(pApplet);
    }

    PVector[][] points = null;
    int numX;
    int numY;

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
                PVector pVector = points[i][j];
                // pVector.x+=(noise(i*j, 0, millis())-0.5);
                // pVector.y+=(noise(i*j, 1, millis())-0.5);
                pVector.x+=(noise(i*numX+j, 0, millis())-0.5);
                pVector.y+=(noise(i*numX+j, 1, millis())-0.5);}
        }
    }
}
