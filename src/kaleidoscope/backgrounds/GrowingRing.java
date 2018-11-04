package kaleidoscope.backgrounds;

import kaleidoscope.backgrounds.KBackground;
import processing.core.PApplet;

public class GrowingRing extends KBackground {

    public GrowingRing(PApplet pApplet, int layerId) {
        super(pApplet, layerId);
    }

    public void setup() {
        stroke(255);
        strokeWeight(10);
        noFill();
    }

    float ringSize = 0;
    int numRings = 5;

    public void draw() {
        for(int i = 0; i < numRings; i++) {
            float size = (ringSize+i*cross/numRings)%cross;
            ellipse(0, 0, size, size);
        }
        ringSize++;
    }
}
