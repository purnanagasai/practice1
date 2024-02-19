import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;

import java.io.File;

public class GitPushExample {

    public static void main(String[] args) {
        // Replace these with your actual local and remote repository paths
        String localRepositoryPath = "/path/to/your/local/repository";
        String remoteRepositoryURL = "https://github.com/username/repo.git";

        try {
            // Open the local Git repository
            try (Git git = Git.open(new File(localRepositoryPath))) {

                // Create a PushCommand
                PushCommand pushCommand = git.push();

                // Set the remote repository URL
                pushCommand.setRemote(remoteRepositoryURL);

                // Set credentials if needed (username and password)
                // pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("username", "password"));

                // Push changes to the remote repository
                pushCommand.call();

                System.out.println("Push successful!");
            }
        } catch (TransportException e) {
            // Handle any exceptions related to the transport (e.g., authentication issues)
            System.err.println("Error pushing to remote repository: " + e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }
}
