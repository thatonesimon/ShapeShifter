package grid;

import color.Colors;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GridOfSquares extends SquareGrid {

    public GridOfSquares(PApplet pApplet) {
        super(pApplet);
        grow = new float[points.length][points[0].length];
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points[0].length; j++) {
                grow[i][j] = 20;
            }
        }
    }

    public void setup() {
        noFill();
        strokeWeight(5);
        stroke(Colors.RED);
        rectMode(CENTER);
    }

    public void mousePressed() {
        PVector p = new PVector(mouseX(), mouseY(), 0);
        ripples.add(p);
    }

    Timer t = new Timer(2000);
    int maxGrow = 15;
    float grow[][];
    ArrayList<PVector> ripples = new ArrayList<>();

    public void draw() {
        background(Colors.BLACK);
        centerRipple();
        ripple();
        // rippleFromCenter();
        colorMode(HSB);
        for(int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                PVector p = points[i][j];

                stroke(map(grow[i][j], 0, maxGrow, 0, 255), 255, 255);
                rect(p.x, p.y, 10+grow[i][j], 10+grow[i][j]);
            }
        }
        shrink();
        // this is bad
        colorMode(RGB);
    }

    float thick = 10;
    public void ripple() {

        // z = the current ripple size
        for(PVector r : ripples) {
            for(int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {
                    PVector p = points[i][j];
                    PVector rippleCenter = new PVector(r.x, r.y);
                    if(rippleCenter.dist(p) > r.z && rippleCenter.dist(p) < r.z+thick) {
                        grow[i][j] = maxGrow;
                    }

                }
            }
            r.z++;
        }
        ripples.removeIf(r -> r.z > cross/4.0f);
    }

    void autoRipple() {
        if(t.trigger()) {
            PVector p = new PVector(random(width), random(height), 0);
            ripples.add(p);
        }
    }

    void centerRipple() {
        if(t.trigger()) {
            PVector p = new PVector(width/2.0f, height/2.0f, 0);
            ripples.add(p);
        }
    }

    public void shrink() {
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points[0].length; j++) {
                if(grow[i][j] > 0.1) {
                    grow[i][j]-=0.5;
                }
            }
        }
    }
}
