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
        centerRipples.add(0);
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

    public float grow[][];
    public ArrayList<PVector> ripples = new ArrayList<>();

    public void draw() {
        colorMode(HSB);
        background(Colors.BLACK);
        ripple();
        // rippleFromCenter();
        for(int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                PVector p = points[i][j];

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
                        grow[i][j] = 20;
                    }

                }
            }
            r.z++;
        }

    }

    ArrayList<Integer> centerRipples = new ArrayList<>();
    int r = 0;
    void rippleFromCenter() {

        PVector center = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                PVector p = points[i][j];
                // 10 is thickness of ring
                if(center.dist(p) < r && center.dist(p) > r-10) {
                    grow[i][j] = 20;
                }

            }
        }
        r++;
        if(r > cross/2.0) {
            r = 0;
        }
    }

    public void shrink() {
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points[0].length; j++) {
                if(grow[i][j] > 0.1) {
                    grow[i][j]*=0.75;
                }
            }
        }
    }
}
