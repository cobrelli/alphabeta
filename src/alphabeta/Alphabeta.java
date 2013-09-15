/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabeta;

import java.util.ArrayList;

/**
 *
 * @author Cobrelli
 */
public class Alphabeta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Node eka = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);
        Node v = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);
        Node k = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);
        Node o = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);

        eka.children.add(v);
        eka.children.add(k);
        eka.children.add(o);

        // vasen haara

        Node vv = new Node(null, new ArrayList<Node>(), -1, +1, true, -1);
        Node vo = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);

        v.children.add(vv);
        v.children.add(vo);

        Node vov = new Node(null, new ArrayList<Node>(), -1, +1, true, 1);
        vo.children.add(vov);

        //keskihaara

        Node kv = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);
        Node ko = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);

        k.children.add(kv);
        k.children.add(ko);

        Node kvv = new Node(null, new ArrayList<Node>(), -1, +1, true, 1);
        kv.children.add(kvv);

        Node koo = new Node(null, new ArrayList<Node>(), -1, +1, true, 0);
        ko.children.add(koo);

        //oikea

        Node ov = new Node(null, new ArrayList<Node>(), -1, +1, true, -1);
        o.children.add(ov);

        Node oo = new Node(null, new ArrayList<Node>(), -1, +1, false, -100);
        o.children.add(oo);

        Node oov = new Node(null, new ArrayList<Node>(), -1, +1, true, 0);
        oo.children.add(oov);


//        traversal(eka);
        System.out.println(alphaBetaArvo(eka));
    }

    public static void traversal(Node alku) {
        System.out.println("käyty solmu");
        if (alku.end) {
            System.out.println("loppusolmu");
        }
        for (Node n : alku.children) {
            traversal(n);
        }
    }

    public static int alphaBetaArvo(Node n) {
        return maxArvo(n, -1, +1);
    }

    private static int maxArvo(Node n, int alpha, int beta) {
        if (n.end) {
            return n.val;
        }
        int v = Integer.MIN_VALUE;

        for (Node c : n.children) {
            v = Math.max(v, minArvo(c, alpha, beta));
            if (v >= beta) {
                return v;
            }
            alpha = Math.max(alpha, v);
        }

        return v;
    }

    private static int minArvo(Node n, int alpha, int beta) {
        if (n.end) {
            return n.val;
        }
        int v = Integer.MAX_VALUE;

        for (Node c : n.children) {
            v = Math.min(v, maxArvo(c, alpha, beta));
            if (v <= alpha) {
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}
