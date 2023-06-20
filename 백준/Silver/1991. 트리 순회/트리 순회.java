import java.util.Scanner;

public class Main {

    public static class Node{
        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static Node head = new Node("A",null,null);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            String root = sc.next();
            String left = sc.next();
            String right = sc.next();
            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);

    }

    private static void insertNode(Node temp, String root, String left, String right) {
        if(temp.value.equals(root)){
            temp.left=(left.equals(".")?null:new Node(left,null,null));
            temp.right=(right.equals(".")?null:new Node(right,null,null));
        }
        else{
            if(temp.left!=null) insertNode(temp.left, root, left, right);
            if(temp.right!=null) insertNode(temp.right, root, left, right);
        }
    }

    static void preOrder(Node node){
        if(node ==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node){
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

}