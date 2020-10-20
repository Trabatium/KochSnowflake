import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import static ch.unibas.informatik.jturtle.TurtleCommands.*;

public class Snowflake {

    /**
     * Zeichnet die Kochkurve auf dem aktuellen Rekursionslevel.
     * Das Argument length gibt an wie lange ein Liniensegment sein soll
     */

    static void drawKochCurve(int depth, double length) {
        double angle = 60;
        
        if (depth > 0) {
            depth--;
            length /= 3;
            drawKochCurve(depth, length);
            turnLeft(angle);
            drawKochCurve(depth, length);
            turnRight(angle * 2);
            drawKochCurve(depth, length);
            turnLeft(angle);
            drawKochCurve(depth, length);
        } else {
            forward(length);
        }
    }

    /**
     * Zeichnet eine Scheeflocke, durch mehrmaliges zeichnen der Kochkurve
     */
    static void drawSnowflake(int depth, int length) {
        for (int i = 0; i < 3; i++) {
            drawKochCurve(depth,length);
            turnRight(120);
        }
    }


    /**
     * Speichert das gezeichnete Bild.
     */
    static void saveImage(String filename) {
        BufferedImage image = drawing();

        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

      }

    /**
     * Testprogramm um Zeichnung mit verschiedenen Rekursionstiefen zu generieren.
     */
    public static void main(String[] args) {

        for (int depth = 1; depth < 4; depth++) {
            clear();
            home();
            turnRight(90);
            drawKochCurve(depth, 60);
            saveImage("koch-" +depth +".png");
        }

        for (int depth = 1; depth < 4; depth++) {
            clear();
            home();
            turnRight(90);
            drawSnowflake(depth, 60);
            saveImage("snowflake-" +depth +".png");
        }
    }
}
