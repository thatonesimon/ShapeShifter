package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public class BaseGrid extends PAppletController implements Drawing {

    public BaseGrid(PApplet pApplet) {
        super(pApplet);

        points = new PVector[numX][numY];

        setupPoints();

        // for(int i = 0; i < numX; i++) {
        //     for (int j = 0; j < numY; j++) {
        //         println(points[i][j].toString());
        //     }
        // }
    }

    public void keyPressed() {
        if(key() == ' ') {
            setupPoints();
        }
    }

    public void setup() {
        noStroke();
    }

    // number of points going in whatever direction
    // if numX == numY == 3, we'll end up with 2x2 boxes
    // .   .   .
    //   x   x
    // .   .   .
    //   x   x
    // .   .   .
    int numX = 30;
    int numY = 30;

    PVector[][] points;

    public void draw() {

        background(0);

        for(int i = 0; i < (numX-1)*(numY-1); i++) {
            if(i%2 == 0) {
                fill(0);
            } else {
                fill(255);
            }

            // index of top left corner
            int x = i/(numX-1);
            int y = i%(numY-1);

            beginShape();
            vertex(points[x][y].x, points[x][y].y);
            vertex(points[x][y+1].x, points[x][y+1].y);
            vertex(points[x+1][y+1].x, points[x+1][y+1].y);
            vertex(points[x+1][y].x, points[x+1][y].y);
            endShape(CLOSE);
        }

        wobbleGrid();
    }

    public void setupPoints() {
        for(int i = 0; i < numX; i++) {
            for(int j = 0; j < numY; j++) {
                float x = i*((float) width)/(numX-1);
                float y = j*((float) height)/(numY-1);
                points[i][j] = new PVector(x, y);
            }
        }
    }

    public void wobbleGrid() {
        for(int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                PVector pVector = points[i][j];
                pVector.x+=(noise(i, j, 0)-0.5);
                pVector.y+=(noise(i, j, 1)-0.5);
            }
        }
    }
}
