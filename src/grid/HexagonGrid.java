package grid;

import processing.core.PApplet;

public class HexagonGrid extends BaseGrid {

    public HexagonGrid(PApplet pApplet) {
        super(pApplet);
    }

    public void setup() {

    }

    public void draw() {
        pushMatrix();
        center();

        popMatrix();
    }

    /*
    hex would go across 4 rows
      2 3
    1     4
      6 5
     */
    public void setupPoints() {

    }

}

