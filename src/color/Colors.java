package color;

import processing.core.PApplet;

public class Colors {

    public static PApplet pApplet = new PApplet();

    public Colors(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public static int BLACK = pApplet.color(0, 0, 0, 255);
    public static int WHITE = pApplet.color(255, 255, 255, 255);
    public static int RED = pApplet.color(255, 0, 0, 255);
    public static int GREEN = pApplet.color(0, 255, 0, 255);
    public static int BLUE = pApplet.color(0, 0, 255, 255);

    public int changeRed(int c, float amount) {
        float r = pApplet.red(c);
        float g = pApplet.green(c);
        float b = pApplet.blue(c);
        float a = pApplet.alpha(c);
        return pApplet.color(r+amount, g, b, a);
    }

    public int changeGreen(int c, float amount) {
        float r = pApplet.red(c);
        float g = pApplet.green(c);
        float b = pApplet.blue(c);
        float a = pApplet.alpha(c);
        return pApplet.color(r, g+amount, b, a);
    }

    public int changeBlue(int c, float amount) {
        float r = pApplet.red(c);
        float g = pApplet.green(c);
        float b = pApplet.blue(c);
        float a = pApplet.alpha(c);
        return pApplet.color(r, g, b+amount, a);
    }

    public int changeAlpha(int c, float amount) {
        float r = pApplet.red(c);
        float g = pApplet.green(c);
        float b = pApplet.blue(c);
        float a = pApplet.alpha(c);
        return pApplet.color(r, g, b, a+amount);
    }



}
