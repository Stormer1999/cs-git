package code;

import java.util.List;

public interface RepoComponent {

  String viewChanges();

  String getParent();

  String getChild();

  void printCommit();

  void addCommit(RepoComponent child);

  RepoComponent clonePrototype(String bName, RepoComponent oldCommit);

  List<RepoComponent> getCommits();
}
