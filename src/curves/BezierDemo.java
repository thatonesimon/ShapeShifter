package curves;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class BezierDemo extends PAppletController implements Drawing {

    public BezierDemo(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {

        stroke(255);
        strokeWeight(5);
        noFill();
    }

    public void draw() {
        background(0);

        pushMatrix();
        center();

        bezier(85, 20, 10, 10, 90, 90, 15, 80);
        popMatrix();
    }
}
