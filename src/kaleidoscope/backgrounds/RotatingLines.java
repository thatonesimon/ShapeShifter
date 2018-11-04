package kaleidoscope.backgrounds;

import model.PAppletController;
import processing.core.PApplet;

public class RotatingLines extends KBackground {

    public RotatingLines(PApplet pApplet, int layerId) {
        super(pApplet, layerId);
    }

    public void setup() {
        stroke(255);
        strokeWeight(10);
        noFill();
    }

    int numLines = 6;

    public void draw() {
        pushMatrix();
        rotate(PAppletController.rotateT/2.0f);
        for(int i = 0; i < numLines; i++) {
            line(0, 0, 0, cross/2.0f);
            rotate(radians(360.0f/numLines));
        }
        popMatrix();

        pushMatrix();
        rotate(-PAppletController.rotateT/2.0f);
        for(int i = 0; i < numLines; i++) {
            line(0, 0, 0, cross/2.0f);
            rotate(radians(360.0f/numLines));
        }
        popMatrix();
    }
}
