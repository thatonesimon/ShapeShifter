package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public class VortexGrid extends PAppletController implements Drawing {

    public VortexGrid(PApplet pApplet, BaseGrid grid) {
        super(pApplet);
        this.grid = grid;
    }

    BaseGrid grid;

    public void setup() {
        noStroke();
    }

    public void draw() {
        // super.draw();
        grid.draw();
        vortex();
    }

    int dir = -1;
    int steps = 180;
    void vortex() {
        PVector center = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < grid.points.length; i++) {
            for (int j = 0; j < grid.points[0].length; j++) {
                PVector p = grid.points[i][j];
                if(p != null) {
                    float angle = atan2(-p.y+center.y, -p.x+center.x);
                    float dist = p.dist(center);
                    angle = angle+dir*dist/400.f*radians(1);
                    p.x = width/2.0f+dist*cos(angle);
                    p.y = height/2.0f+dist*sin(angle);
                }
            }
        }
        steps++;
        if(steps%360 == 0) {
            dir*=-1;
        }
    }
}
