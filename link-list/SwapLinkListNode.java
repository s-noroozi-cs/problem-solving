/**
    Problem: Swap nodes in a linked list without swapping data
    Describe: Given a linked list and two keys in it, swap nodes for two given keys.
            Nodes should be swapped by changing links.
            Swapping data of nodes may be expensive in many situations when data contains many fields.
            It may be assumed that all keys in the linked list are distinct.
    Examples:
        Input:  10->15->12->13->20->14,  x = 12, y = 20
        Output: 10->15->20->13->12->14

        Input:  10->15->12->13->20->14,  x = 10, y = 20
        Output: 20->15->12->13->10->14

        Input:  10->15->12->13->20->14,  x = 12, y = 13
        Output: 10->15->13->12->20->14

    More description:
        This may look a simple problem, but is an interesting question as it has the following cases to be handled.
        1) x and y may or may not be adjacent.
        2) Either x or y may be a head node.
        3) Either x or y may be the last node.
        4) x and/or y may not be present in the linked list.

        How to write a clean working code that handles all of the above possibilities.
 */
import java.io.PrintStream;

public class SwapLinkListNode {
    static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    static class LinkList {
        Node head;

        public LinkList(int... items) {
            if (items != null && items.length > 0) {
                head = new Node(items[0]);
                for (int i = 1; i < items.length; i++) {
                    add(items[i]);
                }
            }
        }

        void add(int data) {
            Node n = head;
            while (n.next != null)
                n = n.next;
            n.next = new Node(data);
        }

        void swapNode(int x, int y) {
            System.out.print("Input:  ");
            print(System.out);
            System.out.println(String.format(", x = %d, y = %d", x, y));

            Node preX = null, nodeX = null, preY = null, nodeY = null;
            Node nodePre = null;
            for (Node n = head; n != null; n = n.next) {
                if (n.data == x) {
                    nodeX = n;
                    preX = nodePre;
                } else if (n.data == y) {
                    nodeY = n;
                    preY = nodePre;
                }
                nodePre = n;
            }
            if (nodeX != null && nodeY != null) {
                if (preY != null)
                    preY.next = nodeX;
                else
                    head = nodeX;

                if (preX != null)
                    preX.next = nodeY;
                else
                    head = nodeY;

                Node temp = nodeX.next;
                nodeX.next = nodeY.next;
                nodeY.next = temp;
            }
            System.out.print("Output: ");
            print(System.out);
            System.out.println("\n");
        }

        void print(PrintStream ps) {
            for (Node n = head; n != null; n = n.next) {
                ps.print(n.data);
                if (n.next != null)
                    ps.print("->");
            }
        }
    }

    public static void main(String[] args) {
        int[] items = {10, 15, 12, 13, 20, 14};
        new LinkList(items).swapNode(12, 20);
        new LinkList(items).swapNode(10, 20);
        new LinkList(items).swapNode(12, 13);
    }
}
