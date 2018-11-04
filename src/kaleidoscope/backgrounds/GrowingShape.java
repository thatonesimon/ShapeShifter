package kaleidoscope.backgrounds;

import drawer.Polygon;
import processing.core.PApplet;

public class GrowingShape extends KBackground {

    public GrowingShape(PApplet pApplet, int layerId) {
        super(pApplet, layerId);
    }

    public void setup() {
        stroke(255);
        strokeWeight(10);
        noFill();
    }

    float ringSize = 0;
    int numRings = 5;
    int numPoints = 6;

    public void draw() {
        for(int i = 0; i < numRings; i++) {
            float size = (ringSize+i*cross/numRings)%cross/2.0f;
            Polygon.drawShape(this, numPoints, size);
        }
        ringSize++;
    }
}
