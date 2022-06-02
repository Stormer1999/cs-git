package code;

import java.util.ArrayList;
import java.util.List;

public class RepoComposite implements RepoComponent {

  private List<RepoComponent> commitList;

  private String bName;

  public RepoComposite() {}

  public RepoComposite(String bName) {
    this.commitList = new ArrayList<>();
    this.bName = bName;
  }

  public String viewChanges() {
    if (commitList.isEmpty()) {
      System.out.println("*** error cause commit is empty ***");
      return null;
    }
    List<RepoComponent> child = new ArrayList<>(commitList);
    return child.get(child.size() - 1).viewChanges();
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

  private void updateParentChild() {
    int index = 1;
    for (RepoComponent child : commitList) {

      Commit c = child.getCommit();
      c.setCommitId(index);
      if (index != 1 && index == commitList.size()) {
        // head -> last id have no child
        c.setParentId(String.valueOf((index - 1)));
      } else if (index != 1 && commitList.size() > 1) {
        c.setParentId(String.valueOf((index - 1)));
        c.setChildId(String.valueOf((index + 1)));

      } else if (index == 1 && index != commitList.size()) {
        // tail -> first id have no parent
        c.setChildId(String.valueOf((index + 1)));
      }
      index++;
    }
  }
}
