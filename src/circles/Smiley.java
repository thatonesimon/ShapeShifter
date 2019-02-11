package circles;

import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class Smiley extends PAppletController implements Drawing {

    public Smiley(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {

        stroke(Colors.BLACK);
        strokeWeight(20);

    }

    public void draw() {
        int t = 30;
        stroke(Colors.BLACK);
        strokeWeight(t);
        noFill();
        pushMatrix();
        translate(width/2, height/2);

        ellipse(0, 0, width, height);

        // eyes
        ellipse(-width/3, -height/6, t, t);
        ellipse(width/3, -height/6, t, t);

        // mouth
        arc(0, 0, 4*width/5, 4*width/5, 0, PI);

        popMatrix();
    }

}