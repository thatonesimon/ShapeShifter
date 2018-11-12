package circles;

import color.Colors;
import drawer.Circle;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;

public class FloweringCircles extends PAppletController implements Drawing {

    public FloweringCircles(PApplet pApplet) {
        super(pApplet);
        this.colorMode(RGB);

    }

    public void setup() {
        fill(200, 100);
        noStroke();
        ellipseMode(CENTER);
        colorMode(RGB);
    }

    Colors colors = new Colors(pApplet);

    int numPetals = 20;
    float r = 100;
    float circleRad = 100;
    int c = 0;

    ArrayList<Circle> circles = new ArrayList<>();

    public void draw() {
        background(0);
        center();

        drawRotation();
        // drawRandomBlossom();
    }

    private void circleCheck() {


    }

    public void drawRandomBlossom() {
        for(float d = 0; d < 360; d+=360.0f/numPetals) {
            if(random(100) > 99) {
                Circle c = new Circle(pApplet);
                c.dx = cos(radians(d));
                c.dy = sin(radians(d));
                c.dRadius = 0.1f;
                circles.add(c);
            }
        }
        for(Circle c : circles) {
            c.draw();
            c.color = colors.changeAlpha(c.color, -1);
        }
        circles.removeIf(c -> pApplet.alpha(c.color) <= 0);
    }

    int numArms = 3;
    void drawRotation() {
        for(float d = 0; d < 360; d+=360.0f/numPetals) {
            if(shouldBloom(c, d)) {
                Circle c = new Circle(pApplet);
                c.dx = cos(radians(d));
                c.dy = sin(radians(d));
                c.dRadius = 0.1f;
                circles.add(c);
            }
        }
        for(Circle c : circles) {
            c.draw();
            c.color = colors.changeAlpha(c.color, -1);
        }
        circles.removeIf(c -> c.shouldRemove);

        c++;
    }

    boolean shouldBloom(int c, float d) {
        for(float i = 0; i < numArms; i++) {
            if(c%360 == (int) d) {
                return true;
            }
            c+=360.0/numArms;
        }
        return false;
    }
}
