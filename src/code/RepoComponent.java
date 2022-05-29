package code;

public interface RepoComponent {

  String viewChanges();

  String getParent();

  String getChild();

  void printCommit();

  void addCommit(RepoComponent child);

}
