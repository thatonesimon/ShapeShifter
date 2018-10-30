import circles.FloweringCircles;
import circles.Tentacles;
import model.Drawing;
import polygons.RotatingShapes;
import processing.core.PApplet;
import squares.BorderedSquare;

import java.util.ArrayList;

public class MainController extends PApplet {

    int curDrawing = 0;

    ArrayList<Drawing> drawings = new ArrayList<>();

    public void settings() {
       size(400, 400);
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
        drawings.add(new FloweringCircles(this));
        // drawings.add(new Tentacles(this));
        // drawings.add(new BorderedSquare(this));
        // drawings.add(new RotatingShapes(this));

        drawings.get(0).setup();
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
        PApplet.main("MainController");

    }

}

