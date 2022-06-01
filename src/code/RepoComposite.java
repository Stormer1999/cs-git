package code;

import java.util.ArrayList;
import java.util.List;

public class RepoComposite implements RepoComponent {

  private List<RepoComponent> commitList;

  private String bName;

  public RepoComposite() {}

  public RepoComposite(String bName) {
    commitList = new ArrayList<>();
    this.bName = bName;
  }

  public String viewChanges() {
    if (commitList.isEmpty()) {
      System.out.println("*** error cause commit is empty ***");
      return null;
    }
    List<RepoComponent> child = new ArrayList<>(commitList);
    return child.get(child.size() - 1).viewChanges();
    // TODO: change return for Commit to access field data
  }

  @Override
  public void printCommit() {
    System.out.println("branch: *" + bName);
    if (commitList == null) {
      System.out.println("*** error printCommit cause commit is empty ***");
      return;
    }
    // print all child
    for (RepoComponent child : commitList) {
      child.printCommit();
    }
  }

  @Override
  public void addCommit(RepoComponent child) {
    commitList.add(child);
    // update relation Parent and Child
    updateParentChild();
  }

  @Override
  public Commit getCommit() {
    return commitList.get(commitList.size() - 1).getCommit();
  }

  @Override
  public String getBName() {
    return this.bName;
  }

  private void updateParentChild() {
    int index = 0;
    for (RepoComponent child : commitList) {
      Commit c = child.getCommit();
      c.setCommitId(index);
      c.setParentId("");
      c.setChildId("");
      index++;
    }
  }
}
