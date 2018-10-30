package model;

import processing.core.PApplet;

public class PAppletController extends PApplet {

    public PApplet pApplet;

    public PAppletController(PApplet pApplet) {
        this.pApplet = pApplet;
        width = pApplet.width;
        height = pApplet.height;
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

    // =================================================================================================================
    // setup
    // =================================================================================================================

    public void colorMode(int m) {
        pApplet.colorMode(m);
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
    public void fill(int c, int a) {
        pApplet.fill(c, a);
    }

    public void noFill() {
        pApplet.noFill();
    }

    public void stroke(int c) {
        pApplet.stroke(c);
    }

    public void noStroke() {
        pApplet.noStroke();
    }

    public void stroke(int r, int g, int b) {
        pApplet.stroke(r, g, b);
    }

    public void strokeWeight(float w) {
        pApplet.strokeWeight(w);
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

    public void rect(float x, float y, float w, float h) {
        pApplet.rect(x, y, w, h);
    }

    public void beginShape() {
        pApplet.beginShape();
    }

    public void endShape(int m) {
        pApplet.endShape(m);
    }

    public void vertex(float x, float y) {
        pApplet.vertex(x, y);
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
        pApplet.translate(width/2, height/2);
    }
}
