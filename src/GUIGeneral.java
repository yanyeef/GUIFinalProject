import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.util.Hashtable;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;

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
    private JTextArea ta1;
    private JTextArea ta2;
    private JTextArea ta3;
    private JTextArea ta4;
    private JTextArea ta5;
    private JTextArea ta6;
    private JTextArea ta7;
    private JTextArea ta8;
    private JTextArea ta9;
    private JTextArea ta10;
    private JButton resetButton;
    private JButton homeButton;
    private ArrayList<JTextArea> jTA;
    private ArrayList<JTextArea> date;
    private ArrayList<JCheckBox> box;
    private int i;

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
        JTextArea[] a = {textArea1, textArea2, textArea3,textArea4, textArea5, textArea6, textArea7, textArea8, textArea9,textArea10};
        jTA = new ArrayList<>(Arrays.asList(a));
        JTextArea[] d = {ta1, ta2, ta3,ta4, ta5, ta6, ta7, ta8, ta9,ta10};
        date = new ArrayList<>(Arrays.asList(d));
        JCheckBox[] c = {B1, B2, B3, B4, B5, B6, B7, B8, B9, B10};
        box = new ArrayList<>(Arrays.asList(c));
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);
        B9.addActionListener(this);
        B10.addActionListener(this);
        resetButton.addActionListener(this);
        homeButton.addActionListener(this);
        i=1;
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JCheckBox){
            JCheckBox check = (JCheckBox) source;
            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
            Font font = new Font(Font.SERIF, Font.PLAIN, 12);
            map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            font = font.deriveFont(map);
             if(B1.isSelected()) {
                textArea1.setFont(font);
             }
             if( B2.isSelected()){
                 textArea2.setFont(font);
             }
            if( B3.isSelected()){
                textArea3.setFont(font);
            }
            if( B4.isSelected()){
                textArea4.setFont(font);
            }
            if( B5.isSelected()){
                textArea5.setFont(font);
            }
            if( B6.isSelected()){
                textArea6.setFont(font);
            }
            if( B7.isSelected()){
                textArea7.setFont(font);
            }
            if( B8.isSelected()){
                textArea8.setFont(font);
            }
            if( B9.isSelected()){
                textArea9.setFont(font);
            }
            if( B10.isSelected()){
                textArea10.setFont(font);
            }
        }


        if(source instanceof JButton){
            JButton button = (JButton)source;
            String text = button.getText();
            JTextArea a = textArea1;
            JTextArea a2 = ta1;
            if(text.equals("Enter")) {
                String tA = "textArea" + i;
                String task = textField1.getText();
                String month = comboBox1.getSelectedItem().toString();
                String day = comboBox2.getSelectedItem().toString();
                String year = comboBox3.getSelectedItem().toString();
                a2 = date.get(i-1);
                a2.append(month + " " + day + ", " + year);
                a= jTA.get(i-1);
                a.append(task);
                i++;
            }
            if(text.equals("Reset")){
                for(int i = 0; i < jTA.size(); i++){
                    Font font = new Font(Font.SERIF, Font.PLAIN, 12);
                    jTA.get(i).setText("");
                    jTA.get(i).setFont(font);
                    date.get(i).setText("");
                    box.get(i).setSelected(false);
                }
                i=1;
            }
            if(text.equals("Home")){
                GUIMain m = new GUIMain();
                setVisible(false);
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
