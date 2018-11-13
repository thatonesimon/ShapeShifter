package grid;

import color.Colors;
import processing.core.PApplet;
import processing.core.PVector;

public class CircleGrid extends SquareGrid {

    public CircleGrid(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        setupPoints();

        noStroke();
        fill(Colors.WHITE);
    }

    public void draw() {
        background(Colors.BLACK);

        pushMatrix();

        for (int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                PVector p = points[i][j];
                // TODO: make this radiate from center
                float dist = p.dist(new PVector(width/2f, height/2f));
                float x = squareSide/2.0f*cos(rotateT+dist);
                float y = squareSide/2.0f*sin(rotateT+dist);
                ellipse(p.x+x, p.y+y, 10, 10);
            }
        }
        popMatrix();
    }
}
