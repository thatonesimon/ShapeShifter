package drawer;

import model.PAppletController;
import processing.core.PApplet;

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

    int color;

    public void draw() {
        ellipse(x, y, radius*2, radius*2);
        next();
    }

    public void next() {
        x+=dx;
        y+=dy;
        radius+=dRadius;
    }


}
