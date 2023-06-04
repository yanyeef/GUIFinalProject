import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.JOptionPane;

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
    private JButton completedButton;
    private JTextField textField3;
    private JCheckBox checkBox1;
    private String mon;
    private String tues;
    private String wed;
    private String thurs;
    private String fri;
    private String sat;
    private String sun;

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
        completedButton.addActionListener(this);
        setVisible(true);
        mon = "Monday\n";
        tues = "Tuesday\n";
        wed = "Wednesday\n";
        thurs=  "Thursday\n";
        fri= "Friday\n";
        sat = "Saturday\n";
        sun = "Sunday\n";
    }

    public String mondayC(){
        return mon;
    }

    public String tuesdayC(){
        return tues;
    }
    public String wednesdayC(){
        return wed;
    }
    public String thursdayC(){
        return thurs;
    }
    private String fridayC(){
        return fri;
    }
    private String saturdayC(){
        return sat;
    }
    private String sundayC(){
        return sun;
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
                String d = textField2.getText().toLowerCase();
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
                }
                if(dateAndTask.contains(", ")){
                    Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
                    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
                    map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                    font = font.deriveFont(map);
                    String day = dateAndTask.substring(0, dateAndTask.indexOf(", ")).toLowerCase();
                    if (day.equals("monday")) {
                        t = textArea1;
                        mon += "- "+ task + "\n ";
                    } else if (day.equals("tuesday")) {
                        t = textArea2;
                        tues += "- "+ task + "\n";
                    } else if (day.equals("wednesday")) {
                        t = textArea3;
                        wed += "- "+ task + "\n";
                    } else if (day.equals("thursday")) {
                        t = textArea4;
                        thurs +="- "+ task + "\n";
                    } else if (day.equals("friday")) {
                        t = textArea5;
                        fri += "- "+task + "\n";
                    } else if (day.equals("saturday")) {
                        t = textArea6;
                        sat += "- "+task + "\n";
                    }else if (day.equals("sunday")) {
                        t = textArea7;
                        sun += "- "+task + "\n";
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
                textArea6.setText("");
                textArea7.setText("");
                textArea1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                textArea2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                textArea3.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                textArea4.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                textArea5.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                textArea6.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
                textArea7.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            } else if (text.equals("Home")){
                GUIMain m = new GUIMain();
                setVisible(false);
            } else if (text.equals("TasksCompleted")){
                JFrame j = new JFrame();
                j.getContentPane();
                String d = textField3.getText();
                if(d.equals("Monday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), mondayC());
                }else if (d.equals("Tuesday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), tuesdayC());
                }else if (d.equals("Wednesday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), wednesdayC());
                }else if (d.equals("Thursday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), thursdayC());
                }else if (d.equals("Friday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), fridayC());
                }else if (d.equals("Saturday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), saturdayC());
                }else if (d.equals("Sunday")){
                    JOptionPane.showMessageDialog(j.getComponent(0), sundayC());
                }

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
