package code;

import java.util.List;

public class Commit implements RepoComponent {

  int commitId;

  List<String> changes;

  String parentId;

  String childId;

  public Commit() {}

  public Commit(int commitId, List<String> changes, String parentId, String childId) {
    this.commitId = commitId;
    this.changes = changes;
    this.parentId = parentId;
    this.childId = childId;
  }

  @Override
  public String viewChanges() {
    StringBuilder sb = new StringBuilder();
    for (String str : changes) {
      sb.append(str).append(", ");
    }
    sb.deleteCharAt(sb.length()-2);
    return sb.toString();
  }

  @Override
  public String getParent() {
    return null;
  }

  @Override
  public String getChild() {
    return null;
  }

  @Override
  public void printCommit() {
    System.out.println(
        "\tRepoComposite {"
            + " commitId="
            + commitId
            + ", changes="
            + changes
            + ", patentId='"
            + parentId
            + '\''
            + ", childId='"
            + childId
            + '\''
            + " }");
  }

  @Override
  public void addCommit(RepoComponent child) {}
}
