package code;

public interface RepoComponent {

  String viewChanges();

  void printCommit();

  void addCommit(RepoComponent child);

  //  RepoComponent clonePrototype(String bName);

  Commit getCommit();

  String getBName();
}
