import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class start{
    public static void main(String[] args){
        System.out.println("Starting");
        JFrame frame = new JFrame("Basic Frame");
        frame.setSize(800,600);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);

        JButton button = new JButton("Example Button For Now");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.setBackground(Color.red);
            }
        });
        button.setSize(100,100);
        button.setLocation(300,350);
        panel.add(button);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}