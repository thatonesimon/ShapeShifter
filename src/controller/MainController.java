package controller;

import grid.GravityGrid;
import grid.VortexGrid;
import model.Drawing;
import processing.core.PApplet;

import java.util.ArrayList;

public class MainController extends PApplet {

    int curDrawing = 0;

    ArrayList<Drawing> drawings = new ArrayList<>();

    public void settings() {
       size(800, 800);
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
        drawings.add(new VortexGrid(this));
        drawings.add(new GravityGrid(this));
        // drawings.add(new FloweringCircles(this));
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

    public void mousePressed() {
        Drawing drawing = drawings.get(curDrawing%drawings.size());
        drawing.mousePressed();
    }

    public static void main(String... args){
        PApplet.main("controller.MainController");

    }

}

