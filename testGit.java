import java.util.Scanner;

import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.CreateRepoResponse;
import github.tools.responseObjects.GetRepoInfoResponse;

public class testGit
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your github Username");
        String username = scanner.nextLine();
        System.out.println("Please enter your user token.");
        String token = scanner.nextLine();
        //initialize github API
        GitHubApiClient gitHubApiClient = new GitHubApiClient(username, token);


        //I was using the code below to test if it worked

        // //create new repo
        // RequestParams requestParams = new RequestParams();
        // System.out.println("Please enter the name of the repo you would like to create");
        // String newrepoName = scanner.nextLine();
        // System.out.println("Please enter the description for this new repo");
        // String newrepoDescription = scanner.nextLine();
        // System.out.println("Please provide if you want this repo private or not. Enter False for public, true for private");
        // Boolean newrepoprivacy = scanner.nextBoolean();
        // requestParams.addParam("name", newrepoName); // name of repo
        // requestParams.addParam("description", newrepoDescription);
        // //Caden- could you make a button to select if they want a private repo or not
        // //so if clicked- its private, else its trues
        // requestParams.addParam("private", newrepoprivacy); 
        
        // CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);

         //To get repo info- Caden, you'll probably need to make a button for this.
         System.out.println("Please enter the name of the repo that you need information for");
         String repoName = scanner.nextLine();
         GetRepoInfoResponse repoInfo = gitHubApiClient.getRepoInfo(username, repoName);
         repoInfo.printJson();
         //to get the url of the repo made, if the repoName is the currently made repo
         String url = repoInfo.getUrl();


    

        //This code asks user for the repo path and stores it
        System.out.println("Please enter the path where you want to create the repo: ");
        String repoPath = scanner.nextLine();

        //This code below gets the current folder they are in, we could possibly use it I couldn't figure out how
        //String currentFolder = System.getProperty("user.dir");


        //This creates the repo locally
        GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
        String gitInit = gitSubprocessClient.gitInit();
        //This adds origin to gitHub
        String remoteAddOrigin = gitSubprocessClient.gitRemoteAdd("origin", url);



        //Asking user if they want to create a branch
        String branchName = "master";
        System.out.println("Would you like to create a branch and switch to it? (Yes)(No)");
        String branch = scanner.nextLine();

        if(branch.equalsIgnoreCase("yes"))
        {
            System.out.println("Please enter branch name:");
            branchName = scanner.nextLine();
            String createBranch = gitSubprocessClient.createAndSwitchBranch(branchName);
        }



        //The following code adds ALL of the files changed within the folder
        boolean addFile = false;
        System.out.println("Would you like to add files to be committed? (yes)(no)");
        String check = scanner.nextLine();
        if (check.equalsIgnoreCase("yes")) 
        {
            String gitAddAll = gitSubprocessClient.gitAddAll();
            addFile = true;
        }
        else if (check.equalsIgnoreCase("no")) 
        {
            addFile = false;
        }
        

        //The following code commits the staged changes
        boolean commitFile = false;
        if(addFile)
        {
            System.out.println("Do you want to commit? True for yes False for no");
            commitFile = scanner.nextBoolean();
        }
        if(commitFile)
        {
            System.out.println("Please enter your commit message");
            String commitMessage = scanner.nextLine();
            String commit = gitSubprocessClient.gitCommit(commitMessage);
        }


        //Thise code asks if you want to see the status
        System.out.println("Would you like to see the status? (yes)(no)");
        String statusMessage = scanner.nextLine();
        if (statusMessage.equalsIgnoreCase("yes"))
        {
            System.out.println(gitSubprocessClient.gitStatus());
        }


        //This code pushes the code to the branch you are on
        System.out.println("Would you like to push your branch? (yes)(no)");
        String pushStatus = scanner.nextLine();
        if(pushStatus.equalsIgnoreCase("yes"))
        {
            String push = gitSubprocessClient.gitPush(branchName);
        }


        //This code pulls from master
        System.out.println("Would to like to pull from master? (yes)(no)");
        String pullStatus = scanner.nextLine();
        if(pullStatus.equalsIgnoreCase("yes"))
        {
            String pull = gitSubprocessClient.gitPull("master");
        }


        //The if statements are only here for testing purposes
        //We only need the Strings inside of them and everything with Git in it
        //I didn't use all of the git commands yet only most of the basic ones
        //I can easily add them if we need them



        //close scanner
        scanner.close();
    }
}