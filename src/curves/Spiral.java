package curves;

import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class Spiral extends PAppletController implements Drawing {

    public Spiral(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        stroke(Colors.BLACK);
        strokeWeight(1);
        fill(Colors.BLACK);

    }

    int numArms = 6;

    // this makes wave stretch as it lengthens
    float stretch = 20f;
    // this is the base stretch, pretty arbitrary
    float startStretch = 15;

    public void draw() {
        background(Colors.WHITE);
        pushMatrix();
        center();
        dotSpiral();

        popMatrix();
    }

    void pointSpiral() {
        for(int i = 0; i < numArms; i++) {
            beginShape();

            float x = 0;
            float y = 0;
            while(x < cross/2 && y < cross/2) {
                vertex(x, y);
                x++;
                y = x/5*sin(x/(startStretch+x/stretch));
            }
            // i++;
            // rotate(TWO_PI/numArms);

            // while(x > 0 && y > 0) {
            //     // for the rotation
            //     float xOff = 00;
            //     float yOff = 00;
            //     vertex(x+xOff, y+yOff);
            //     x--;
            //     y = x/5*sin(x/(startStretch+x/stretch));
            // }

            endShape();

            rotate(TWO_PI/numArms);
        }
    }

    void dotSpiral() {

        for(int i = 0; i < numArms; i++) {
            float x = 0;
            float y = 0;
            // var for increasing spaces between circles
            int s = 5;
            while(x < cross/2 && y < cross/2) {
                // circle(x, y, x/3);
                // square(x, y, x/3);
                // poly(x, y, 6, x/3/2);
                star(x, y,5, x/3/2);
                x+=s;
                s+=s/4;
                // x = 2*x;
                y = x/5*sin(x/(startStretch+x/stretch)-2*rotateT);
            }
            rotate(TWO_PI/numArms);
        }
    }
}
