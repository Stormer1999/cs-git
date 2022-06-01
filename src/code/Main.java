package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

  static HashMap<String, RepoComponent> repository = new HashMap<>();

  public static void main(String[] args) {
    List<String> changes = new ArrayList<>();
    changes.add("hello.java");
    changes.add("hi.java");
    changes.add("welcome.java");

    List<String> changes2 = new ArrayList<>();
    changes2.add("hello.java");
    changes2.add("hi.java");

    //    // add commit1 in master
    //    System.out.println("\n### add new commit ###");
    //    RepoComponent repo1 = new RepoComposite("master");
    //    repo1.addCommit(new Commit(0, changes, null, null));
    //    repo1.printCommit();
    //    System.out.println("changes in head commit = " + repo1.viewChanges());
    //
    //    // add commit2 in master
    //    System.out.println("\n### add new commit ###");
    //    repo1.addCommit(new Commit(1, changes2, null, null));
    //    repo1.printCommit();
    //    System.out.println("changes in head commit = " + repo1.viewChanges());
    //
    //    // extract branch
    //    System.out.println("\n### extract branch ###");
    //    RepoComponent repo2 = repo1.clonePrototype("b_new");
    //    repo2.printCommit();
    //
    //    // add commit 3 in new branch
    //    System.out.println("\n### add commit to new branch ###");
    //    repo2.addCommit(new Commit(2, changes, null, null));
    //    repo2.printCommit();
    //
    //    // print all branch
    //    System.out.println("\n### all branch ###");
    //    repo1.printCommit();
    //    repo2.printCommit();
    //
    //    // view head commit
    //    System.out.println("\n### changed files in head commit ###");
    //    System.out.println(repo1.getBName() + ": " + repo1.viewChanges());
    //    System.out.println(repo2.getBName() + ": " + repo2.viewChanges());

    System.out.println("### manipulate ###");
    initial();
    System.out.println("\n*** add commit to master ***");
    addNewCommit("master", changes);
    printAllHead();
    System.out.println("\n*** add new branch ***");
    addNewBranch("master", "dev");
    printAllHead();
    System.out.println("\n*** add commit to new branch ***");
    addNewCommit("dev", changes2);
    printAllHead();
  }

  static void initial() {
    // default branch (Master)
    String bName = "master";
    RepoComponent repo = new RepoComposite(bName);
    repository.put(bName, repo);
  }

  static void addNewCommit(String bName, List<String> changes) {
    repository.get(bName).addCommit(new Commit(0, changes, null, null));
  }

  static void printAllHead() {
    repository.forEach((key, value) -> value.printCommit());
  }

  static void addNewBranch(String oldBranch, String newBranch) {
    //    RepoComponent rep = repository.get(oldBranch);
    //    rep.clonePrototype(newBranch);
    //    repository.put(newBranch, rep);

    // find head in old branch
    Commit head = repository.get(repository.get(oldBranch).getBName()).getCommit();
    //    int hId = head.getCommitId();
    //    String pId = head.getParentId();
    //    String cId = head.getChildId();
    //    System.out.println(head);
    repository.put(newBranch, new RepoComposite(newBranch));
    // get relation and add child to new branch
  }
}
// TODO: create service and use DI
