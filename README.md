# GithubGUI
## Application Summary
This program represents a GUI prototype for github. It let users run Git commands from a Java GUI, rather than running this commands from terminal. 
This GUI automates the process of converting a local project to a full blown Github Repo. When using this program, a gitIgnore file with some common file names
gets created, an initial commit is made, and a README.md file is created all in one click. The user also has the option to make this repository public or private. At the end ofthis process, the user is provided with the new link to their GitHub repository. This project was built with two jar files: GitSubprocessClient and 
GitHubApiClient.

As this is a prototype application, error handling is implemented only in some areas.

## How to use Application As a User
To run this project, you will need minimum Java 1.8 version. Simply clone this project to your computer and run it. In order to enter a token into the application, please ensure that you have a GitHub account and generate an access token.

## Developer Instructions
To run this project, you will need minimum Java 1.8 version. Simply clone this project to your computer and run it. The jar files used to communicate with github are the 
GitSubprocessClient(v0.0.12) and can be found https://github.com/CSC109/GitSubprocessClient and the GitHubApiClient(v0.0.7) which an be found https://github.com/CSC109/GitHubApiClient. 
Both jar files must be downloaded and the libraries must be added as dependencies in your project in order to use this application.
