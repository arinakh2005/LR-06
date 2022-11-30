package task12;

import javax.swing.*;
import java.awt.*;

/**
 * The class serves to painting rectangle
 * with possibility to move image inside the rectangle and recolor the rectangle border
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class RectanglePanel extends JPanel {
    public final int MAX_BORDER = 150;
    public final int MIN_BORDER = 10;
    private final int STEP = 10;
    private final int IMAGE_SIZE = 50;
    private final int RECTANGLE_SIZE = 200;

    private Color defaultColor = Color.black;
    private int x = 11;
    private int y = 11;

    /**
     * The Label - variables contains images that will be moving
     */
    JLabel label;

    /**
     * Class constructor. Creates a rectangle panel
     */
    public RectanglePanel() {
        ImageIcon icon = new ImageIcon("src/main/resources/dragon.png");
        label = new JLabel();
        label.setBounds(x, y, IMAGE_SIZE, IMAGE_SIZE);
        label.setIcon(icon);

        this.setPreferredSize(new Dimension(RECTANGLE_SIZE, RECTANGLE_SIZE));
        this.add(label);
        this.setVisible(true);
        this.setLayout(null);
    }

    /**
     * Moving the image inside rectangle panel
     * @param direction the direction moving
     */
    public void move(String direction) {
        switch (direction) {
            case "Top":
                if (checkBorder(y, false)) {
                    y -= STEP;
                    label.setBounds(x, y, IMAGE_SIZE, IMAGE_SIZE);
                }
                break;
            case "Bottom":
                if (checkBorder(y, true)) {
                    y += STEP;
                    label.setBounds(x, y, IMAGE_SIZE, IMAGE_SIZE);
                }
                break;
            case "Left":
                if (checkBorder(x, false)) {
                    x -= STEP;
                    label.setBounds(x, y, IMAGE_SIZE, IMAGE_SIZE);
                }
                break;
            case "Right":
                if (checkBorder(x, true)) {
                    x += STEP;
                    label.setBounds(x, y, IMAGE_SIZE, IMAGE_SIZE);
                }
                break;
        }
        label.updateUI();
    }

    /**
     * Recolor rectangle border
     * @param newColor the new color of the rectangle border
     */
    public void recolor(String newColor) {
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
        g.drawRect(10, 10, 180, 180);
    }

    private boolean checkBorder(int coordinate, boolean positiveWay) {
        int newCoordinate = positiveWay
                ? coordinate + STEP
                : coordinate - STEP;

        return newCoordinate < MAX_BORDER && newCoordinate > MIN_BORDER;
    }
}
