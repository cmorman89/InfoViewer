/* Import GUI Containers */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
/* Import GUI Components */
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
/* Import GUI Borders */
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
/* Import GUI Layouts */
import java.awt.BorderLayout;
import java.awt.GridLayout;
/* Import GUI Event Listeners */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/* Info Frame */
public class InfoFrame extends JFrame{
    /* Window Dimensions */
    private final int WINDOW_WIDTH  = 400;
    private final int WINDOW_HEIGHT = 600;

    /* GUI Objects (Indented = Nested/Grouped/Contains) */
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
                
    /* Action Listeners */
    private ActionListener onChange;

    /* Construct Info Viewer Window */
    public InfoFrame() {
        /* Set Parameters */
            setTitle("User Information Viewer");
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* Action Listener */
            onChange = new InputListener();
        /* Info Frame Contents */
            add(displayPanel(), BorderLayout.CENTER);
            add(inputPanel(), BorderLayout.SOUTH);
        /* Make Visible */
            setVisible(true);
    }

    /* Action Listener: Update GUI Display on Change*/
    class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            displayNameLabel.setText(nameInputTextField.getText());
            displayMajorLabel.setText(majorInputComboBox.getSelectedItem().toString());
            displayMaritalStatusLabel.setText(maritalStatusInputRadioGroup.getSelection().toString());
        }
    }

    /* Create Display Panel
     * @return JPanel to display selected information */
    public JPanel displayPanel() {
        displayPanel = new JPanel(new GridLayout(4,1));
        /* Display Panel Contents */




        return displayPanel;
    }

    /* Create Input Panel
     * @return JPanel to hold input subpanels */
    public JPanel inputPanel() {
        inputPanel = new JPanel(new GridLayout(3,1));

        /* Input Panel Contents */
        inputPanel.add(nameInputPanel());
        inputPanel.add(majorInputPanel());
        inputPanel.add(maritalStatusInputPanel());

        return inputPanel;
    }

    /* Create Name Input Subpanel
     * @return JPanel to hold name input objects */
    public JPanel nameInputPanel() {
        nameInputPanel = new JPanel();
        nameInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Name"));
        /* Name Input Panel Contents */




        return nameInputPanel;
    }

    /* Create Major Input Subpanel
     * @return JPanel to hold major input objects */
    public JPanel majorInputPanel() {
        majorInputPanel = new JPanel();
        majorInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Major"));
        /* Major Input Panel Contents */



        return majorInputPanel;
    }

    /* Create Marital Status Input Subpanel
     * @return JPanel to hold marital status input objects */
    public JPanel maritalStatusInputPanel() {
        maritalStatusInputPanel = new JPanel(new GridLayout(1,3));
        maritalStatusInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Marital Status"));
        /* Marital Status Input Panel Contents */



        return maritalStatusInputPanel;
    }
}