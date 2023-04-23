import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.*;
import java.util.Scanner;
public class test {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your github Username");
        String username = scanner.nextLine();
        System.out.println("Please enter your user token.");
        String token = scanner.nextLine();
        //initialize github API
        GitHubApiClient gitHubApiClient = new GitHubApiClient(username, token);


        //create new repo
        RequestParams requestParams = new RequestParams();
        System.out.println("Please enter the name of the repo you would like to create");
        String newrepoName = scanner.nextLine();
        System.out.println("Please enter the description for this new repo");
        String newrepoDescription = scanner.nextLine();
        System.out.println("Please provide if you want this repo private or not. Enter False for public, true for private");
        Boolean newrepoprivacy = scanner.nextBoolean();
        requestParams.addParam("name", newrepoName); // name of repo
        requestParams.addParam("description", newrepoDescription);
        //Caden- could you make a button to select if they want a private repo or not
        //so if clicked- its private, else its trues
        requestParams.addParam("private", newrepoprivacy); 
        
        CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);

         //To get repo info- Caden, you'll probably need to make a button for this.
         System.out.println("Please enter the name of the repo that you need information for");
         String repoName = scanner.nextLine();
         GetRepoInfoResponse repoInfo = gitHubApiClient.getRepoInfo(username, repoName);
         repoInfo.printJson();
         //to get the url of the repo made, if the repoName is the currently made repo
         String url = repoInfo.getUrl();


        //close scanner
        scanner.close();
    }
    
    
}
