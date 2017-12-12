import java.util.Arrays ;
import java.util.List ;
public class Tree {
    String  node ;
    String cnt;
    List<Tree> children ;
    public Tree (String node, String cnt,  Tree ...  children)  {
        this.node = node;
        this.cnt = cnt;
        this.children = Arrays.asList(children) ;
    }
    public String uniq() {
        if (node == null) {
            return null;
        }
        return  cnt + node;
    }
    public Tree (String  node, String cnt)  {
        this.node = node ;
        this.cnt = cnt;
        children = Arrays.asList(new Tree[0]);
    }
    public String makeString() {
        if (node == null) {

        }
        String ret = node + " (";
        //System.err.println(node);
        if (children.size() == 0) {
            return ret + ")";
        }
        for (Tree aChildren : children) {
            if (aChildren.makeString() == null) {
                continue;
            }
            ret = ret.concat(aChildren.makeString() + " | ");
            //System.err.println(aChildren.makeString());
        }
        return ret + ")";
    }
}