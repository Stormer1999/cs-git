package code;

public interface RepoComponent {

  String viewChanges();

  void printCommit();

  void addCommit(RepoComponent child);

  Commit getCommit();
}
