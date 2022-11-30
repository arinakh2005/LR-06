import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static task28.task28.*;

public class Task28Test {
    @Test
    public void initJFrameWithTitle() {
        System.out.println("should check initialization JFrame with title");
        String expected = "Draw Triangle";

        initJFrame();
        String actual = jFrame.getTitle();

        assertEquals(actual, expected);
    }

    @Test
    public void checkAddingElementToJFrame() {
        System.out.println("should check adding component to JFrame");
        JPanel panel = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        initJFrame();

        boolean actual = addElementToJFrame(jFrame, panel, constraints, 0, 0);

        assertTrue(actual);
    }
}
