import java.util.Scanner;

public class Main {
    static int[] parents;
    static boolean[] visited;
    static int remove, cnt, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int root = 0;
        parents = new int[N];

        for(int i = 0; i<N; i++){
            parents[i] = sc.nextInt();
            if(parents[i]==-1) root = i;
        }
        remove = sc.nextInt();

        deleteNode(remove);
        cnt = 0;
        visited = new boolean[N];
        findLeaf(root);

        System.out.println(cnt);
    }

    public static void deleteNode(int remove){
        parents[remove] = -2;
        for(int i = 0; i<N; i++){
            if(parents[i]==remove){
                deleteNode(i);
            }
        }
    }

    public static void findLeaf(int root){
        visited[root] = true;
        boolean leaf = true;
        if(parents[root]!=-2){
            for(int i = 0; i<N; i++){
                if(parents[i]==root&&!visited[i]){
                    findLeaf(i);
                    leaf = false;
                }
            }
            if(leaf) cnt++;
        }

    }
}