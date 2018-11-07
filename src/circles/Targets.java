package circles;

import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;

public class Targets extends PAppletController implements Drawing {

    public Targets(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        targets.add(new Target());
        noFill();

    }

    ArrayList<Target> targets = new ArrayList<>();

    class Target {

        public Target() {
            x = random(0, width);
            // dy = random(1, 3);
            numLayers = (int) random(7, 10);
            firstLayerSize = random(25, 50);
            secondLayerSize = random(25, 50);

            if(random(1) < 0.5) {
                firstColor = Colors.BLACK;
                secondColor = Colors.WHITE;
            } else {
                firstColor = Colors.WHITE;
                secondColor = Colors.BLACK;
            }
            radius = (firstLayerSize+secondLayerSize)*numLayers/2.0f;
            y = height+radius/2.0f;
        }

        float x;
        float y = height;
        float dy = 1;
        float radius;
        int numLayers;
        float firstLayerSize;
        float secondLayerSize;

        int firstColor;
        int secondColor;

        public void draw() {
            float r = radius;
            for(int i = numLayers; i > 0; i--) {
                if(i%2 == 0) {
                    stroke(firstColor);
                    strokeWeight(firstLayerSize);
                    ellipse(x, y, r, r);
                } else {
                    stroke(secondColor);
                    strokeWeight(secondLayerSize);
                    ellipse(x, y, r, r);
                }
                r-=(firstLayerSize+secondLayerSize)/2.0f;

            }
            floating();
        }

        public void floating() {
            y-=dy;
        }

        public boolean shouldRemove() {
            return y < -radius/2.0f;
        }
    }

    int lastTarget = 0;
    public void draw() {
        background(0);

        for(Target t : targets) {
            t.draw();
        }

        targets.removeIf(t -> t.shouldRemove());

        if(lastTarget > 150.0 && targets.size() < 12) {
            addTwoTargets();
            lastTarget = 0;
        }
        lastTarget++;

    }

    // TODO: need better generation method
    public void addTwoTargets() {
        Target t1 = new Target();
        Target t2 = new Target();
        t2.x = (t1.x+width/2.0f)%width;
        targets.add(t1);
        targets.add(t2);
    }
}
