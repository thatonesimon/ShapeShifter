package kaleidoscope.layers;

import color.Colors;
import drawer.Polygon;
import model.PAppletController;
import processing.core.PApplet;

public class GrowingTriangles extends KLayer {

    public GrowingTriangles(PApplet pApplet, int numPanels, float distCenter, int layerId) {
        super(pApplet, numPanels, distCenter, layerId);
    }

    public void setup() {
        // noStroke();
        // fill(255);
        stroke(0);
        fill(Colors.RED);
    }

    public boolean isMirrored = true;

    @Override
    public void drawThing() {
        float size = 25/2*(cos(10*PAppletController.rotateT)+1);
        float xOff = 25*cos(10*PAppletController.rotateT);
        strokeWeight(5+2.5f*layerId);
        Polygon.drawShape(pApplet, xOff, 0, 3, size+10*layerId);
    }
}
