package task18;

import javax.swing.*;
import java.awt.*;

/**
 * The class serves to painting the arc
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class DrawingArcPanel extends JPanel {
    private int coordX = 60;
    private int coordY = 20;
    private int widthValue = 100;
    private int heightValue = 100;
    private int startAngleValue = 360;
    private int arcAngleValue = 180;

    /**
     * Class constructor. Creates the arc panel
     */
    public DrawingArcPanel() {
        this.setPreferredSize(new Dimension(200, 200));
        this.setVisible(true);
        this.setLayout(null);
    }

    /**
     * Redraw the arc
     *
     * @param x          the x coordinate
     * @param y          the y coordinate
     * @param width      the width
     * @param height     the height
     * @param startAngle the start angle
     * @param arcAngle   the arc angle
     */
    public void redraw(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.coordX = x;
        this.coordY = y;
        this.widthValue = width;
        this.heightValue = height;
        this.startAngleValue = startAngle;
        this.arcAngleValue = arcAngle;
        this.paintComponent(this.getGraphics());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawArc(coordX, coordY, widthValue, heightValue, startAngleValue, arcAngleValue);
    }
}
