package circles;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

// https://www.reddit.com/r/processing/comments/8jh3ha/circuit_pulse_effect/
public class CircuitSnake extends PAppletController implements Drawing {

    public CircuitSnake(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {
        colorMode(HSB);
        noStroke();
        burst(100);
    }

    class Snake {

        ArrayList<PVector> old = new ArrayList<>();

        float x, y, ang;
        float spd = 5;
        int sz = 5;
        int c;

        int tailLength = 50;

        boolean dead = false;

        public Snake(float x, float y, float ang, int c) {
            this.x = x;
            this.y = y;
            this.ang = ang;
            this.c = c;
        }

        void update() {
            if(random(1) > 0.95) {
                if(random(1) > 0.5) {
                    ang += PI/4;
                } else {
                    ang -= PI/4;
                }
            }

            old.add(new PVector(x, y));

            while(old.size() > tailLength) {
                old.remove(0);
            }

            x += cos(ang) * spd;
            y += sin(ang) * spd;

            if(old.get(0).x < 0 || old.get(0).x > width || old.get(0).y < 0 || old.get(0).y > height) {
                dead = true;
            }
        }

        void show() {
            fill(c, 255, 255);
            ellipse(x, y, sz, sz);
            if(old.size() > 1) {
                for(int i = 0; i < old.size(); i ++) {
                    fill(c, 255, 255, map(i, 0, old.size() - 1, 0, 255));
                    ellipse(old.get(i).x, old.get(i).y, sz, sz);
                }
            }
        }
    }

    ArrayList<Snake> snakes = new ArrayList<Snake>();
    public void draw() {
        background(0);
        for(int i = snakes.size() - 1; i >= 0; i --) {
            snakes.get(i).update();
            if(snakes.get(i).dead) {
                snakes.remove(i);
                continue;
            }
            snakes.get(i).show();
        }
        colorMode(RGB);
    }

    public void keyPressed() {
        if(key() == 'p') {
            burst(100);
        }
    }

    void burst(int num) {
        int c = (int)(random(255));
        for(int i = 0; i < num; i ++) {
            float a = (int)(random(8)) * PI/4;
            snakes.add(new Snake(width/2, height/2, a, c));
        }
    }

}



