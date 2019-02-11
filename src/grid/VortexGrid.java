package grid;

import color.Colors;
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
        // noStroke();
        strokeWeight(5);
        stroke(Colors.WHITE);
        grid.draw();
        vortex();
    }

    int dir = -1;
    int steps = 180;
    void vortex() {
        for(int i = 0; i < grid.points.length; i++) {
            for (int j = 0; j < grid.points[0].length; j++) {
                PVector p = grid.points[i][j];
                if(p != null) {
                    // angle made with center point
                    float angle = atan2(p.y-center.y, p.x-center.x);
                    // distance from center
                    float dist = p.dist(center);
                    // increment angle based on distance
                    angle += dir*dist/400.0f*radians(1);
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

    void inverseVortex() {
        for(int i = 0; i < grid.points.length; i++) {
            for (int j = 0; j < grid.points[0].length; j++) {
                PVector p = grid.points[i][j];
                if(p != null) {
                    // angle made with center point
                    float angle = atan2(p.y-center.y, p.x-center.x);
                    // distance from center
                    float dist = p.dist(center);
                    // increment angle based on inverse of distance
                    angle += dir*100.0f/dist*radians(1);
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
