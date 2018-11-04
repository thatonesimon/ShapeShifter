package kaleidoscope.layers;

import model.PAppletController;
import processing.core.PApplet;

public class KLayer extends PAppletController {

    public KLayer(PApplet pApplet, int numPanels, float distCenter, int layerId) {
        super(pApplet);
        this.numPanels = numPanels;
        this.distCenter = distCenter;
        this.layerId = layerId;
    }

    public void setup() {
        rectMode(CENTER);
    }

    public int numPanels = 6;
    public float distCenter = 100;
    public int layerId = 0;
    public boolean isMirrored = true;

    public void drawMirroredLayer() {
        pushMatrix();
        rotate(radians(-90));
        for (float i = 0; i < numPanels; i++) {
            pushMatrix();
            rotate(radians(i*360.0f/numPanels));
            translate(distCenter, 0);
            drawThing();
            popMatrix();
        }
        popMatrix();
    }

    public void drawUprightLayer() {
        for(float i = -90.0f; i < 360.0f-90.0f; i+=360.0f/numPanels) {
            float x = distCenter*cos(PApplet.radians(i));
            float y = distCenter*sin(PApplet.radians(i));
            drawThing();
        }
    }

    public void drawThing() {
        ellipse(0, 0, 25, 25);
    }


}
