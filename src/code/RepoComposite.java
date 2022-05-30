package code;

import java.util.ArrayList;
import java.util.List;

public class RepoComposite implements RepoComponent {

  private List<RepoComponent> commitList;

  private String bName;

  public RepoComposite() {}

  public RepoComposite(String bName) {
    commitList = new ArrayList<>();
    this.bName = bName;
  }

  public String viewChanges() {
    if (commitList.isEmpty()) {
      System.out.println("*** error cause commit is empty ***");
      return null;
    }
    List<RepoComponent> child = new ArrayList<>(commitList);
    return child.get(child.size() - 1).viewChanges();
  }

  public String getParent() {
    return null;
  }

  public String getChild() {
    return null;
  }

  @Override
  public void printCommit() {
    System.out.println("branch: *" + bName);
    if (commitList == null) {
      System.out.println("*** error printCommit cause commit is empty ***");
      return;
    }
    for (RepoComponent child : commitList) {
      child.printCommit();
    }
  }

  @Override
  public void addCommit(RepoComponent child) {
    commitList.add(child);
    // TODO: pair relation when add newer commit (update parent & child)
  }

  @Override
  public RepoComponent clonePrototype(String bName, RepoComponent oldCommit) {
    //    List<RepoComponent> repoList = oldCommit.getCommits();
    //    RepoComposite repo = new RepoComposite();
    //    repo.bName = bName;
    //    repo.commitList = repoList;
    //    return repo;
    RepoComposite rp = new RepoComposite();
    rp.bName = bName;
    rp.commitList = commitList;
    return rp;
  } // clone all child (loop)

  @Override
  public List<RepoComponent> getCommits() {
    return this.commitList;
  }
}
