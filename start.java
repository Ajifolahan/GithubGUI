import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.CreateRepoResponse;
import github.tools.responseObjects.GetRepoInfoResponse;

public class start{

    static Boolean privacy;

    public static void main(String[] args){
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

        JLabel pathLabel = new JLabel("Please enter the directory path of your project");
        pathLabel.setLocation(320,150);
        pathLabel.setSize(500,50);
        pathLabel.setForeground(Color.ORANGE);
        panel.add(pathLabel);

        JTextField pathtextField = new JTextField();
        pathtextField.setSize(200,50);
        pathtextField.setLocation(350,200);
        panel.add(pathtextField);

        JLabel title1 = new JLabel("USERNAME");
        title1.setLocation(420,300);
        title1.setForeground(Color.ORANGE);
        title1.setSize(200,50);
        panel.add(title1);

        JTextField textField = new JTextField();
        textField.setSize(200,50);
        textField.setLocation(350,350);
        panel.add(textField);

        JButton button = new JButton("Click here to advance!");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });
        button.setSize(200,50);
        button.setLocation(350,550);
        panel.add(button);

        ImageIcon background1 = new ImageIcon("cyberspace.jpg");
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

        JLabel title2 = new JLabel("TOKEN");
        title2.setLocation(420,300);
        title2.setForeground(Color.ORANGE);
        title2.setSize(200,50);
        panel2.add(title2);

        JTextField textField2 = new JTextField();
        textField2.setSize(200,50);
        textField2.setLocation(350,350);
        panel2.add(textField2);

        JButton button2 = new JButton("Click here to advance!");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame2.setVisible(false);
                frame3.setVisible(true);
            }
        });
        button2.setSize(200,50);
        button2.setLocation(350,550);
        panel2.add(button2);

        ImageIcon background2 = new ImageIcon("cyberLock.jpg");
        Image img2 = background2.getImage();
        Image temp2 = img2.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background2 = new ImageIcon(temp2);
        JLabel back2 = new JLabel(background2);
        back2.setLayout(null);
        back2.setBounds(0, 0, 1000, 800);
        panel2.add(back2);

        frame2.setContentPane(panel2);
        frame2.setVisible(false);

        
        //Frame 3 Information
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.LIGHT_GRAY);

        JLabel frame3Header = new JLabel("Repo Information");
        frame3Header.setLocation(500,0);
        frame3Header.setSize(350,350);
        panel3.add(frame3Header);

        JLabel nameLabel = new JLabel("Repo Name: ");
        nameLabel.setLocation(400,225);
        nameLabel.setSize(300,100);
        panel3.add(nameLabel);
        

        JLabel descripLabel = new JLabel("Repo Description: ");
        descripLabel.setLocation(370, 270);
        descripLabel.setSize(200,100);
        panel3.add(descripLabel);

        JTextField nameField = new JTextField();
        nameField.setLocation(480,250);
        nameField.setSize(300,50);
        panel3.add(nameField);

        JTextField descripField = new JTextField();
        descripField.setLocation(480,300);
        descripField.setSize(300,50);
        panel3.add(descripField);

        JLabel privacyLabel = new JLabel("To Continue please select the privacy of your repo:");
        privacyLabel.setSize(300,50);
        privacyLabel.setLocation(410,550);
        panel3.add(privacyLabel);

        JButton privateButton = new JButton("Private");
        privateButton.setSize(100,50);
        privateButton.setLocation(420,600);
        privateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = true;
            }
        });
        panel3.add(privateButton);

        JButton publicButton = new JButton("Public");
        publicButton.setSize(100,50);
        publicButton.setLocation(550,600);
        publicButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = false;
            }
        });
        panel3.add(publicButton);

        JButton createRepoButton = new JButton("Click to create Repo");
        createRepoButton.setSize(250,50);
        createRepoButton.setLocation(400,680);
        panel3.add(createRepoButton);


        ImageIcon background3 = new ImageIcon("codeWheel.jpg");
        Image img3 = background3.getImage();
        Image temp3 = img3.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background3 = new ImageIcon(temp3);
        JLabel back3 = new JLabel(background3);
        back3.setLayout(null);
        back3.setBounds(0, 0, 1000, 800);
        panel3.add(back3);

        frame3.setContentPane(panel3);
        frame3.setVisible(false);

        //Frame 4
        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBackground(Color.LIGHT_GRAY);

        JLabel update = new JLabel("Repo is being created!");
        update.setForeground(Color.WHITE);
        update.setLocation(300,100);
        update.setSize(400,350);
        panel4.add(update);

        JLabel link = new JLabel("");
        link.setForeground(Color.ORANGE);
        link.setLocation(600,100);
        link.setSize(400,350);
        panel4.add(link);

        JLabel error = new JLabel("");
        error.setForeground(Color.ORANGE);
        error.setLocation(400,300);
        error.setSize(400,350);
        panel4.add(error);


        ImageIcon background4 = new ImageIcon("cyberglobe.jpg");
        Image img4 = background4.getImage();
        Image temp4 = img4.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background4 = new ImageIcon(temp4);
        JLabel back4 = new JLabel(background4);
        back4.setLayout(null);
        back4.setBounds(0, 0, 1000, 800);
        panel4.add(back4);

        frame4.setContentPane(panel4);
        frame4.setVisible(false);


        createRepoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(false);
                frame4.setVisible(true);
                GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(pathtextField.getText().replaceAll("\"", ""));
			try{
				String gitInit = gitSubprocessClient.gitInit();
			} catch (RuntimeException runtimeException){
				error.setText("Failed to Make the local git Repo");
			}

            // .gitignore file creation
			File gitIgnore = new File(pathtextField.getText().replaceAll("\"", ""),".gitignore");
			PrintWriter gitIgnorePW = null;
			try{
				gitIgnore.createNewFile();
				gitIgnorePW = new PrintWriter(gitIgnore);

				gitIgnorePW.println(".project");
				gitIgnorePW.println(".classpath");
				gitIgnorePW.println("*.class");
				gitIgnorePW.println("bin/");
				gitIgnorePW.println(".settings/");
				gitIgnorePW.println(".idea/");
				gitIgnorePW.println("*.iml");
				gitIgnorePW.println(".DS_Store");
				gitIgnorePW.println("out/");
				gitIgnorePW.flush();

			} catch(IOException e1){
				error.setText("Failed to Make the gitIgnore File");
            } finally {
				gitIgnorePW.close();
			}

           // README.md file creation
			File readme = new File(pathtextField.getText().replaceAll("\"", ""),"README.md");
			PrintWriter readmePW = null;
			String projectName = nameField.getText();
			try{
				readme.createNewFile();
				readmePW = new PrintWriter(readme);

				readmePW.println("## " + projectName);
				readmePW.flush();

			} catch(IOException e1){
				error.setText("Failed to Make the ReadMe File");
			} finally {
				readmePW.close();
			}

			//initial commit
			String addAll = gitSubprocessClient.gitAddAll();
			String commitMessage = "initial commit";
			String commit = gitSubprocessClient.gitCommit(commitMessage);


			GitHubApiClient gitHubApiClient = new GitHubApiClient(textField.getText(),textField2.getText());
			RequestParams createRepoRequestParams = new RequestParams();
			createRepoRequestParams.addParam("name",nameField.getText());
			if(!descripField.getText().equals("")){
				createRepoRequestParams.addParam("description",descripField.getText());
                createRepoRequestParams.addParam("private",privacy);
			} else {
                error.setText("Error in creating Github repo. Description not entered");
            }
			CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(createRepoRequestParams);

			//git repo remote set to GitHub repo
			GetRepoInfoResponse repoInfo = gitHubApiClient.getRepoInfo(textField.getText(),nameField.getText());
			String url = repoInfo.getUrl();
			String gitRemoteAdd = gitSubprocessClient.gitRemoteAdd("origin",url + ".git");

			//initial commit pushed to GitHub
			String push = gitSubprocessClient.gitPush("master");
            update.setText("Link to your new github repo");
            link.setText(url);
			link.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try{
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException | URISyntaxException e1){
						e1.printStackTrace();
					}
				}
			});

            }
        });

    }//end main

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

        JLabel disclaimer = new JLabel("This application is a prototype and is not yet meant for commercial use");
        disclaimer.setSize(700,200);
        disclaimer.setLocation(500, 650);
        startPanel.add(disclaimer);

        ImageIcon logo1 = new ImageIcon("quinnipiac.jpg");
        Image imglogo = logo1.getImage();
        Image templogo = imglogo.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        logo1 = new ImageIcon(templogo);
        JLabel logoLabel = new JLabel(logo1);
        logoLabel.setLayout(null);
        logoLabel.setBounds(10, 10, 100, 100);
        startPanel.add(logoLabel);

        ImageIcon logo2 = new ImageIcon("Microsoft-logo.jpg");
        Image imglogo2 = logo2.getImage();
        Image templogo2 = imglogo2.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        logo2 = new ImageIcon(templogo2);
        JLabel logoLabel2 = new JLabel(logo2);
        logoLabel2.setLayout(null);
        logoLabel2.setBounds(120, 10, 100, 100);
        startPanel.add(logoLabel2);

        ImageIcon background = new ImageIcon("picture1.png");
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