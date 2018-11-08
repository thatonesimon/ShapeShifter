package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public class TriangleGrid extends PAppletController implements Drawing {

    public TriangleGrid(PApplet pApplet) {
        super(pApplet);

        triSide = (float) height/numY;
        triHeight = (float) Math.sqrt((triSide*triSide)-((triSide/2.0f)*(triSide/2.0f)));
        numX = (int) (Math.floor(width/triHeight)+1);

        points = new PVector[numX][numY+2];
    }

    public void setup() {

        setupPoints();

    }

    int numX = 30;
    // y will alternate numY and numY+2
    int numY = 30;
    float triSide;
    float triHeight;

     PVector[][] points;


    public void draw() {
        background(0);
        for(int i = 0; i < numX; i++) {
            for(int j = 0; j < numY+2; j++) {
                PVector p = points[numX][numY];
                ellipse(p.x, p.y, 10, 10);
            }
        }

    }

    public void setupPoints() {

        int col = 0;
        for(float x = 0; x < width; x+=triHeight) {
            int row = 0;
            for(float y = col%2==0 ? 0 : triSide/2.0f; y < height+triSide/2.0f; y+=triSide) {

                points[col][row] = new PVector(x, y);
                row++;
            }
            col++;
        }
    }

}
