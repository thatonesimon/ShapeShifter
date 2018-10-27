import circles.Tentacles;
import model.Drawing;
import processing.core.PApplet;

public class MainController extends PApplet {

    Drawing drawing;

    public void settings() {
        size(800, 800);
        fullScreen();
    }

    public void draw() {
        try {
            drawing.draw();
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public void setup() {
        drawing = new Tentacles(this);
    }

    public static void main(String... args){
        PApplet.main("MainController");
    }

}

