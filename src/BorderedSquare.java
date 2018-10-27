import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;

public class BorderedSquare extends PAppletController implements Drawing {


    public void keyPressed() {
    }

    public void mouseMoved() {

    }

    public void setup() {
        colorMode(RGB);
        rectMode(CENTER);

    }

    public BorderedSquare(PApplet pApplet) {
        super(pApplet);

        int size = max(width, height);

        this.outSize = size;
        this.inSize = dif*outSize;
        this.strokeW = size/50;

        float in = inSize/2;
        float out = outSize/2;

        float y1 = -inSize/2;
        float y2 = -outSize/2;
        for(int i = 0; i < numArms; i++) {

            if(y2 < -inSize/2) {
                arms.add(new Arm(in, -inSize/2, out, y2));
            } else if(y2 > inSize/2) {
                arms.add(new Arm(in, inSize/2, out, y2));
            } else {
                arms.add(new Arm(in, y2, out, y2));
            }
            y2+=outSize/numArms;
        }

        // int x1 = inSize/(numArms+1);
        // int y1 = 0;
        // int x2 = outSize/2;
        // int y2 = 0;
        //
        // arms.add(new Arm(x1, y1, x2, y2));

    }

    float strokeW;
    float dif = (float) 0.75;
    float outSize;
    float inSize;
    int numArms = 10;
    ArrayList<Arm> arms = new ArrayList<>(numArms);

    int numLayers = 13;

    int dir = 4;

    public class Arm {
        float x1;
        float y1;
        float x2;
        float y2;

        public float deg = 0;

        public Arm(float deg) {
            this.deg = deg;
        }

        public Arm(float x1, float y1, float x2, float y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public void draw() {

            for(int i = 0; i < 4; i++) {
                rotate(radians(360/4));
                line(x1, y1, x2, y2);
            }
        }

        public void next() {
            // right
            if(x1 == inSize/2 && x2 == outSize/2 && abs(y2) <= outSize/2) {
                if(abs(y1) <= inSize/2 && abs(y2) <= inSize/2) {
                    y1+=dir;
                }
                y2+=dir;
                // bottom
            }
            if(y1 == inSize/2 && y2 == outSize/2 && abs(x2) <= outSize/2) {
                if(abs(x1) <= inSize/2 && abs(x2) <= inSize/2) {
                    x1-=dir;
                }
                x2-=dir;
                // left
            }
            if(x1 == -inSize/2 && x2 == -outSize/2 && abs(y2) <= outSize/2) {
                if(abs(y1) <= inSize/2 && abs(y2) <= inSize/2) {
                    y1-=dir;
                }
                y2-=dir;
                // top
            }
            if(y1 == -inSize/2 && y2 == -outSize/2&& abs(x2) <= outSize/2) {
                if(abs(x1) <= inSize/2 && abs(x2) <= inSize/2) {
                    x1+=dir;
                }
                x2+=dir;
            }

            check();
        }

        public void check() {
            if(x1 > inSize/2) {
                x1 = inSize/2;
            }
            if(x1 < -inSize/2) {
                x1 = -inSize/2;
            }
            if(y1 > inSize/2) {
                y1 = inSize/2;
            }
            if(y1 < -inSize/2) {
                y1 = -inSize/2;
            }
            if(x2 > outSize/2) {
                x2 = outSize/2;
            }
            if(x2 < -outSize/2) {
                x2 = -outSize/2;
            }
            if(y2 > outSize/2) {
                y2 = outSize/2;
            }
            if(y2 < -outSize/2) {
                y2 = -outSize/2;
            }
        }


    }

    public void draw() {
        background(5);
        center();
        // scale(1.5+0.5*sin(radians(t)), 1.5+0.5*cos(radians(t)));
        stroke(220);
        noFill();

        // for(int i = 0; i < numArms; i++) {
        //     line(inSize/2, -t, outSize/2, -t);
        // }
        for(int i = 0; i < numLayers; i++) {
            stroke(250);
            strokeWeight(strokeW);
            drawWithLine();
            scale(-dif, dif);
            rotate(radians((float)millis()/100*(i+1)/10));
        }
        for(Arm a : arms) {
            a.next();
        }
        if((float)millis()/100 == 900) {
            noLoop();
        }
    }

    public void drawWithLine() {
        rect(0, 0, outSize, outSize);
        rect(0, 0, inSize, inSize);
        for(Arm a : arms) {
            a.draw();
        }
    }

    public void drawWithCircle() {
        // for(int i = 0; i < numArms; i++) {
        //     float deg = i*360.0/numArms+t;
        //
        //     float x1 = inSize*cos(radians(deg))/2;
        //     float y1 = inSize*sin(radians(deg))/2;
        //     float x2 = outSize*cos(radians(deg))/2;
        //     float y2 = outSize*sin(radians(deg))/2;
        //
        //     float dx = x2-x1;
        //     float dy = y2-y2;
        //
        //     float dx1 = inSize-x1;
        //     float dx2 = outSize-x2;
        //
        //     float dt1 = dx1/dx;
        //     float dt2 = dx2/dx;
        //
        //
        //     line(x1, y1, x2, y2);
        //
        // }
    }

}
