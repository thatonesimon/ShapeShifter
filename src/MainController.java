
import circles.FloweringCircles;
import circles.Targets;
import circles.Tentacles;
import curves.BezierDemo;
import grid.*;
import kaleidoscope.KaleidoscopeGenerator;
import model.Drawing;
import model.PAppletController;
import polygons.RotatingShapes;
import polygons.StarOfDavid;
import processing.core.PApplet;
import squares.BorderedSquare;

import java.util.ArrayList;

public class MainController extends PApplet {

    int curDrawing = 0;

    ArrayList<Drawing> drawings = new ArrayList<>();

    public void settings() {
       size(800, 800);
       // fullScreen(JAVA2D);
    }

    public void draw() {
        PAppletController.rotateT = radians(millis()/30.0f);
        try {
            drawings.get(curDrawing%drawings.size()).draw();

        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public void setup() {
        // drawings.add(new StarOfDavid(this));
        drawings.add(new CircleGrid(this));
        drawings.add(new TriangleGrid(this));
        drawings.add(new GravityGrid(this, new TriangleGrid(this)));
        drawings.add(new GravityGrid(this, new SquareGrid(this)));

        // drawings.add(new BezierDemo(this));
        drawings.add(new Targets(this));
        drawings.add(new KaleidoscopeGenerator(this));
        drawings.add(new VortexGrid(this));
        drawings.add(new FloweringCircles(this));
        drawings.add(new Tentacles(this));
        drawings.add(new BorderedSquare(this));
        drawings.add(new RotatingShapes(this));

        drawings.get(0).setup();

        // noLoop();
    }

    public void keyPressed() {
        if(key == ' ') {
            curDrawing++;
            drawings.get(curDrawing%drawings.size()).setup();
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

