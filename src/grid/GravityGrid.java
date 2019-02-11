package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GravityGrid extends PAppletController implements Drawing {

    BaseGrid grid;

    public GravityGrid(PApplet pApplet, BaseGrid grid) {
        super(pApplet);
        this.grid = grid;
        grid.setupPoints();
        mockCenter();
    }

    public void setup() {
        grid.setup();
        noStroke();
    }

    public void mousePressed() {
        if(pApplet.mousePressed) {
            println("mouse");
            gravity.add(new PVector(mouseX(), mouseY()));
        }
    }

    ArrayList<PVector> gravity = new ArrayList<>();

    public void draw() {
        grid.draw();
        suckCircle();
    }

    private void mockCenter() {
        gravity.add(new PVector(width/2.0f, height/2.0f));
    }

    float fakePointsSpread = 150;
    private void mockPoints(int numFakePoints) {
        for(float i = -90.0f; i < 360.0-90.0; i+=360.0f/numFakePoints) {
            float x = fakePointsSpread*cos(radians(i)) + width/2.0f;
            float y = fakePointsSpread*sin(radians(i)) + height/2.0f;
            gravity.add(new PVector(x, y));
        }
    }

    float noEffectRad = 150;
    private void suckCircle() {
        for (PVector g : gravity) {
            for (int i = 0; i < grid.numX; i++) {
                for (int j = 0; j < grid.numY; j++) {
                    PVector point = grid.points[i][j];
                    PVector grav = new PVector(g.x, g.y);

                    // distance between point and grav
                    float dist = point.dist(grav);
                    if (dist < noEffectRad) {
                        continue;
                    }

                    PVector move = grav.sub(point);
                    move = move.div(dist * dist / 25.0f);
                    point.add(move);
                }
            }
        }
    }

    float noEffectX = 100;
    float noEffectY = 100;
    private void suckRectangle() {
        for (PVector c : gravity) {
            for(int i = 0; i < grid.numX; i++) {
                for (int j = 0; j < grid.numY; j++) {
                    PVector point = grid.points[i][j];
                    PVector grav = new PVector(c.x, c.y);

                    // distance between point and grav
                    float dist = point.dist(grav);
                    if(insideSquare(grav, point)) {
                        continue;
                    }

                    PVector move = grav.sub(point);
                    move = move.div(dist * dist / 25.0f);
                    point.add(move);
                }
            }
        }
    }

    private boolean insideSquare(PVector center, PVector point) {
        return  point.x < center.x+noEffectX && point.x > center.x-noEffectX &&
                point.y < center.y+noEffectY && point.y > center.y-noEffectY;
    }
}
