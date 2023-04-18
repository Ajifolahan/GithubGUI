import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import java.util.Scanner;
public class test {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String username = "Ajifolahan";
        String token = APIFileIgnore.APIkey;
        GitHubApiClient gitHubApiClient = new GitHubApiClient(username, token);
        GetRepoInfoResponse repoInfo = gitHubApiClient.getRepoInfo(username, "GithubGUI");
        System.out.println(repoInfo.getJson());
    }
    
    
}
