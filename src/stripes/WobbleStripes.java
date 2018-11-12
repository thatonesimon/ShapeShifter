package stripes;

import processing.core.PApplet;
import processing.core.PVector;

public class WobbleStripes extends BaseStripes {

    public WobbleStripes(PApplet pApplet) {
        super(pApplet);
        this.horizontal = true;
    }

    public void draw() {
        super.draw();
        // wobbleVertical();
        ripple();
    }

    public void wobbleHorizontal() {
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(p.y%20 < 5) {
                    p.x += cos(rotateT);
                }
            }
        }
    }

    public void wobbleVertical() {
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(p.x%20 < 5) {

                    p.y += cos(rotateT);
                }
            }
        }
    }

    int r = 0;
    public void ripple() {
        PVector center = new PVector(width/2.0f, height/2.0f);

        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(center.dist(p) < r && center.dist(p) > r-10) {
                    ellipse(p.x, p.y, 10, 10);
                }
            }
        }

        r++;
        if(r > cross/2.0) {
            r = 0;
        }
    }
}
