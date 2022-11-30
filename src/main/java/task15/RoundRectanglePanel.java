package task15;

import javax.swing.*;
import java.awt.*;

/**
 * The class serves to painting the round rectangle
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class RoundRectanglePanel extends JPanel {
    private Color defaultColor = Color.black;
    private int arcWidth = 1;
    private int arcHeight = 1;

    /**
     * Class constructor. Creates a round rectangle panel
     */
    public RoundRectanglePanel() {
        this.setPreferredSize(new Dimension(200, 200));
        this.setVisible(true);
        this.setLayout(null);
    }

    /**
     * Repaint rectangle
     *
     * @param newColor       the new color
     * @param roundingWidth  the rounding width
     * @param roundingHeight the rounding height
     */
    public void repaint(String newColor, int roundingWidth, int roundingHeight) {
        arcWidth = roundingWidth;
        arcHeight = roundingHeight;
        recolor(newColor);
    }

    private void recolor(String newColor) {
        switch (newColor) {
            case "Red":
                defaultColor = Color.red;
                break;
            case "Blue":
                defaultColor = Color.blue;
                break;
            case "Green":
                defaultColor = Color.green;
                break;
            default:
                defaultColor = Color.black;
                break;
        }
        paintComponent(this.getGraphics());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(defaultColor);
        g.drawRoundRect(10, 10, 180, 180, arcWidth, arcHeight);
    }
}
