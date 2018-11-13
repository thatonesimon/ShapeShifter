package stripes;

import processing.core.PApplet;
import processing.core.PVector;

public class WobbleStripes extends BaseStripes {

    public WobbleStripes(PApplet pApplet) {
        super(pApplet);
        this.horizontal = true;
        bounce = new float[numPoints][numPoints];
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                bounce[i][j] = 10;
            }
        }
    }

    public void draw() {
        super.draw();
        wobbleVertical();
        ripple();
    }

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
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];
                float d = p.dist(new PVector(width/2.0f, height/2.0f))/400.0f;

                if(i%2==0) {
                    p.y += d*2*cos(rotateT);
                } else {
                    p.y -= d*2*cos(rotateT);
                }
            }
        }
    }

    float bounce[][];
    void bounce() {
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                bounce[i][j] = 10;
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
                    bounce[i][j] = maxBounce;
                }
            }
        }
        r++;
        if(r > cross/2.0) {
            r = 0;
        }
    }
}
