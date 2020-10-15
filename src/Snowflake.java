import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//import static ch.unibas.informatik.jturtle.TurtleCommands.*;

public class Snowflake {

    /**
     * Zeichnet die Kochkurve auf dem aktuellen Rekursionslevel.
     * Das Argument length gibt an wie lange ein Liniensegment sein soll
     */


    static void drawKochCurve(int depth, double length, Turtle t) {

        // TODO Ihre Implementation

        if (depth == 0) {
            t.forward(length);
        } else {
            drawKochCurve(depth - 1, length / 3,t);
            t.left(60);
            drawKochCurve(depth - 1, length / 3,t);
            t.right(120);
            drawKochCurve(depth - 1, length / 3,t);
            t.left(60);
            drawKochCurve(depth - 1, length / 3,t);
        }
    }


    /**
     * Zeichnet eine Scheeflocke, durch mehrmaliges zeichnen der Kochkurve
     */
    static void drawSnowflake(int depth, int length) {
        // TODO Ihre Implemmentation

    }


    /**
     * Speichert das gezeichnete Bild.
     */
/*    static void saveImage(String filename) {
        BufferedImage image = drawing();

        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

      }*/

    /**
     * Testprogramm um Zeichnung mit verschiedenen Rekursionstiefen zu generieren.
     */
    public static void main(String[] args) {
        
        Turtle heinrich = new Turtle();
        heinrich.speed(0);

        for (int depth = 1; depth < 4; depth++) {
            //clear();
            //home();
            drawKochCurve(depth, 60, heinrich);
            //saveImage("koch-" +depth +".png");
        }

        for (int depth = 1; depth < 4; depth++) {
            //clear();
            //home();
            drawSnowflake(depth, 60);
            //saveImage("snowflake-" +depth +".png");
        }
    }
}
