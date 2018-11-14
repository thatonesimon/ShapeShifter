package grid;

import processing.core.PApplet;
import processing.core.PVector;

public class VortexGrid extends SquareGrid {

    public VortexGrid(PApplet pApplet) {
        super(pApplet);
        // gravity.add(new PVector(radius*cos(radians(millis()))+width/2.0f, radius*sin(radians(millis()))+height/2.0f));
        // gravity.add(new PVector(2*radius*cos(radians(millis()))+width/2.0f, 2*radius*sin(radians(millis()))+height/2.0f));
        originalDist = new float[points.length][points[0].length];
        PVector c = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < originalDist.length; i++) {
            for (int j = 0; j < originalDist[0].length; j++) {
                originalDist[i][j] = c.dist(points[i][j]);
            }
        }
        originalAngle = new float[points.length][points[0].length];
        for(int i = 0; i < originalAngle.length; i++) {
            for (int j = 0; j < originalAngle[0].length; j++) {
                originalAngle[i][j] = atan2(points[i][j].y-c.y,points[i][j].x-c.x);
            }
        }
    }

    public void setup() {
        noStroke();
    }

    int radius = 200;

    public void draw() {
        super.draw();
        vortex();
    }

    void vortex() {
        PVector center = new PVector(width/2.0f, height/2.0f);
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                PVector p = points[i][j];
                float angle = atan2(-p.y+center.y, -p.x+center.x);
                float dist = originalDist[i][j];

                angle = angle+dist/400.f*radians(1);
                p.x = width/2.0f+dist*cos(angle);
                p.y = height/2.0f+dist*sin(angle);
            }
        }
    }

    float[][] originalDist;
    float[][] originalAngle;


}
