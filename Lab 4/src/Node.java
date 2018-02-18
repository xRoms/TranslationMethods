import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
    public String name;
    public List<List<Node>> out;
    public Set<String> first, follow;
    public boolean visited;
    public boolean isString;

    Node(String name) {
        this.name = name;
        this.out = new ArrayList<List<Node>>();
        isString = false;
        visited = false;
        first = new HashSet<>();
        follow = new HashSet<>();
    }
}
