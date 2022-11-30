package task28;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * The class serves to painting the triangle
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class DrawingTrianglePanel extends JPanel {
    private int[] x = {0, 0, 0};
    private int[] y = {0, 0, 0};
    private int countPoint = 3;

    /**
     * Class constructor. Creates the polygon panel
     */
    public DrawingTrianglePanel() {
        this.setPreferredSize(new Dimension(150, 150));
        this.setVisible(true);
        this.setLayout(null);
    }

    /**
     * Redraw polygon
     *
     * @param x_arr the array of x coordinates
     * @param y_arr the array of y coordinates
     */
    public void redraw(int[] x_arr, int[] y_arr) {
        this.x = x_arr;
        this.y = y_arr;

        if (x_arr.length > y_arr.length) {
            x_arr = Arrays.copyOf(x_arr, y_arr.length);
        } else {
            y_arr = Arrays.copyOf(y_arr, x_arr.length);
        }

        this.countPoint = x_arr.length;
        this.paintComponent(this.getGraphics());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillPolygon(x, y, countPoint);
    }
}
