package circles;

import drawer.Circle;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;

public class FloweringCircles extends PAppletController implements Drawing {

    public FloweringCircles(PApplet pApplet) {
        super(pApplet);

    }

    public void setup() {
        fill(200, 100);
        noStroke();
        ellipseMode(CENTER);
    }

    int numPetals = 10;
    float r = 100;
    float circleRad = 100;

    ArrayList<Circle> circles = new ArrayList<>();

    public void draw() {
        background(0);
        center();

        // drawRotation();
        drawRandomBlossom();
    }

    private void circleCheck() {


    }

    public void drawRandomBlossom() {
        for(float i = 0; i < 360; i+=360.0f/numPetals) {
            if(random(100) > 90) {
                Circle c = new Circle(pApplet);
                c.dx = cos(radians(i));
                c.dy = sin(radians(i));
                c.dRadius = 0.1f;
                circles.add(c);
            }
        }
        for(Circle c : circles) {
            c.draw();
        }
        circles.removeIf(c -> c.radius > 25);
    }

    public void drawRotation() {
        for(float i = 0; i < 360; i+=360.0f/numPetals) {
            float x = r*cos(radians(i+millis()/10.0f));
            float y = r*sin(radians(i+millis()/10.0f));

            ellipse(x, y, 20, 20);
        }
    }

}
