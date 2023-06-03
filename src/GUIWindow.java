import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Hashtable;

public class GUIWindow extends JFrame implements ActionListener, KeyListener {
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JPanel mainPanel;
    private JButton enterTaskButton;
    private JButton enterCompletedButton;
    private JButton resetButton;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JButton homeButton;
    private JCheckBox checkBox1;

    public GUIWindow(){
        textField1.setText("Enter task to do : (day, task)");
        textField2.setText("Enter task you've completed: (day, task)");
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Planner/To do List");
        setSize(1150,600);

        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        enterTaskButton.addActionListener(this);
        enterCompletedButton.addActionListener(this);
        resetButton.addActionListener(this);
        homeButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JButton){
            JButton button = (JButton)source;
            String text = button.getText();
            if(text.equals("enterTask")){
                String dateAndTask = textField1.getText();
                String day = dateAndTask.substring(0, dateAndTask.indexOf(", ")).toLowerCase();
                String task = dateAndTask.substring(dateAndTask.indexOf(", ") +1);
                if(day.equals("monday")){
                   textArea1.append("\n " + task);
                } else if (day.equals("tuesday")){
                    textArea2.append("\n " + task);
                }else if (day.equals("wednesday")){
                    textArea3.append("\n " + task);
                }else if (day.equals("thursday")){
                    textArea4.append("\n " + task);
                }else if (day.equals("friday")){
                    textArea5.append("\n " + task);
                }
                textField1.setText("");
            }else if(text.equals("enterCompleted")){
                String dateAndTask = textField2.getText();
                String d = textField2.getText();
                String task = dateAndTask.substring(dateAndTask.indexOf(", ") +1);
                int len = task.length();
                JTextArea t = textArea1;
                if(!dateAndTask.contains(", ")){
                    Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
                    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
                    map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                    font = font.deriveFont(map);
                    if(d.equals("monday")){
                        textArea1.setFont(font);
                    }else if(d.equals("tuesday")){
                        textArea2.setFont(font);
                    }else if (d.equals("wednesday")){
                        textArea3.setFont(font);
                    }else if(d.equals("thursday")){
                        textArea4.setFont(font);
                    }else if(d.equals("friday")){
                        textArea5.setFont(font);
                    }
                }else {
                    Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
                    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
                    map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                    font = font.deriveFont(map);
                    String day = dateAndTask.substring(0, dateAndTask.indexOf(", ")).toLowerCase();
                    if (day.equals("monday")) {
                        t = textArea1;
                    } else if (day.equals("tuesday")) {
                        t = textArea2;
                    } else if (day.equals("wednesday")) {
                        t = textArea3;
                    } else if (day.equals("thursday")) {
                        t = textArea4;
                    } else if (day.equals("friday")) {
                        t = textArea5;
                    }
                    String currentText = t.getText();
                    String before = currentText.substring(0, currentText.indexOf(task));
                    String after = currentText.substring(currentText.indexOf(task) + len);
                    t.setText("");
                    t.append(before);
                    t.append(after);
                    textField2.setText("");
                }
            }else if(text.equals("Reset")){
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
                textArea5.setText("");
            } else if (text.equals("Home")){
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
