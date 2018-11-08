package grid;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GravityGrid extends SquareGrid {

    public GravityGrid(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        noStroke();
        // mockCenter();
    }

    public void mousePressed() {
        if(pApplet.mousePressed) {
            gravity.add(new PVector(mouseX(), mouseY()));
        }
    }

    ArrayList<PVector> gravity = new ArrayList<>();

    public void draw() {
        super.draw();
        suck();
    }

    public void mockCenter() {
        gravity.add(new PVector(width/2.0f, height/2.0f));
    }

    int numFakePoints = 3;
    float fakePointsSpread = 150;
    float noEffectRad = 100;
    public void mockPoints() {
        for(float i = -90.0f; i < 360.0-90.0; i+=360.0f/numFakePoints) {
            float x = fakePointsSpread*cos(radians(i)) + width/2.0f;
            float y = fakePointsSpread*sin(radians(i)) + height/2.0f;
            gravity.add(new PVector(x, y));
        }

    }

    public void suck() {
        if(gravity == null) {
            return;
        } else {
            for(int i = 0; i < numX; i++) {
                for (int j = 0; j < numY; j++) {
                    PVector point = points[i][j];

                    for(PVector c : gravity) {
                        PVector click = new PVector(c.x, c.y);

                        // distance between point and last click
                        float dist = point.dist(click);
                        if (dist < noEffectRad) {
                            continue;
                        }

                        PVector move = click.sub(point);
                        move = move.div(dist * dist / 25.0f);

                        points[i][j] = point.add(move);


                        // point.x += (point.x - click.x) / dist*dist;
                        // point.y += (point.y - click.y) / dist/dist;
                    }
                }
            }
        }

    }

}
