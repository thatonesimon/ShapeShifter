package grid;

import processing.core.PApplet;
import processing.core.PVector;

public class VortexGrid extends SquareGrid {

    public VortexGrid(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        noStroke();
    }

    public void draw() {
        super.draw();
        vortex();
    }

    void vortex() {
        PVector center = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                PVector p = points[i][j];
                float angle = atan2(-p.y+center.y, -p.x+center.x);
                float dist = p.dist(center);
                angle = angle+dist/400.f*radians(1);
                p.x = width/2.0f+dist*cos(angle);
                p.y = height/2.0f+dist*sin(angle);
            }
        }
    }
}
