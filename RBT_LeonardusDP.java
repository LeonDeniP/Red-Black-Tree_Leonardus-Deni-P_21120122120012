class Node {
    String key;
    String value;
    String color;
    Node left, right, parent;

    Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.color = "RED";
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class RBT_LeonardusDP {
    private Node root;
    private Node nil;

    RBT_LeonardusDP() {
        nil = new Node("", "");
        nil.color = "BLACK";
        root = nil;
    }

    public void insert(String key, String value) {
        Node z = new Node(key, value);
        Node y = nil;
        Node x = root;

        while (x != nil) {
            y = x;
            if (z.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == nil) {
            root = z;
        } else if (z.key.compareTo(y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = nil;
        z.right = nil;
        z.color = "RED";
        insertFix(z);
    }

    private void insertFix(Node z) {
    }

    public void inorderTraversal(Node node) {
        if (node != nil) {
            inorderTraversal(node.left);
            System.out.println(node.key + ": " + node.value);
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        RBT_LeonardusDP rbTree = new RBT_LeonardusDP();
        rbTree.insert("Alibaba", "Si Orang Timur Tengah");
        rbTree.insert("Bernard Bear", "Si Beruang Versi Inggris");
        rbTree.insert("Bernard Beruang", "Si Beruang Versi Indonesia");
        rbTree.insert("Wawan Gunawan", "Si Teman Ivan Gunawan");
        rbTree.insert("Christiano Ronaldo", "Si Pemain Bola");
        rbTree.insert("Ivan Gunawan", "Si Perancang Busana");
        rbTree.insert("Karsono Adiguno", "Si Bapak-Bapak");

        System.out.println("Urutan Nama:");
        rbTree.inorderTraversal(rbTree.root);
    }
}