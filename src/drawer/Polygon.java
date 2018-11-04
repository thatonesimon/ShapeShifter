package drawer;

import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.radians;

public class Polygon {


    public static void drawShape(PApplet pApplet, int sides, float size) {
        pApplet.pushMatrix();
        pApplet.beginShape();
        for(float i = -90.0f; i < 360.0f-90.0f; i+=360.0f/sides) {
            float x = size*PApplet.cos(radians(i));
            float y = size*PApplet.sin(radians(i));
            pApplet.vertex(x, y);
        }
        pApplet.endShape(PConstants.CLOSE);
        pApplet.popMatrix();
    }

    public static void drawShape(PApplet pApplet, float x, float y, int sides, float size) {
        pApplet.pushMatrix();
        pApplet.beginShape();
        // for(float i = -90.0f; i < 360.0f-90.0f; i+=360.0f/sides) {

        for(float i = 0; i < 360; i+=360.0f/sides) {
            float vertexX = size*PApplet.cos(radians(i));
            float vertexY = size*PApplet.sin(radians(i));
            pApplet.vertex(vertexX+x, vertexY+y);
        }
        pApplet.endShape(PConstants.CLOSE);
        pApplet.popMatrix();
    }

    public static void drawStar(PApplet pApplet, int sides, float size) {
        pApplet.pushMatrix();
        pApplet.beginShape();

        float inSize = size*3/4.0f;
        float outSize = size*5/4.0f;
        float angleOffset = 360/sides/2.0f;

        for(float i = 0; i < 360; i+=360.0f/sides) {
            float vertexX = inSize*PApplet.cos(radians(i));
            float vertexY = inSize*PApplet.sin(radians(i));
            pApplet.vertex(vertexX, vertexY);

            vertexX = outSize*PApplet.cos(radians(i+angleOffset));
            vertexY = outSize*PApplet.sin(radians(i+angleOffset));
            pApplet.vertex(vertexX, vertexY);
        }
        pApplet.endShape(PConstants.CLOSE);
        pApplet.popMatrix();
    }

}
