package kaleidoscope;

import kaleidoscope.backgrounds.*;
import kaleidoscope.layers.GrowingTriangles;
import kaleidoscope.layers.KLayer;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;

public class KaleidoscopeGenerator extends PAppletController implements Drawing {

    public KaleidoscopeGenerator(PApplet pApplet) {
        super(pApplet);
    }

    ArrayList<KLayer> layers = new ArrayList<>();
    ArrayList<KBackground> backgrounds = new ArrayList<>();
    int numLayers = 5;
    int numPanels = 6;
    float layerSize = 100;

    public void setup() {
        layers.clear();
        for(int i = 0; i < numLayers; i++) {
            KLayer l = generateLayer(pApplet, numPanels, (i)*layerSize, i);
            l.numPanels+=i;
            layers.add(l);
        }
        backgrounds.add(new GrowingStar(pApplet, 0));
        backgrounds.add(new RotatingLines(pApplet, 0));
    }

    public void draw() {
        center();
        background(0);
        for(KBackground b : backgrounds) {
            b.setup();
            b.draw();
        }

        int curLayer = 0;
        for(KLayer l : layers) {
            pushMatrix();
            if(curLayer%2 == 0) {
                rotate(PAppletController.rotateT);
            } else {
                rotate(-PAppletController.rotateT);
            }
            l.setup();
            if(l.isMirrored) {
                l.drawMirroredLayer();
            } else {
                l.drawUprightLayer();
            }
            curLayer++;
            popMatrix();
        }
    }

    public KLayer generateLayer(PApplet pApplet, int numPanels, float distCenter, int layerId) {
        float mode = random(1);
        if(mode < 1) {
            return new GrowingTriangles(pApplet, numPanels, distCenter, layerId);
        } else {
            return new KLayer(pApplet, numPanels, distCenter, layerId);
        }

    }

    public KBackground generateBackground(PApplet pApplet, int layerId) {
        float mode = random(1);
        if(mode < 1) {
            return new GrowingRing(pApplet, layerId);
        } else {
            return new KBackground(pApplet, layerId);
        }
    }
}
