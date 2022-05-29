package code;

import java.util.ArrayList;
import java.util.List;

public class RepoComposite implements RepoComponent {

  public ArrayList<RepoComponent> commitList;

  String bName;

  public RepoComposite(String bName) {
    commitList = new ArrayList<>();
    this.bName = bName;
  }

  public String viewChanges() {
    if (commitList.isEmpty()) {
      System.out.println("error cause commit is empty");
      return null;
    }
    List<RepoComponent> child = new ArrayList<>(commitList);
    return child.get(child.size() - 1).viewChanges();
  }

  public String getParent() {
    return null;
  }

  public String getChild() {
    return null;
  }

  @Override
  public void printCommit() {
    System.out.println("branch: " + bName);
    for (RepoComponent child : commitList) {
      child.printCommit();
    }
  }

  @Override
  public void addCommit(RepoComponent child) {
    commitList.add(child);
  }
}
