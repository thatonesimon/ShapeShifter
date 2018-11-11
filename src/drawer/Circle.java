package drawer;

import color.Colors;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class Circle extends PAppletController {

    public Circle(PApplet pApplet) {
        super(pApplet);
    }

    public float x = 0;
    public float dx = 0;
    public float y = 0;
    public float dy = 0;

    public float radius = 10;
    public float dRadius = 0;

    public int color = Colors.WHITE;

    public boolean shouldRemove = false;

    public void draw() {
        fill(color);
        ellipse(x, y, radius*2, radius*2);
        next();
        checkRemove();
    }

    public void next() {
        x+=dx;
        y+=dy;
        radius+=dRadius;
    }

    public void checkRemove() {
        // if you can't see circle
        if(pApplet.alpha(color) <= 0) {
            shouldRemove = true;
            return;
        }
        PVector circle = new PVector(x, y);
        PVector center = new PVector(0, 0);
        // if circle is off screen
        if(circle.dist(center) > radius+cross/2.0f) {
            shouldRemove = true;
            return;
        }
    }


}
