package code;

import java.util.HashMap;
import java.util.List;

public class RepoService {

  private final HashMap<String, RepoComponent> repository = new HashMap<>();

  public RepoService() {
    // create default branch (Master)
    String bName = "master";
    RepoComponent repo = new RepoComposite(bName);
    repository.put(bName, repo);
  }

  public void addNewCommit(String bName, List<String> changes) {
    System.out.println("\n*** add commit to branch " + bName + " ***");
    if (repository.get(bName) != null) {
      repository.get(bName).addCommit(new Commit(null, changes, null, null));
    } else {
      System.out.println("*** error not found branch: add failed ***");
    }
  }

  public void printAllHead() {
    System.out.println("### print all branch ###");
    repository.forEach((key, value) -> value.printCommit());
  }

  public void addNewBranch(String oldBranch, String newBranch) throws NullPointerException {
    System.out.println("\n*** add new branch " + newBranch + " ***");
    try {
      // find head in old branch
      Commit oldBranchHead = repository.get(oldBranch).getCommit();
      // copy old head commit to new branch for default reference this branch
      RepoComponent repo = new RepoComposite(newBranch);
      repo.addCommit(oldBranchHead);
      repository.put(newBranch, repo);
    } catch (NullPointerException ex) {
      System.out.println("*** error not found branch ***");
    }
  }

  public void pullHead(String bName) throws NullPointerException {
    try {
      String str = repository.get(bName).viewChanges();
      System.out.println("\nchanged files (head) in branch " + bName + " : " + str);
    } catch (NullPointerException ex) {
      System.out.println("*** error pull head failed, not found branch ***");
    }
  }
}
