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

  static boolean includes(String[] keywords, String text) {
    for (String keyword : keywords) {
      if (text.contains(keyword)) return true;
    }
    return false;
  }

  static String[] keywords = {
    "callback", "Called"
  };

  static void visitMembers(ExecutableMemberDoc[] mems) {
    for (int i = 0; i < mems.length; ++i) {
      ExecutableMemberDoc doc = mems[i];
      String comment = doc.commentText();
      if (includes(keywords, comment)) {
        System.out.println(doc.qualifiedName() + " " + doc.signature());
      }
    }
  }

}
