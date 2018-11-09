package polygons;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class StarOfDavid extends PAppletController implements Drawing {

    public StarOfDavid(PApplet pApplet) {
        super(pApplet);

        triHeight = (float) Math.sqrt((triSide*triSide)-((triSide/2.0f)*(triSide/2.0f)));
        triStripWidth = (triPerLine+1)/2*triSide;
    }

    public void setup() {
        stroke(0);
        strokeWeight(15);
        fill(255);
    }

    // should be odd to make a /1\2/3\4/5\
    int triPerLine = 11;
    float triSide = 50;
    float triHeight;
    float triStripWidth;


    public void draw() {
        background(0);
        pushMatrix();
        center();
        for(int i = 0; i < 6; i ++) {
            pushMatrix();
            rotate(radians(i*60));
            translate(0, -triStripWidth/3.5f);
            drawArm();
            popMatrix();

        }
        popMatrix();
    }

    public void drawArm() {
        pushMatrix();
        beginShape(TRIANGLE_STRIP);
        float x = 0;
        translate(-triStripWidth/2.0f, 0);
        for(int i = 0; i < (triPerLine+1)/2; i++) {
            vertex(x, 0);
            x+=triSide/2.0f;
            vertex(x, triHeight);
            x+=triSide/2.0f;
        }
        vertex(x, 0);
        endShape();
        popMatrix();
    }
}
