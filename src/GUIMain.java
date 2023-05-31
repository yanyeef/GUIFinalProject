import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUIMain extends JFrame implements ActionListener, KeyListener{
    private JButton generalListButton;
    private JPanel mainPanel;
    private JButton weeklyListButton;
    private JButton monthlyListButton;

    public GUIMain(){
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Planner/To do List");
        setSize(900,600);

        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        generalListButton.addActionListener(this);
        weeklyListButton.addActionListener(this);
        monthlyListButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JButton){
            JButton button = (JButton) source;
            String text = button.getText();
            if(text.equals("General List")){
                GUIGeneral g = new GUIGeneral();
                setVisible(false);
            }else if(text.equals("Weekly List")){
                GUIWindow m = new GUIWindow();
            }else if(text.equals("Monthly List")){

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
