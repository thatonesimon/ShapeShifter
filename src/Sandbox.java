import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

public class Sandbox extends PAppletController implements Drawing {

    public Sandbox(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {

    }

    PVector center = new PVector(width/2.0f, height/2.0f);
    PVector p = new PVector(50, 400);
    public void draw() {
        background(Colors.BLACK);
        pushMatrix();
        ellipse(p.x, p.y, 25, 25);
        center();
        ellipse(0, 0, 10, 10);
        orbit();
        popMatrix();
    }

    public void orbit() {
        float dist = p.dist(center);
        float angle = atan2(p.y-center.y, p.x-center.x);
        // println(degrees(angle));
        // pApplet.noLoop();

        // p.x = dist*cos(angle);
        // p.y = dist*sin(angle);
        // println(dist*cos(angle));

        p.x = width/2.0f+dist*cos(angle+radians(1));
        p.y = height/2.0f+dist*sin(angle+radians(1));

        // float x = 200*cos(angle);
        // float y = 200*sin(angle);
        //
        // ellipse(x, y, 100, 100);

    }

}
