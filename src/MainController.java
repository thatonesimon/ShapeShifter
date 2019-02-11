
import circles.*;
import color.ColorWalk;
import color.Colors;
import curves.BezierDemo;
import curves.Spiral;
import grid.*;
import kaleidoscope.KaleidoscopeGenerator;
import model.Drawing;
import model.PAppletController;
import polygons.RotatingShapes;
import polygons.StarOfDavid;
import processing.core.PApplet;
import squares.BorderedSquare;
import stripes.BaseStripes;
import stripes.WobbleStripes;

import java.awt.*;
import java.util.ArrayList;

import static model.PAppletController.cross;

public class MainController extends PApplet {

    int curDrawing = 0;

    ArrayList<Drawing> drawings = new ArrayList<>();

    int w = 1000;
    int h = 1000;

    public void settings() {
        size(w, h);
        // fullScreen(P2D);
    }

    public void draw() {
        PAppletController.rotateT = radians(millis()/30.0f);
        try {
            drawings.get(curDrawing%drawings.size()).draw();
            // circleFrame();
            // smiley();

        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public void circleFrame() {
        resetMatrix();
        int thickness = w/20;
        int numLayers = 1;
        noFill();
        stroke(Colors.WHITE);
        translate(w/2, h/2);
        strokeWeight(thickness+220);
        for(int i = 1; i < numLayers+1; i++) {
            // strokeWeight(i*thickness/numLayers);
            ellipse(0, 0, cross-200, cross-200);
        }
        // ellipse(0, 0, thickness/numLayers, thickness/numLayers);
        strokeWeight(2);
        stroke(Colors.BLACK);
        ellipse(0, 0, width, width);
        noStroke();
    }

    public void smiley() {
        background(Colors.WHITE);
        int s = 2*min(width, height)/3;
        int thick = s/20;
        stroke(Colors.BLACK);
        strokeWeight(thick);
        noFill();
        pushMatrix();
        translate(w/2, h/2);

        ellipse(0, 0, s, s);

        // eyes
        ellipse(-s/3, -s/6, thick, thick);
        ellipse(s/3, -s/6, thick, thick);

        // mouth
        float ratio = 3/4f;
        arc(0, 0, s*ratio, s*ratio, 0, PI);

        popMatrix();
    }

    public void setup() {
        // frameRate(2);

        // blendMode(ADD);

        // drawings.add(new CircuitSnake(this));
        // drawings.add(new Diffusion(this));

        // current work
        // drawings.add(new Smiley(this));

        drawings.add(new Spiral(this));

        // circles
        drawings.add(new FloweringCircles(this));
        drawings.add(new Targets(this));
        drawings.add(new Tentacles(this));

        // curves
        drawings.add(new BezierDemo(this));

        // grid
        drawings.add(new CircleGrid(this));
        drawings.add(new GravityGrid(this, new TriangleGrid(this)));
        drawings.add(new GravityGrid(this, new SquareGrid(this)));
        drawings.add(new GridOfSquares(this));
        // drawings.add(new HexagonGrid(this));
        drawings.add(new SquareGrid(this));
        drawings.add(new TriangleGrid(this));
        drawings.add(new VortexGrid(this, new SquareGrid(this)));

        // kaleidoscope
        drawings.add(new KaleidoscopeGenerator(this));

        // polygons
        drawings.add(new RotatingShapes(this));
        drawings.add(new StarOfDavid(this));

        // stripes
        drawings.add(new BaseStripes(this));
        drawings.add(new WobbleStripes(this));

        // squares
        drawings.add(new BorderedSquare(this));


        drawings.get(0).setup();
        // noLoop();
    }

    private boolean running = true;
    public void keyPressed() {
        if(key == ' ') {
            curDrawing++;
            drawings.get(curDrawing%drawings.size()).setup();
        } else if(key == 'p') {
            running = !running;
            if(running) {
                loop();
            } else {
                noLoop();
            }
        } else if(key == 's') {
            saveFrame("/Users/swong/Desktop/shmoove######.jpg");
        }
        Drawing drawing = drawings.get(curDrawing%drawings.size());
        drawing.keyPressed();

    }

    public void mousePressed() {
        Drawing drawing = drawings.get(curDrawing%drawings.size());
        drawing.mousePressed();
    }

    public static void main(String... args){
        PApplet.main("MainController");

    }

}

