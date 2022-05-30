package code;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> changes = new ArrayList<>();
    changes.add("hello.java");
    changes.add("hi.java");
    changes.add("welcome.java");

    //    add commit1 in master
    System.out.println("\n### add new commit ###");
    RepoComponent repo1 = new RepoComposite("master");
    repo1.addCommit(new Commit(0, changes, null, null));
    repo1.printCommit();
    System.out.println("changes in head commit = " + repo1.viewChanges());

    // add commit2 in master
    System.out.println("\n### add new commit ###");
    List<String> changes2 = new ArrayList<>();
    changes2.add("hello.java");
    changes2.add("hi.java");
    repo1.addCommit(new Commit(1, changes2, null, null));
    repo1.printCommit();
    System.out.println("changes in head commit = " + repo1.viewChanges());

    // extract branch
    System.out.println("\n### extract branch ###");
    RepoComponent repo2 = repo1.clonePrototype("b_new",repo1);
    repo2.printCommit();

    // add commit 3 in new branch
    repo2.addCommit(new Commit(3, changes, null, null));

    // print all branch
    System.out.println("\n### all branch ###");
    repo1.printCommit();
    repo2.printCommit();
  }
}
