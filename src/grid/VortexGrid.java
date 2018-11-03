package grid;

import processing.core.PApplet;
import processing.core.PVector;

public class VortexGrid extends GravityGrid {

    public VortexGrid(PApplet pApplet) {
        super(pApplet);
        noEffectRad = 10.0f;
    }

    public void setup() {
        gravity.add(new PVector(radius*cos(radians(millis()))+width/2.0f, radius*sin(radians(millis()))+height/2.0f));
        gravity.add(new PVector(2*radius*cos(radians(millis()))+width/2.0f, 2*radius*sin(radians(millis()))+height/2.0f));

    }

    int radius = 200;

    public void draw() {
        super.draw();
        updateGravity();
    }

    @Override
    public void mousePressed() {

    }

    public void updateGravity() {
        PVector g = gravity.get(0);
        g.x = radius*cos(radians(millis()/30.0f))+width/2.0f;
        g.y = radius*sin(radians(millis()/30.0f))+height/2.0f;
        ellipse(g.x, g.y, 10, 10);

        g = gravity.get(1);
        g.x = 2*radius*cos(radians(-millis()/30.0f))+width/2.0f;
        g.y = 2*radius*sin(radians(-millis()/30.0f))+height/2.0f;
        ellipse(g.x, g.y, 10, 10);
    }
}
