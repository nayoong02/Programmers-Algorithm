package Lv3;

import java.util.ArrayList;
import java.util.Comparator;

class Sol_42892 {
    static int idx;

    public static int[][] solution(int[][] nodeinfo) {
        // 리스트에 node 담기
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        // y 큰 순, x 작은 순 정렬
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.y == n2.y ? n1.x - n2.x : n2.y - n1.y;
            }
        });

        // 루트 노드 정하고 이진 트리 구성
        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }

        // 정답 배열
        int[][] answer = new int[2][list.size()];

        // 전위순회
        idx = 0;
        preOrder(answer[0], root);

        // 인덱스 초기화 후 후위순회
        idx = 0;
        postOrder(answer[1], root);

        return answer;
    }

    // 트리에 노드 삽입
    static void insertNode(Node parent, Node node) {
        if (node.x < parent.x) {
            if (parent.left != null) {
                insertNode(parent.left, node);
            } else {
                parent.left = node;
            }
        } else {
            if (parent.right != null) {
                insertNode(parent.right, node);
            } else {
                parent.right = node;
            }
        }
    }

    // 전위순회
    static void preOrder(int[] arr, Node root) {
        if (root != null) {
            arr[idx++] = root.num;
            preOrder(arr, root.left);
            preOrder(arr, root.right);
        }
    }

    // 후위순회
    static void postOrder(int[] arr, Node root) {
        if (root != null) {
            postOrder(arr, root.left);
            postOrder(arr, root.right);
            arr[idx++] = root.num;
        }
    }

    // Node 클래스
    static class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        System.out.println(solution(nodeinfo));
    }

}
