package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepoComposite implements RepoComponent {

  public ArrayList<RepoComponent> commitList;

  String bName;

  public RepoComposite(String bName) {
    commitList = new ArrayList<>();
    this.bName = bName;
  }

  public List<String> viewChanges() {
    return Collections.emptyList();
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
