package stripes;

import color.Colors;
import processing.core.PApplet;
import processing.core.PVector;

public class WobbleStripes extends BaseStripes {

    public WobbleStripes(PApplet pApplet) {
        super(pApplet);
        this.horizontal = true;
        original = new PVector[points.length][points[0].length];
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                original[i][j] = points[i][j].copy();
            }
        }

        wobble = new float[points.length][points[0].length];
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                wobble[i][j] = 0;
            }
        }
    }

    PVector[][] original;
    public void draw() {
        pushMatrix();
        background(Colors.BLACK);

        if(horizontal) {
            horizontalStripes();
            wobbleVertical();
        } else {

        }

        // ripple();
        popMatrix();
    }

    public void horizontalStripes() {
        for(int y = 0; y < numPoints-1; y++) {

            fill(colors[y%2]);

            beginShape();
            for(int x = 0; x < numPoints; x++) {
                vertex(points[x][y].x, points[x][y].y+wobble[x][y]);
            }
            for(int x = numPoints-1; x >=0; x--) {
                vertex(points[x][y+1].x, points[x][y+1].y+wobble[x][y]);
            }
            endShape(CLOSE);
        }
    }

    float[][] wobble;
    public void wobbleHorizontal() {
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(i%2 == 0) {
                    float d = p.dist(new PVector(width/2.0f, height/2.0f))/4.0f;
                    println(d);
                    p.x += d*2*sin(rotateT);
                } else {

                }
            }
        }
    }

    public void wobbleVertical() {
        PVector center = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];
                PVector o = original[i][j];
                float d = o.dist(center)/4.0f;

                if(i%2==0) {
                    wobble[i][j] = d*sin(rotateT);
                } else {
                    wobble[i][j] = -d*sin(rotateT);
                }
            }
        }
    }


    int r = 0;
    float maxBounce = 20.0f;
    void ripple() {
        PVector center = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(center.dist(p) < r && center.dist(p) > r-10) {
                    // ellipse(p.x, p.y, 10, 10);
                }
            }
        }
        r++;
        if(r > cross/2.0) {
            r = 0;
        }
    }
}
