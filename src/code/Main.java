package code;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> changes = new ArrayList<>();
    changes.add("hello.java");
    changes.add("hi.java");
    changes.add("welcome.java");

    //    RepoService service = new RepoService(new RepoComposite("master"));
    //    service.addCommit(changes);
    //    changes.add("home.js");
    //    service.addCommit(changes);
    //    service.printAll();
    //    changes.add("Discord.js");
    //    service.addCommit(changes);
    //    service.printAll();

    //    service.changeId(3);
    //    System.out.println("After re-id");
    //    service.printAll("master");

    //    service.extractBranch("dev");

    System.out.println("new zone");
    RepoComposite repoComposite = new RepoComposite("master");
//    repoComposite.commits.add(new RepoComposite(0, changes));
    repoComposite.add(new RepoComposite(0, changes));
    changes.add("DiscordX1.js");
//    repoComposite.commits.add(new RepoComposite(0, changes));
    repoComposite.add(new RepoComposite(0, changes));
    repoComposite.printAllCommit();

    //    repoComposite.clonePrototype("dev");

    //    RepoComposite repoComposite2 = new RepoComposite("dev");
    //    repoComposite2.commits.add(new RepoComposite(0, changes));
    //    repoComposite2.printAllCommit();
    
//    extractBranch("dev");
  }

  static void extractBranch(String bName) {
    RepoComposite repoComposite = new RepoComposite(bName);
    repoComposite.clonePrototype(bName);
    repoComposite.printAllCommit();
  }
}
