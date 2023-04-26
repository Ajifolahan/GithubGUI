import java.awt.Color;
import java.awt.event.*;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class start{
    public static void main(String[] args){
        System.out.println("Starting");

        //Frame creation for multiple screens
        JFrame frame = new JFrame("Basic Frame");
        frame.setSize(1000,800);
        frame.setResizable(false);

        JFrame frame2 = new JFrame("Frame 2");
        frame2.setSize(1000,800);
        frame2.setResizable(false);

        JFrame frame3 = new JFrame("Frame 3");
        frame3.setSize(1000,800);
        frame.setResizable(false);

        //Frame 1 (After Start Screen) Information
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);

        JTextField textField = new JTextField("Enter Your Username Here", 20);
        textField.setSize(200,50);
        textField.setLocation(350,350);
        panel.add(textField);

        JButton button = new JButton("Click here to advance!");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = textField.getText();
                System.out.println(username);
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });
        button.setSize(200,50);
        button.setLocation(350,550);
        panel.add(button);

        frame.setContentPane(panel);
        frame.setVisible(false);

        //Calls StartScreen
        startScreen(frame);


        //Frame 2 Information
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);

        JTextField textField2 = new JTextField("Enter your password token here");
        textField2.setSize(200,50);
        textField2.setLocation(350,350);
        panel2.add(textField2);

        JButton button2 = new JButton("Click here to advance!");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String token = textField2.getText();
                System.out.println(token);
                frame2.setVisible(false);
                frame3.setVisible(true);
            }
        });
        button2.setSize(200,50);
        button2.setLocation(350,550);
        panel2.add(button2);

        frame2.setContentPane(panel2);
        frame2.setVisible(false);

        
        //Frame 3 Information
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.LIGHT_GRAY);

        JLabel filePickMessage = new JLabel("Please Select Where you want the repo to end up on your computer.");
        filePickMessage.setLocation(350,350);
        filePickMessage.setSize(350,350);
        panel3.add(filePickMessage);

        JButton filePickButton = new JButton("Click me to Select the File");
        filePickButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        filePickButton.setSize(200,50);
        filePickButton.setLocation(350, 550);
        panel3.add(filePickButton);

        frame3.setContentPane(panel3);
        frame3.setVisible(false);
        
    }
    public static void chooseFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnvalue = jfc.showOpenDialog(null);
        if(returnvalue == JFileChooser.APPROVE_OPTION){
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }
    }
    public static void startScreen(JFrame nextFrame) {
        JFrame startScreen = new JFrame("Frame for start screen");
        startScreen.setSize(1000,800);
        startScreen.setResizable(false);

        JPanel startPanel = new JPanel();
        startPanel.setLayout(null);
        startPanel.setBackground(Color.YELLOW);

        JLabel welcomeMessage = new JLabel("Welcome to The GitHub Repo Creator!");
        welcomeMessage.setSize(300,200);
        welcomeMessage.setLocation(350, 300);
        startPanel.add(welcomeMessage);

        JButton nextButton = new JButton("Click here to advance!");
        nextButton.setSize(200,100);
        nextButton.setLocation(350, 500);
        nextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startScreen.setVisible(false);
                nextFrame.setVisible(true);
            }
        });
        startPanel.add(nextButton);

        startScreen.setContentPane(startPanel);
        startScreen.setVisible(true);
    }
}