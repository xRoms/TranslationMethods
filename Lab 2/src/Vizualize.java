import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Vizualize {
    private Graph graph;
    private List<Integer> levels = new ArrayList<Integer>();
    private int ls = 0;
    private int gap = 600;
    static int cnt = 0;

    private int load(Tree node, Tree parent, int depth) {
        graph.addNode(node.uniq());
        cnt++;
        Node smth = graph.getNode(node.uniq());
        smth.addAttribute("ui.label", node.node);
        if (parent != null) {
            graph.addEdge(node.uniq() + parent.uniq(), node.uniq(), parent.uniq());
        }
        int min = 0;
        if (levels.size() > depth) {
            min = Math.max(levels.get(depth) + 1, ls + 1);
        }
        else {
            levels.add(0);
            min = Math.max(0, ls + 1);
        }
        int max = min;
        for (Tree child: node.children) {
            if (child.node == null) {
                continue;
            }
            max = Math.max(load(child, node, depth + 1), max);
        }
        int x = (min + max) / 2;
        levels.set(depth, Math.max(x, levels.get(depth)));
        smth.setAttribute("xy", x * 3 * gap, depth * -gap + gap * 10 / (depth + 1));
        if (depth > 0) {
            levels.set(depth - 1, Math.max(levels.get(depth), levels.get(depth - 1)));
        }

        ls = Math.max(ls, x);
        return max;
    }

    Vizualize(Tree node) {
        graph = new SingleGraph("Tree");
        load(node, null, 0);
        graph.removeAttribute("ui.hide");
        graph.addAttribute("ui.stylesheet", "node {text-size: 15;}");

        Viewer view = graph.display();
        view.disableAutoLayout();
    }
}
