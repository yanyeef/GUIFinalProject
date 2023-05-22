import javax.swing.*;
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

    public GUIWindow(){
        textField1.setText("Enter task to do");
        textField2.setText("Enter task you've completed");
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Planner");
        setSize(1000,600);

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
            }else if(text.equals("enterCompleted")){
                String dateAndTask = textField2.getText();
                String day = dateAndTask.substring(0, dateAndTask.indexOf(", "));
                String task = dateAndTask.substring(dateAndTask.indexOf(", ") +1);
                int len = task.length();
                if(day.equals("Monday")){
                    String currentText = textArea1.getText();
                    textArea1.setText(currentText.substring(0, currentText.indexOf(task)));
                    textArea1.append(currentText.substring(currentText.indexOf(task)+len));
                }
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
