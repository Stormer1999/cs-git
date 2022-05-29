package code;

import java.util.List;

public interface RepoComponent {

  List<String> viewChanges();

  String getParent();

  String getChild();

  void printCommit();

  void addCommit(RepoComponent child);
}
