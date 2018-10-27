import circles.Tentacles;
import model.Drawing;
import processing.core.PApplet;

import java.util.ArrayList;

public class MainController extends PApplet {

    int curDrawing = 0;

    ArrayList<Drawing> drawings = new ArrayList<>();

    public void settings() {
//        size(800, 800);
        fullScreen(OPEN);
    }

    public void draw() {
        drawings.get(curDrawing%drawings.size()).draw();
    }

    public void setup() {
        drawings.add(new Tentacles(this));
        drawings.add(new BorderedSquare(this));

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

