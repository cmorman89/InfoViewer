import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class InfoFrame extends JFrame{

    /**
     *  Construct Info Viewer Window
    */
    private final int WINDOW_WIDTH  = 600;
    private final int WINDOW_HEIGHT = 800;

    private JPanel          displayPanel;
        private JLabel          displayTitleLabel;
        private JLabel          displayNameLabel;
        private JLabel          displayMajorLabel;
        private JLabel          displayMaritalStatusLabel;

    private JPanel          inputPanel;
        private JPanel          nameInputPanel;
            private JLabel          nameInputLabel;
            private JTextField      nameInputTextField;
        private JPanel          majorInputPanel;
            private JComboBox       majorInputComboBox;
        private JPanel          maritalStatusInputPanel;
            private ButtonGroup     maritalStatusInputRadioGroup;
                private JRadioButton    singleMaritalInputRadio;
                private JRadioButton    marriedMaritalInputRadio;
                private JRadioButton    separatedMaritalInputRadio;




    public InfoFrame() {
        displayPanel = createDisplayPanel();
        inputPanel   = createInputPanel();
    }
    /**
     * Construct Display Panel
     * @return JPanel to display selected information
    */
    public JPanel createDisplayPanel() {

    }

    public JPanel createInputPanel() {

    }
}
