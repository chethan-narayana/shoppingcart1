package com.git.sample;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

public class Sample {
    public static void main(String[] args) throws GitAPIException {
        String repoUrl = "https://github.com/chethan-narayana/shoppingcart1.git";

        CloneCommand cloneCommand = Git.cloneRepository();
        cloneCommand.setURI(repoUrl);
        cloneCommand.setDirectory(new File("C:/sample-git"));
        cloneCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("chethan.narayana10", "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"));
        cloneCommand.call();
    }

}
