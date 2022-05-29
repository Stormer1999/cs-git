package code;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> changes = new ArrayList<>();
    changes.add("hello.java");
    changes.add("hi.java");
    changes.add("welcome.java");

    Commit c1 = new Commit(0, changes, null, null);
    RepoComponent repo1 = new RepoComposite("master");
    repo1.addCommit(c1);
    repo1.printCommit();

    System.out.println("add new commit");
    changes.add("index.html.java");
    Commit c2 = new Commit(1, changes, null, null);
    repo1.addCommit(c2);
    repo1.printCommit();
  }
}
