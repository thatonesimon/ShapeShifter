// use CLI to auto generate skeleton of class
// javac ClassGenerator.java
// java ClassGenerator <class_name>
public class ClassGenerator {

    public static String c;
    public String tab = "    ";

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        c = args[0];

        System.out.println(classDef());
    }

    public static String classDef() {
        String start =  "public class " + c + " extends PAppletController implements Drawing {\n\n";
        String end = "}";

        return  imports() +
                start +
                constructor() +
                setup() +
                draw() +
                end;
    }

    public static String constructor() {
        return  "    public " + c + "(PApplet pApplet) {\n" +
                "        super(pApplet);\n    }\n\n";
    }

    public static String setup() {
        return  "    public void setup() {\n\n    }\n\n";
    }

    public static String draw() {
        return  "    public void draw() {\n" +
                "        pushMatrix();\n" +
                "        center();\n\n" +
                "        popMatrix();\n" +
                "    }\n\n";
    }

    public static String imports() {
        return  "import model.Drawing;\n" +
                "import model.PAppletController;\n" +
                "import processing.core.PApplet;\n\n";
    }
}