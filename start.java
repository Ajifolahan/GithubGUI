import java.awt.event.*;
import java.awt.image.ImageFilter;
import java.awt.*;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame2 = new JFrame("Frame 2");
        frame2.setSize(1000,800);
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame3 = new JFrame("Frame 3");
        frame3.setSize(1000,800);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame4 = new JFrame("Frame 4");
        frame4.setSize(1000,800);
        frame4.setResizable(false);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame 1 (After Start Screen) Information
        JPanel panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(Color.CYAN);

        JLabel title1 = new JLabel("USERNAME");
        title1.setLocation(420,300);
        title1.setSize(200,50);
        panel.add(title1);

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

        ImageIcon background1 = new ImageIcon("C:\\Users\\cheff\\Downloads\\School_Downloads\\CSC109\\Challenge2\\GithubGUI\\cyberspace.jpg");
        Image img1 = background1.getImage();
        Image temp1 = img1.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background1 = new ImageIcon(temp1);
        JLabel back1 = new JLabel(background1);
        back1.setLayout(null);
        back1.setBounds(0, 0, 1000, 800);
        panel.add(back1);

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

        JLabel frame3Header = new JLabel("Repo Information");
        frame3Header.setLocation(410,-30);
        frame3Header.setSize(350,350);
        panel3.add(frame3Header);

        JLabel nameLabel = new JLabel("Repo Name: ");
        nameLabel.setLocation(350,195);
        nameLabel.setSize(300,100);
        panel3.add(nameLabel);

        JLabel descripLabel = new JLabel("Repo Description: ");
        descripLabel.setLocation(320, 240);
        descripLabel.setSize(200,100);
        panel3.add(descripLabel);

        JTextField nameField = new JTextField("Enter Name");
        nameField.setLocation(430,220);
        nameField.setSize(300,50);
        panel3.add(nameField);

        JTextField descripField = new JTextField("Enter Description");
        descripField.setLocation(430,270);
        descripField.setSize(300,50);
        panel3.add(descripField);

        JLabel privacyLabel = new JLabel("To Continue please select the privacy of your repo:");
        privacyLabel.setSize(300,50);
        privacyLabel.setLocation(330,550);
        panel3.add(privacyLabel);

        JButton privateButton = new JButton("Private");
        privateButton.setSize(100,50);
        privateButton.setLocation(340,600);
        privateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Boolean privacy = true;
                String repoName = nameField.getText();
                String repoDescrip = descripField.getText();
                frame3.setVisible(false);
                frame4.setVisible(true);
            }
        });
        panel3.add(privateButton);

        JButton publicButton = new JButton("Public");
        publicButton.setSize(100,50);
        publicButton.setLocation(470,600);
        publicButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Boolean privacy = false;
                String repoName = nameField.getText();
                String repoDescrip = descripField.getText();
                frame3.setVisible(false);
                frame4.setVisible(true);
            }
        });
        panel3.add(publicButton);

        frame3.setContentPane(panel3);
        frame3.setVisible(false);

        //Frame 4
        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBackground(Color.LIGHT_GRAY);

        JLabel filePickMessage = new JLabel("Please Select Where you want the repo to end up on your computer.");
        filePickMessage.setLocation(350,350);
        filePickMessage.setSize(350,350);
        panel4.add(filePickMessage);

        JButton filePickButton = new JButton("Click me to Select the File");
        filePickButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        filePickButton.setSize(200,50);
        filePickButton.setLocation(350, 550);
        panel4.add(filePickButton);

        frame4.setContentPane(panel4);
        frame4.setVisible(false);
    }
    public static void chooseFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnvalue = jfc.showOpenDialog(null);
        if(returnvalue == JFileChooser.APPROVE_OPTION){
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }
    }
    public static void startScreen(JFrame nextFrame) {
        JFrame startScreen = new JFrame("Start Screen");
        startScreen.setSize(1000,800);
        startScreen.setResizable(false);
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel startPanel = new JPanel();
        startPanel.setLayout(null);
        startPanel.setBackground(Color.GRAY);

        JLabel welcomeMessage = new JLabel("Welcome to The GitHub Repo Creator!");
        welcomeMessage.setSize(300,200);
        welcomeMessage.setLocation(750, 300);
        startPanel.add(welcomeMessage);

        JButton nextButton = new JButton("Click here to advance!");
        nextButton.setSize(200,100);
        nextButton.setLocation(750, 430);
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startScreen.setVisible(false);
                nextFrame.setVisible(true);
            }
        });
        startPanel.add(nextButton);

        ImageIcon background = new ImageIcon("C:\\Users\\cheff\\Downloads\\School_Downloads\\CSC109\\Challenge2\\GithubGUI\\picture1.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(1000,700,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 1000, 700);
        startPanel.add(back);

        startScreen.setContentPane(startPanel);
        startScreen.setVisible(true);
    }
}