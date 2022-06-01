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
    // TODO: change return for Commit to access field data
  }

  @Override
  public void printCommit() {
    System.out.println("branch: *" + bName);
    if (commitList == null) {
      System.out.println("*** error printCommit cause commit is empty ***");
      return;
    }
    // print all child
    for (RepoComponent child : commitList) {
      child.printCommit();
    }
  }

  @Override
  public void addCommit(RepoComponent child) {
    commitList.add(child);
    // TODO: pair relation when add newer commit (update parent & child)
  }

  //  @Override
  //  public RepoComponent clonePrototype(String bName) {
  //    // TODO: if not found branch
  //    List<RepoComponent> list = new ArrayList<>();
  //    // clone all child
  //    for (RepoComponent child : commitList) {
  //      list.add(child.getCommit());
  //    }
  //    // create new object to store cloned-child and return them
  //    RepoComposite repo = new RepoComposite(bName);
  //    repo.commitList = list;
  //    return repo;
  //  }

  @Override
  public Commit getCommit() {
    return null;
  }

  @Override
  public String getBName() {
    return this.bName;
  }
}
