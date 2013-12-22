import com.sun.javadoc.*;

public class CallBack extends Doclet {

  public static boolean start(RootDoc root) {
    ClassDoc[] classes = root.classes();
    for (int i = 0; i < classes.length; ++i) {
      ClassDoc cd = classes[i];
      visitMembers(cd.constructors());
      visitMembers(cd.methods());
    }
    return true;
  }

  static void visitMembers(ExecutableMemberDoc[] mems) {
    for (int i = 0; i < mems.length; ++i) {
      ExecutableMemberDoc doc = mems[i];
      String comment = doc.commentText();
      if (comment.contains("callback")) {
        System.out.println(doc.qualifiedName() + " " + doc.signature());
      }
    }
  }

}
