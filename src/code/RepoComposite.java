package code;

import java.util.ArrayList;
import java.util.List;

public class RepoComposite implements Prototype {

  int commitId;

  List<String> changes;

  String parentId;

  String childId;

  public Commit commits = new Commit();

  public ArrayList<RepoComposite> commitList;

  public RepoComposite(String bName) {
    commits = new Commit();
    commitList = new ArrayList<>();
  }

  public RepoComposite(int commitId, List<String> changes) {
    this.commitId = commitId;
    this.changes = changes;
    this.parentId = null;
    this.childId = null;
  }

  public List<String> viewChanges() {
    return this.changes;
  }

  public String getParent() {
    return null;
  }

  public String getChild() {
    return null;
  }

  @Override
  public String toString() {
    return "RepoComposite{"
        + "commitId="
        + commitId
        + ", changes="
        + changes
        + ", patentId='"
        + parentId
        + '\''
        + ", childId='"
        + childId
        + '\'';
  }

  void printAllCommit() {
    int count = 1;
    for (RepoComposite r : commits) {
      System.out.println("dept: " + count + " " + r.toString());
      count++;
    }
  } // print all data

  void reId(int num) {
    this.commitId = num;
    commits.reIdAll(num);
  }

  @Override
  public Prototype clonePrototype(String bName) {
    RepoComposite branchNew = new RepoComposite(bName);
    branchNew.commitId = commitId;
    branchNew.changes = changes;
    branchNew.parentId = parentId;
    branchNew.childId = childId;
    branchNew.commits = commits;
    return branchNew;
  }

  public void add(RepoComposite child) {
    commitList.add(child);
  }
}
