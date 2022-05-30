package code;

public interface RepoComponent {

  String viewChanges();

  void printCommit();

  void addCommit(RepoComponent child);

  RepoComponent clonePrototype(String bName, RepoComponent oldCommit);

  Commit getCommit();

  String getBName();
}
