package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<String> changes = new ArrayList<>();
    changes.add("hello.java");
    changes.add("hi.java");
    changes.add("welcome.java");

    List<String> changes2 = new ArrayList<>();
    changes2.add("hello.java");
    changes2.add("hi.java");

    System.out.println("### manipulate ###");
    RepoService service = new RepoService();

    // add commit to master
    service.addNewCommit("master", changes);
    service.printAllHead();
    // add new branch
    service.addNewBranch("master", "dev");
    service.printAllHead();
    // add commit to new branch
    service.addNewCommit("dev", changes2);
    service.printAllHead();
    // add commit to master
    service.addNewCommit("master", changes2);
    service.addNewCommit("master", changes2);
    service.printAllHead();
  }
}
