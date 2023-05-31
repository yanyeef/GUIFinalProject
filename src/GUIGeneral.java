import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.util.Hashtable;
import java.awt.font.TextAttribute;

public class GUIGeneral extends JFrame implements ActionListener, KeyListener{
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JCheckBox B1;
    private JCheckBox B2;
    private JCheckBox B3;
    private JCheckBox B4;
    private JCheckBox B5;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton enterButton;
    private JTextArea textArea6;
    private JCheckBox B6;
    private JLabel mLabel;
    private JLabel dLabel;
    private JLabel yLabel;
    private JTextArea textArea7;
    private JCheckBox B7;
    private JCheckBox B8;
    private JTextArea textArea8;
    private JCheckBox B9;
    private JTextArea textArea9;
    private JCheckBox B10;
    private JTextArea textArea10;
    private JTextPane textPane1;

    public GUIGeneral(){
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Planner/To do List");
        setSize(700,500);
        textField1.setText("Add tasks here");
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        enterButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        int i = 2;
        Object source = e.getSource();
        if(source instanceof JCheckBox){
            JCheckBox check = (JCheckBox) source;
            if(check.equals("B1")) {
                Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
                Font font = new Font(Font.SERIF, Font.PLAIN, 24);
                /* Strikethrouh is easy */
                map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                font = font.deriveFont(map);
                textArea1.setFont(font);
            }
        }
        if(source instanceof JButton){
            JButton button = (JButton)source;
            String text = button.getText();
            if(text.equals("Enter")) {
                String task = textField1.getText();
                String month = comboBox1.getSelectedItem().toString();
                String tA = "textArea" + i;
                JTextArea a = (JTextArea) (JPanel)tA;
                a.append(task);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // KeyListener interface requires this method be added, even if unimplemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // KeyListener interface requires this method be added, even if unimplemented
    }
}
