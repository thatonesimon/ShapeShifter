package kaleidoscope.backgrounds;

import drawer.Polygon;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class GrowingStar extends PAppletController implements Drawing {

    public GrowingStar(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        stroke(0);
        strokeWeight(10);
        noFill();
    }

    float ringSize = 0;
    int numRings = 5;
    int numPoints = 6;

    public void draw() {
        pushMatrix();
        center();
        for(int i = 0; i < numRings; i++) {
            float size = (ringSize+i*cross/numRings)%cross/2.0f;
            Polygon.drawStar(this, numPoints, size);
        }
        ringSize++;
        popMatrix();
    }
}
