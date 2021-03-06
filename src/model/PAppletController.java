package model;

import processing.core.PApplet;
import processing.core.PVector;

public class PAppletController extends PApplet {

    public static PApplet pApplet;
    public static float rotateT = 0;
    public static float cross = 0;
    public static PVector center;

    public PAppletController(PApplet pApplet) {
        this.pApplet = pApplet;
        width = pApplet.width;
        height = pApplet.height;
        cross = (float) Math.sqrt(width*width+height*height);
        center = new PVector(width/2.0f, height/2.0f);

    }

    public class Timer {

        int interval;
        int lastTrigger = 0;

        public Timer(int interval) {
            this.interval = interval;
        }

        public boolean trigger() {

            int cur = millis();

            if(cur - lastTrigger >= interval) {
                lastTrigger = cur;
                return true;
            }

            return false;
        }
    }

    // =================================================================================================================
    // controls
    // =================================================================================================================

    public char key() {
        return pApplet.key;
    }

    public int keyCode() {
        return pApplet.keyCode;
    }

    public int mouseX() {
        return pApplet.mouseX;
    }

    public int mouseY() {
        return pApplet.mouseY;
    }

    public void noLoop() {
        pApplet.stop();
    }

    // =================================================================================================================
    // setup
    // =================================================================================================================

    public void colorMode(int m) {
        pApplet.colorMode(m);
    }
    public void colorMode(int m, float i) {
        pApplet.colorMode(m, i);
    }

    public void rectMode(int m) {
        pApplet.rectMode(m);
    }

    public void ellipseMode(int m) {
        pApplet.ellipseMode(m);
    }

    public void background(int c) {
        pApplet.background(c);
    }

    // =================================================================================================================
    // drawing
    // =================================================================================================================

    public void fill(int c) {
        pApplet.fill(c);
    }
    public void fill(float c) {
        pApplet.fill(c);
    }
    public void fill(int c, int a) {
        pApplet.fill(c, a);
    }
    public void fill(float c, float a) {
        pApplet.fill(c, a);
    }
    public void fill(int r, int g, int b) {
        pApplet.fill(r, g, b);
    }
    public void fill(float r, float g, float b) {
        pApplet.fill(r, g, b);
    }
    public void fill(float r, float g, float b, float a) {
        pApplet.fill(r, g, b, a);
    }


    public void noFill() {
        pApplet.noFill();
    }

    public void stroke(int c) {
        pApplet.stroke(c);
    }
    public void stroke(float c) {
        pApplet.stroke(c);
    }

    public void noStroke() {
        pApplet.noStroke();
    }

    public void stroke(int r, int g, int b) {
        pApplet.stroke(r, g, b);
    }
    public void stroke(float r, float g, float b) {
        pApplet.stroke(r, g, b);
    }

    public void strokeWeight(float w) {
        pApplet.strokeWeight(w);
    }

    public void loadPixels() {
        pApplet.loadPixels();
    }

    public void updatePixels() {
        pApplet.updatePixels();
    }

    public int[] pixels() {
        return pApplet.pixels;
    }

    // =================================================================================================================
    // shapes
    // =================================================================================================================

    public void line(float x1, float y1, float x2, float y2) {
        pApplet.line(x1, y1, x2, y2);
    }

    public void ellipse(float x, float y, float w, float h) {
        pApplet.ellipse(x, y, w, h);
    }
    public void circle(float x, float y, float d) {
        pApplet.ellipse(x, y, d, d);
    }

    public void arc(float a, float b, float c, float d, float start, float stop) {
        pApplet.arc(a, b, c, d, start, stop);
    }

    public void rect(float x, float y, float w, float h) {
        pApplet.rect(x, y, w, h);
    }
    public void square(float x, float y, float side) {
        pApplet.rect(x, y, side, side);

    }

    public void poly(float x, float y, int sides, float size) {
        pushMatrix();
        beginShape();
        // for(float i = -90.0f; i < 360.0f-90.0f; i+=360.0f/sides) {

        for(float i = 0; i < 360; i+=360.0f/sides) {
            float vertexX = size*cos(radians(i));
            float vertexY = size*sin(radians(i));
            vertex(vertexX+x, vertexY+y);
        }
        endShape(CLOSE);
        popMatrix();
    }

    public void star(float x, float y, int sides, float size) {
        pushMatrix();
        beginShape();

        float inSize = size*3/4.0f;
        float outSize = size*5/4.0f;
        float angleOffset = 360/sides/2.0f;

        for(float i = 0; i < 360; i+=360.0f/sides) {
            float vertexX = inSize*cos(radians(i));
            float vertexY = inSize*sin(radians(i));
            vertex(vertexX+x, vertexY+y);

            vertexX = outSize*cos(radians(i+angleOffset));
            vertexY = outSize*sin(radians(i+angleOffset));
            vertex(vertexX+x, vertexY+y);
        }
        endShape(CLOSE);
        popMatrix();
    }

    public void beginShape() {
        pApplet.beginShape();
    }
    public void beginShape(int m) {
        pApplet.beginShape(m);
    }

    public void endShape() {
        pApplet.endShape();
    }
    public void endShape(int m) {
        pApplet.endShape(m);
    }

    public void vertex(float x, float y) {
        pApplet.vertex(x, y);
    }

    public void bezier(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
        pApplet.bezier(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    // =================================================================================================================
    // matrix
    // =================================================================================================================

    public void pushMatrix() {
        pApplet.pushMatrix();
    }

    public void popMatrix() {
        pApplet.popMatrix();
    }

    public void translate(float x, float y) {
        pApplet.translate(x, y);
    }

    public void rotate(float d) {
        pApplet.rotate(d);
    }

    public void scale(float x, float y) {
        pApplet.scale(x, y);
    }

    // =================================================================================================================
    // additional helpers
    // =================================================================================================================

    public void center() {
        pApplet.translate(width/2.0f, height/2.0f);
    }
}
