package alphabeta;

import java.util.ArrayList;

public class Node {

    Node parent;
    ArrayList<Node> children;
    int val;
    int alpha;
    int beta;
    boolean end;

    public Node(Node parent, ArrayList<Node> children, int alpha, int beta, boolean end, int val) {
        this.parent = parent;
        this.children = children;
        this.val = val;
        this.alpha = alpha;
        this.beta = beta;
        this.end = end;
    }
}
