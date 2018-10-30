package polygons;

import color.Colors;
import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;

public class RotatingShapes extends PAppletController implements Drawing {

    int numLayers = 50;
    float layerSize = sqrt(width*width+height*height)/(float)numLayers/2;
    int numColors = 2;
    int[] colors = new int[numColors];


    int sides = 3;
    float rotation = 5;

    public void keyPressed() {
        if(keyCode() == 37) {
            // left
            sides--;
        } else if(keyCode() == 39) {
            sides++;
        }
    }

    public void mouseMoved() {

    }

    public void setup() {
    }

    public RotatingShapes(PApplet pApplet) {
        super(pApplet);

        colors[0] = Colors.BLACK;
        colors[1] = Colors.RED;
    }

    public void draw() {
        translate(width/2, height/2);
        background(0);
        noStroke();
        for(int i = numLayers-1; i >= 0; i--) {
            fill(colors[i%numColors]);
            rotate(radians(rotation));
            float inSize = layerSize*i;
            drawShape(inSize);

        }
        rotation += 1.0/numLayers;
    }

    public void drawShape(float size) {

        ArrayList<float[]> points = new ArrayList();
        beginShape();
        for(float i = 0; i < 360; i += 360/sides) {
            float x = size*(cos(radians(i)));
            float y = size*(sin(radians(i)));
            vertex(x, y);

            // float[] point = new float[2];
            // point[0] = x;
            // point[1] = y;
            // points.add(point);
        }
        endShape(CLOSE);

        // for(float[] point : points) {
        //     image(eyes[0], point[0], point[1], 50, 50);
        // }

    }

}