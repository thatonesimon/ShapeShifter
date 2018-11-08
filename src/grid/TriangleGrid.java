package grid;

import color.Colors;
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
        noStroke();
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
            for(int j = 0; j < numY+1; j++) {
                if(points[i][j] != null) {
                    PVector p = points[i][j];
                    // ellipse(p.x, p.y, 10, 10);
                }
            }
        }

        for(int i = 0; i < numX-1; i++) {
            for(int j = 0; j < numY + 2; j++) {

                try {

                    if(i%2 == 0) {
                    // if(i%2 == 1) {
                        fill(Colors.BLACK);
                        beginShape();
                        //    3c
                        // 1a
                        //    2b
                        vertex(points[i][j].x, points[i][j].y);
                        vertex(points[i+1][j+1].x, points[i+1][j+1].y);
                        vertex(points[i+1][j].x, points[i+1][j].y);
                        endShape(CLOSE);

                        fill(Colors.WHITE);
                        beginShape();
                        // 1a
                        //    2b
                        // 3c
                        vertex(points[i][j].x, points[i][j].y);
                        vertex(points[i+1][j+1].x, points[i+1][j+1].y);
                        vertex(points[i][j+1].x, points[i][j+1].y);
                        endShape(CLOSE);
                    } else {
                        fill(Colors.WHITE);

                        beginShape();
                        // 1a
                        //    3c
                        // 2b
                        vertex(points[i][j].x, points[i][j].y);
                        vertex(points[i][j+1].x, points[i][j+1].y);
                        vertex(points[i+1][j].x, points[i+1][j].y);
                        endShape(CLOSE);

                        fill(Colors.BLACK);
                        beginShape();
                        //    1c
                        // 2b
                        //    3d
                        vertex(points[i+1][j].x, points[i+1][j].y);
                        vertex(points[i][j+1].x, points[i][j+1].y);
                        vertex(points[i+1][j+1].x, points[i+1][j+1].y);
                        endShape(CLOSE);
                    }


                } catch (Exception e) {
                    println("issue with " + i + ", " + j);
                }



            }
        }
    }

    // TODO: setup with i, j and not x, y
    public void setupPoints() {

        int col = 0;
        for(float x = 0; x < width; x+=triHeight) {
            int row = 0;
            for(float y = col%2==0 ? triSide/2.0f : 0; y < height+triSide/2.0f; y+=triSide) {
                points[col][row] = new PVector(x, y);
                row++;
            }
            col++;
        }
    }

}