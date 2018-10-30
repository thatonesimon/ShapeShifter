package circles;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class FloweringCircles extends PAppletController implements Drawing {

    public FloweringCircles(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        fill(200, 100);
        noStroke();
        ellipseMode(CENTER);
    }

    int numPetals = 6;
    float r = 100;

    public void draw() {
        background(0);
        center();

        for(float i = 0; i < 360; i+=360.0f/numPetals) {
            float x = r*cos(radians(i+millis()/10.0f));
            float y = r*sin(radians(i+millis()/10.0f));

            ellipse(x, y, 20, 20);
        }
    }

}
