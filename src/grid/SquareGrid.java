package grid;

import color.Colors;
import processing.core.PApplet;
import processing.core.PVector;

public class SquareGrid extends BaseGrid {

    public SquareGrid(PApplet pApplet) {
        super(pApplet);
        squareSide = max((float) width/(numX-1), (float) height/(numY-1));
        setupPoints();
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
    public float squareSide;

    public void draw() {

        background(0);

        for(int i = 0; i < (numX-1)*(numY-1); i++) {
            if(i%2 == 0) {
                fill(Colors.BLACK);
            } else {
                fill(Colors.RED);
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

        // wobbleGrid();
    }

    public void setupPoints() {
        for(int i = 0; i < numX; i++) {
            for(int j = 0; j < numY; j++) {
                // float x = i*((float) width)/(numX-1);
                // float y = j*((float) height)/(numY-1);
                float x = i*squareSide;
                float y = j*squareSide;
                points[i][j] = new PVector(x, y);
            }
        }
    }
}
