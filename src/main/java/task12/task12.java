package task12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* The class serves to execute task 12:
* creating simple top-level window for a Java application
* with possibility to move image inside window.
* @author Arina Kholodnytska
* @version 1.0
*/
public class task12 extends JFrame {
    /**
     * The constant jFrame - main window
     */
    public static JFrame jFrame;

    /**
     * The entry point of application
     * @param args the input arguments
     */
    public static void main(String[] args) {
        initJFrame();

        GridBagConstraints constraints = new GridBagConstraints();

        RectanglePanel movingRectangle = new RectanglePanel();
        addElementToJFrame(jFrame, movingRectangle, constraints, 1, 0);

        JPanel colorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelColor = new JLabel("Color");
        String[] colors = {"Black", "Red", "Green", "Blue"};
        SpinnerModel spinnerListColors = new SpinnerListModel(colors);
        JSpinner spinner = new JSpinner(spinnerListColors);

        colorPanel.add(labelColor);
        colorPanel.add(spinner);

        JRadioButton rbTop = new JRadioButton("Top");
        JRadioButton rbBottom = new JRadioButton("Bottom");
        JRadioButton rbRight = new JRadioButton("Right");
        JRadioButton rbLeft = new JRadioButton("Left");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbTop);
        buttonGroup.add(rbBottom);
        buttonGroup.add(rbRight);
        buttonGroup.add(rbLeft);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(4, 1));
        radioPanel.add(rbTop);
        radioPanel.add(rbBottom);
        radioPanel.add(rbRight);
        radioPanel.add(rbLeft);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direction = "";
                if (rbTop.isSelected()) direction = rbTop.getText();
                if (rbBottom.isSelected()) direction = rbBottom.getText();
                if (rbRight.isSelected()) direction = rbRight.getText();
                if (rbLeft.isSelected()) direction = rbLeft.getText();

                String color = spinner.getValue().toString();

                if (!direction.equals("")) movingRectangle.move(direction);
                if (color != null) movingRectangle.recolor(color);

                jFrame.repaint();
            }
        };

        JButton buttonMove = new JButton("Move");
        buttonMove.addActionListener(actionListener);

        addElementToJFrame(jFrame, colorPanel, constraints, 1, 2);

        constraints.insets = new Insets(10, 0, 10, 0);
        addElementToJFrame(jFrame, radioPanel, constraints, 1, 3);

        addElementToJFrame(jFrame, buttonMove, constraints, 1, 4);

        jFrame.setVisible(true);
    }

    /**
     * Init JFrame. It initializes main window with title that is initially invisible.
     */
    public static void initJFrame() {
        jFrame = new JFrame("Moving Image");
        jFrame.setLayout(new GridBagLayout());
        jFrame.setSize(500,500);
    }

    /**
     * Add element to jFrame
     *
     * @param frame       the frame
     * @param element     the element(component) for adding
     * @param constraints the constraints for element
     * @param gridX       the grid x
     * @param gridY       the grid y
     *
     * @return the boolean value about successful adding element
     */
    public static boolean addElementToJFrame(JFrame frame, Component element, GridBagConstraints constraints, int gridX, int gridY) {
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        try {
            frame.add(element, constraints);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
