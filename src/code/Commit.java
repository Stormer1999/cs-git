package code;

import java.util.ArrayList;
import java.util.List;

public class Commit extends ArrayList<RepoComposite> {
  public Commit() {}

  void updateCommit() {

    // change parent and child in old commit, add new commit in last
    for (RepoComposite repo : this) {
      // if commit not alone (commit != 1 node)
      if (repo.getParent() == null && repo.getChild() == null) {
        //        // if commit is tail
        //        if (repo.getParent() != null && repo.getChild() == null) {
        //          System.out.println("this commit is tail");
        //          newChain.add(repo);
        //        }
        //        // if commit is not tail or head
        //        else if (repo.getParent() != null && repo.getChild() != null) {
        //          System.out.println("this commit is in middle");
        //        }
        //        // if commit is head(last) then change newer head
        //        else if (repo.getParent() == null && repo.getChild() != null) {
        //          System.out.println("this commit is head");
        //        }
        repo.parentId = "";
      } // outer if
    } // foreach
  }

  void updateCommit(String bName) {
    List<RepoComposite> result = new ArrayList<>();
    // add to list
    for (RepoComposite repo : this) {
      result.add(repo);
    }
    // update parent-child to all commit
    for (int i = 0; i < result.size(); i++) {
      // if result.size() = 1
      // else (size > 1)
      // if i == result.size() - 2
      // if i == result.size() - 1

      // if commitId is null
      if (result.get(i).commitId == 0) {
        result.get(i).commitId = i;
      }
      // check head or tail or not
      if (i == 0) {
        result.get(i).parentId = String.valueOf((i + 1));
      } else if (i == result.size() - 1) {
        result.get(i).childId = String.valueOf((i - 1));
      } else {
        result.get(i).parentId = String.valueOf((i + 1));
        result.get(i).childId = String.valueOf((i - 1));
      }
      System.out.println("i = " + i);
    }
    System.out.println("end");
  }

  void reIdAll(int num) {
    int count = 1;
    for (RepoComposite r : this) {
      System.out.println("round count: " + count);
      r.reId(num);
      count++;
    }
  }
}
