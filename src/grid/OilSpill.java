package grid;

import model.Drawing;
import model.PAppletController;
import processing.core.PApplet;

import java.util.ArrayList;

public class OilSpill extends PAppletController implements Drawing {

    public OilSpill(PApplet pApplet) {
        super(pApplet);
        setup();
    }

    public void setup() {
        noFill();
        numRow = width/20;
        numColumn = height/20;
        total = numRow*numColumn;

        xStep = width/numRow;
        yStep = height/numColumn;

        for(int i = 0; i < total; i++) {
            shapes.add(new Shape());
        }

        // autoclick middle
        shapes.get(shapes.size()/2 + numRow/2).pulse = maxPulse;

        strokeWeight(250.0f/numRow);
        colorMode(HSB, maxPulse+1);

        for(int i = 0; i < 10; i++) {
            int index = (int) random(shapes.size());
            shapes.get(index).pulse = maxPulse;
        }
    }

    int numRow;
    int numColumn;
    int total;
    int maxPulse = 10;
    float startRad = 10;

    float xStep;
    float yStep;

    ArrayList<Shape> shapes = new ArrayList<>();

    class Shape {

        float pulse = 0;
        float lastTrig = 0;

        public Shape() {

        }

        public void shouldPulse() {
            if(lastTrig <= 0) {
                pulse = maxPulse;

                // play with this
                lastTrig = 4;
            } else {
                lastTrig-=1;
            }
        }

        public void draw(float x, float y) {
            pApplet.ellipse(x, y, startRad+pulse, startRad+pulse);
        }
    }

    public void draw() {
        pushMatrix();
        // center();
        background(0);

        check();

        for(int i = 0; i < numRow; i++) {
            float x = (i+0.5f)*width/numRow;
            for(int j = 0; j < numColumn; j++) {
                float y = (j+0.5f)*height/numColumn;
                int index = i+j*numRow;
                stroke(shapes.get(index).pulse, maxPulse+1, maxPulse+1);
                if(i+j%2 ==0) {
                    ellipse(x, y, startRad+shapes.get(index).pulse, startRad+shapes.get(index).pulse);
                } else {
                    ellipse(x, y, startRad+shapes.get(index).pulse, startRad+shapes.get(index).pulse);
                }
            }
        }

        popMatrix();
    }

    public void check() {
        for(int i = 0; i < total; i++) {
            Shape shape = shapes.get(i);
            if(shape.pulse > 0) {
                shape.pulse -= 0.5;
                if(shape.pulse < 5) {
                    try {
                        shapes.get((i-1)%total).shouldPulse();
                        shapes.get((i+1)%total).shouldPulse();
                        shapes.get((i-numRow)%total).shouldPulse();
                        shapes.get((i+numRow)%total).shouldPulse();
                    } catch (Exception e) {

                    }

                }
            }
        }
    }

}
/*
import random

def setup():

    # size(720, 720)
    # size(720, 720, OPENGL)

    # for full
    fullScreen(OPENGL)
    global num_row, num_col, total
    num_row = width/20
    num_col = height/20
    total = num_row*num_col

    colorMode(HSB, max_pulse+1)
    # frameRate(30)
    global shapes
    for i in range(total):
        shapes.append(Shape())

    global x_step, y_step
    x_step = width/num_row
    y_step = height/num_col

    # to auto click middle
    # shapes[(len(shapes))/2+num_row/2].pulse = max_pulse

    # to auto click bottom right
    # shapes[len(shapes)-1].pulse = max_pulse

    for i in range(10):
        index = random.randint(0,len(shapes))
        shapes[index].pulse = max_pulse

def mouseClicked():

    x = (mouseX/x_step)-1
    y = (mouseY/y_step)-1
    shapes[x+num_row*y].pulse = max_pulse

def keyPressed():
    global shapes
    if key == " ":
        for s in shapes:
            s.pulse = 0
            s.last_trig = 0

    elif key == "z":
        shapes[random.randint(0, len(shapes))].pulse = max_pulse


def center():

    # move to middle
    translate(width/2, height/2)
    # flip the y
    scale(1, -1)
    rotate(radians(-90))

num_row = 45
num_col = 45
total = num_row*num_col
shapes = []
rot = 0
def draw():

    background(0)

    circleCheck()

    noFill()
    strokeWeight(250.0/num_row)
    for i in range(num_row):
        x = (i+0.5)*width/num_row
        for j in range(num_col):
            y = (j+0.5)*height/num_col
            # fill(shapes[i+num_row*j].pulse, max_pulse+1, max_pulse+1)
            stroke(shapes[i+num_row*j].pulse, max_pulse+1, max_pulse+1)
            # circle(x, y, start_rad+shapes[i+num_row*j].pulse)
            if (i+j)%2 == 0:
                circle(x, y, start_rad+shapes[i+num_row*j].pulse)
            else:
                square(x, y, start_rad+shapes[i+num_row*j].pulse)

def circleCheck():
    global shapes
    # to auto click middle
    # shapes[(num_row/2)+num_col*(num_col/2)].pulse = 4
    for i, c in enumerate(shapes):

        if c.pulse > 0:
            c.pulse -= 0.5
            # c.pulse -= max_pulse/25.0
            if c.pulse < 5:
                shapes[(i-1)%total].shouldPulse()
                shapes[(i+1)%total].shouldPulse()
                shapes[(i-num_row)%total].shouldPulse()
                shapes[(i+num_row)%total].shouldPulse()

def circle(x, y, rad):
    ellipse(x, y, rad, rad)

def square(x, y, side):
    center_x = x-side/2
    center_y = y-side/2
    rect(center_x, center_y, side, side)


start_rad = 10
max_pulse = 10
class Shape:

    def __init__(self):
        self.pulse = 0
        self.last_trig = 0

    def shouldPulse(self):
        if self.last_trig <= 0:
            self.pulse = max_pulse
            # PLAY WITH THIS VAL (4)
            self.last_trig = 4
        else:
            self.last_trig -= 1

    def show(self, x, y):
        circle(x, y, start_rad+self.pulse)
 */