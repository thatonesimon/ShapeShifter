package stripes;

import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public class BaseStripes extends PAppletController implements Drawing {

    public BaseStripes(PApplet pApplet) {
        super(pApplet);
        pointSpace = max(width, height)/((float) (numPoints-1));
        setupPoints();

        colors = new int[2];
        colors[0] = Colors.BLACK;
        colors[1] = Colors.WHITE;
    }

    public void setup() {
        noStroke();

    }

    // you will see numPoints-1 stripes
    public int numPoints = 30;
    public PVector[][] points = new PVector[numPoints][numPoints];
    public float pointSpace;
    public int[] colors;
    public boolean horizontal = true;

    public void draw() {
        pushMatrix();
        background(Colors.BLACK);

        if(horizontal) {
            drawHorizontal();
        } else {
            drawVertical();
        }

        popMatrix();
    }

    void drawVertical() {
        for(int x = 0; x < numPoints-1; x++) {

            fill(colors[x%2]);

            beginShape();
            for(int y = 0; y < numPoints; y++) {
                vertex(points[x][y].x, points[x][y].y);
            }
            for(int y = numPoints-1; y >=0; y--) {
                vertex(points[x+1][y].x, points[x+1][y].y);
            }
            endShape(CLOSE);
        }
    }

    void drawHorizontal() {
        for(int y = 0; y < numPoints-1; y++) {

            fill(colors[y%2]);

            beginShape();
            for(int x = 0; x < numPoints; x++) {
                vertex(points[x][y].x, points[x][y].y);
            }
            for(int x = numPoints-1; x >=0; x--) {
                vertex(points[x][y+1].x, points[x][y+1].y);
            }
            endShape(CLOSE);
        }
    }

    public void setupPoints() {
        for(int i = 0; i < numPoints; i++) {
            for(int j = 0; j < numPoints; j++) {
                // float x = i*((float) width)/(numX-1);
                // float y = j*((float) height)/(numY-1);
                float x = i*pointSpace;
                float y = j*pointSpace;
                points[i][j] = new PVector(x, y);
            }
        }
    }

    public void drawPoints() {
        fill(Colors.WHITE);
        for(int i = 0; i < numPoints; i++) {
            for(int j = 0; j < numPoints; j++) {
                if(points[i][j] != null) {
                    PVector p = points[i][j];
                    ellipse(p.x, p.y, 5, 5);
                }
            }
        }
    }
}