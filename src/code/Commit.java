package code;

import java.util.List;

public class Commit implements RepoComponent {

  private int commitId;

  private List<String> changes;

  private String parentId;

  private String childId;

  public Commit() {}

  public Commit(int commitId, List<String> changes, String parentId, String childId) {
    this.commitId = commitId;
    this.changes = changes;
    this.parentId = parentId;
    this.childId = childId;
  }

  @Override
  public String viewChanges() {
    if (changes.isEmpty()) {
      System.out.println("*** error changes is empty ***");
      return null;
    }
    StringBuilder sb = new StringBuilder();
    // loop all changed files
    for (String str : changes) {
      sb.append(str).append(", ");
    }
    // delete last comma and space
    sb.deleteCharAt(sb.length() - 2);
    return sb.toString();
  }

  @Override
  public void printCommit() {
    System.out.println(
        "\t"
            + " commitId="
            + commitId
            + ", changes="
            + changes
            + ", patentId='"
            + parentId
            + '\''
            + ", childId='"
            + childId
            + '\'');
  }

  @Override
  public void addCommit(RepoComponent child) {}

  //  @Override
  //  public RepoComponent clonePrototype(String bName) {
  //    Commit commit = new Commit();
  //    commit.commitId = commitId;
  //    commit.changes = changes;
  //    commit.parentId = parentId;
  //    commit.childId = childId;
  //    return commit;
  //  }

  @Override
  public Commit getCommit() {
    return this;
  }

  @Override
  public String getBName() {
    return null;
  }

  public int getCommitId() {
    return commitId;
  }

  public String getParentId() {
    return parentId;
  }

  public String getChildId() {
    return childId;
  }
}
