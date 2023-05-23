import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
    private JCheckBox checkBox1;

    public GUIWindow(){
        textField1.setText("Enter task to do : (day, task)");
        textField2.setText("Enter task you've completed: (day, task)");
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Planner/To do List");
        setSize(900,600);

        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        enterTaskButton.addActionListener(this);
        enterCompletedButton.addActionListener(this);
        resetButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JButton){
            JButton button = (JButton)source;
            String text = button.getText();
            if(text.equals("enterTask")){
                String dateAndTask = textField1.getText();
                String day = dateAndTask.substring(0, dateAndTask.indexOf(", "));
                String task = dateAndTask.substring(dateAndTask.indexOf(", ") +1);
                if(day.equals("Monday")){
                    textArea1.append("\n " + task);
                } else if (day.equals("Tuesday")){
                    textArea2.append("\n " + task);
                }else if (day.equals("Wednesday")){
                    textArea3.append("\n " + task);
                }else if (day.equals("Thursday")){
                    textArea4.append("\n " + task);
                }else if (day.equals("Friday")){
                    textArea5.append("\n " + task);
                }
                textField1.setText("");
            }else if(text.equals("enterCompleted")){
                String dateAndTask = textField2.getText();
                String day = dateAndTask.substring(0, dateAndTask.indexOf(", ")).toLowerCase();
                String task = dateAndTask.substring(dateAndTask.indexOf(", ") +1);
                int len = task.length();
                if(day.equals("monday")){
                    String currentText = textArea1.getText();
                    String before = currentText.substring(0, currentText.indexOf(task));
                    String after = currentText.substring(currentText.indexOf(task)+len);
                    textArea1.setText(before + after);
                }else if(day.equals("tuesday")){
                    String currentText = textArea2.getText();
                    String before = currentText.substring(0, currentText.indexOf(task));
                    String after = currentText.substring(currentText.indexOf(task)+len);
                    textArea2.setText(before + after);
                }else if (day.equals("wednesday")){
                    String currentText = textArea3.getText();
                    String before = currentText.substring(0, currentText.indexOf(task));
                    String after = currentText.substring(currentText.indexOf(task)+len);
                    textArea3.setText(before + after);
                }else if(day.equals("thursday")){
                    String currentText = textArea4.getText();
                    String before = currentText.substring(0, currentText.indexOf(task));
                    String after = currentText.substring(currentText.indexOf(task)+len);
                    textArea4.setText(before + after);
                }else if(day.equals("friday")){
                    String currentText = textArea5.getText();
                    String before = currentText.substring(0, currentText.indexOf(task));
                    String after = currentText.substring(currentText.indexOf(task)+len);
                    textArea5.setText(before + after);
                }
                textField2.setText("");
            }else if(text.equals("Reset")){
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");
                textArea4.setText("");
                textArea5.setText("");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // KeyListener interface requires this method be added, even if unimplemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        myTextArea.append("key pressed! ");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // KeyListener interface requires this method be added, even if unimplemented
    }

}
