package datastruct;

public class Grap {
    int currentIndex;
    GrapNode[] grapNodes;
    int[][] matrix;

    public Grap(int size) {
        grapNodes = new GrapNode[size];
        matrix = new int[size][size];
    }

    public void addGrapNode(GrapNode node) {
        grapNodes[currentIndex] = node;
    }

    public void addEdge(String n1, String n2) {
        int index1 = -1;
        for (int i = 0; i < grapNodes.length; i++) {
            if (grapNodes[i].value.equals(n1)) {
                index1 = i;
                break;
            }
        }
        int index2 = -1;
        for (int j =0;j<grapNodes.length;j++){
            if (grapNodes[j].value.equals(n2)){
                index2 = j;
                break;
            }
        }
        matrix[index1][index2] = 1;
        matrix[index2][index1] = 1;
    }
}
