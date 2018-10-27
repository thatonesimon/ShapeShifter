package circles;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

public class Tentacles extends PAppletController implements Drawing {

    public Tentacles(PApplet pApplet) {
        super(pApplet);

//        colorMode(RGB);
    }

    public void keyPressed() {

    }

    public void mouseMoved() {

    }

    public void draw1() {
        background(0);
        ellipse(mouseX, mouseY, 20, 20);

    }

    public int numArms = 15;
    public int numLayers = 10;
    public int layerStep = 25;
    public float circleRad = 50;

    public int rectWidth = 100;
    public int rectHeight = 15;

    public int t = 0;

    public void draw() {
        center();
        background(15);
        fill(0);
        stroke(255, 0, 0);
        strokeWeight(5);

        drawArm(0, 0);
        drawScrunchyArm(0, 0);
        ellipse(0, 0, circleRad, circleRad);

        t++;

    }

    public void drawArm(int x, int y) {
        float rot = 45*sin(radians(t));
        rotate(radians(rot));
        for(int a = 0; a < 360; a += 360.0/numArms) {
            pushMatrix();
            translate(x, y);
            rotate(radians(a));
            translate(circleRad/2, 0);
            rect(0, -rectHeight/2, rectWidth, rectHeight);

            for(int i = 0; i < numLayers; i++) {
                float thisRad = circleRad + i*layerStep;

                translate(rectWidth+thisRad/2, 0);
                rotate(radians(rot));
                rect(0, -rectHeight/2, rectWidth, rectHeight);
                ellipse(0, 0, thisRad, thisRad);
            }
            ellipse(rectWidth, 0, circleRad, circleRad);
            popMatrix();
        }

        rot = -rot;
        rotate(radians(rot));
        for(int a = 0; a < 360; a += 360.0/numArms) {
            pushMatrix();
            translate(x, y);
            rotate(radians(a));
            translate(circleRad/2, 0);
            rect(0, -rectHeight/2, rectWidth, rectHeight);

            for(int i = 0; i < numLayers; i++) {
                translate(rectWidth, 0);
                rotate(radians(rot));
                rect(0, -rectHeight/2, rectWidth, rectHeight);
                ellipse(0, 0, circleRad, circleRad);
            }
            ellipse(rectWidth, 0, circleRad, circleRad);
            popMatrix();
        }
    }

    public void drawScrunchyArm(int x, int y) {
        float rot = 90*sin(radians(t));
        rotate(radians(rot));
        for(int a = 0; a < 360; a += 360.0/numArms) {
            pushMatrix();
            translate(x, y);
            rotate(radians(a));
            translate(circleRad/2, 0);
            rect(0, -rectHeight/2, rectWidth, rectHeight);

            for(int i = 0; i < numLayers; i++) {
                float thisRad = circleRad + i*layerStep;
                translate(rectWidth+thisRad/2, 0);
                if(i%2 == 0) {
                    rotate(radians(rot));
                } else {
                    rotate(radians(-rot));

                }
                rect(0, -rectHeight/2, rectWidth, rectHeight);
                ellipse(0, 0, thisRad, thisRad);
            }
            ellipse(rectWidth, 0, circleRad, circleRad);
            popMatrix();
        }

        rot = -rot;
        rotate(2*radians(rot));
        for(int a = 0; a < 360; a += 360.0/numArms) {
            pushMatrix();
            translate(x, y);
            rotate(radians(a));
            translate(circleRad/2, 0);
            rect(0, -rectHeight/2, rectWidth, rectHeight);

            for(int i = 0; i < numLayers; i++) {
                float thisRad = circleRad;
                translate(rectWidth+thisRad/2, 0);
                if(i%2 == 0) {
                    rotate(radians(rot));
                } else {
                    rotate(radians(-rot));

                }
                rect(0, -rectHeight/2, rectWidth, rectHeight);
                ellipse(0, 0, thisRad, thisRad);
            }
            ellipse(rectWidth, 0, circleRad, circleRad);
            popMatrix();
        }

    }
}
