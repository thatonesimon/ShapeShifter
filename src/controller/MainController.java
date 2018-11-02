package controller;

import circles.FloweringCircles;
import circles.Tentacles;
import color.Colors;
import grid.BaseGrid;
import model.Drawing;
import polygons.RotatingShapes;
import processing.core.PApplet;
import squares.BorderedSquare;

import java.util.ArrayList;

public class MainController extends PApplet {

    int curDrawing = 0;

    ArrayList<Drawing> drawings = new ArrayList<>();

    public Colors colors = new Colors(this);

    public void settings() {
       size(1000, 1000);
       // fullScreen(JAVA2D);
    }

    public void draw() {
        try {
            drawings.get(curDrawing%drawings.size()).draw();

        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public void setup() {
        // drawings.add(new BaseGrid(this));
        drawings.add(new FloweringCircles(this));
        // drawings.add(new Tentacles(this));
        // drawings.add(new BorderedSquare(this));
        // drawings.add(new RotatingShapes(this));

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

    public static void main(String... args){
        PApplet.main("controller.MainController");

    }

}

