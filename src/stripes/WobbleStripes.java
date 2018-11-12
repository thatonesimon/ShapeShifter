package stripes;

import processing.core.PApplet;
import processing.core.PVector;

public class WobbleStripes extends BaseStripes {

    public WobbleStripes(PApplet pApplet) {
        super(pApplet);
    }

    public void draw() {
        super.draw();
        wobbleVertical();
    }

    public void wobbleHorizontal() {
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(p.y%20 < 5) {

                    p.x += cos(rotateT);
                }
            }
        }
    }

    public void wobbleVertical() {
        for(int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                PVector p = points[i][j];

                if(p.x%20 < 5) {

                    p.y += cos(rotateT);
                }
            }
        }
    }
}
