package polygons;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class StarOfDavid extends PAppletController implements Drawing {

    public StarOfDavid(PApplet pApplet) {
        super(pApplet);

        triHeight = (float) Math.sqrt((triSide*triSide)-((triSide/2.0f)*(triSide/2.0f)));
        triWidth = (triPerLine+1)/2*triSide;
    }

    public void setup() {
        stroke(0);
        strokeWeight(15);
        fill(255);
    }

    // should be odd to make a /1\2/3\4/5\
    int triPerLine = 9;
    float triSide = 100;
    float triHeight;
    float triWidth;


    public void draw() {
        background(0);
        pushMatrix();
        center();
        for(int i = 0; i < 8; i ++) {
            drawArm();
            rotate(radians(60));
        }
        popMatrix();
    }

    public void drawArm() {
        pushMatrix();
        beginShape(TRIANGLE_STRIP);
        float x = 0;
        translate(-triWidth/2.0f, 0);
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
