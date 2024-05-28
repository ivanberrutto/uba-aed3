package aed;
import java.util.*;

// Creation of Adjacency List
// The adjacency List consist of an ArrayList within an
// ArrayList. The inner ArrayList holds the HashMap of
// (vertices,weight)
public class Grafo_Pesado {
    int v;
    ArrayList<ArrayList<HashMap<Integer, Integer> > > adj;
    Grafo_Pesado(int v)
    {
        this.v = v;
        this.adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            this.adj.add(new ArrayList<>());
        }
    }
    // Function to add an Edge
    void addEdge(int u, int v, int weight)
    {
        this.adj.get(u).add(new HashMap<>());
        this.adj.get(u)
                .get(this.adj.get(u).size() - 1)
                .put(v, weight);
        /*
        this.adj.get(v).add(new HashMap<>());
        this.adj.get(v)
                .get(this.adj.get(v).size() - 1)
                .put(u, weight);

         */
    }
    void printGraph()
    {
        for (int i = 0; i < this.v; i++) {
            System.out.println("\nNode " + i
                    + " makes an edge with ");
            for (HashMap<Integer, Integer> j :
                    this.adj.get(i)) {
                j.entrySet().forEach(
                        e
                                -> System.out.println(
                                "\tNode " + e.getKey()
                                        + " with edge weight "
                                        + e.getValue() + " "));
            }
        }
    }

    int primMST(int startNode) {
        int totalWeight = 0;

        // Priority queue to store vertices
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        boolean[] visited = new boolean[v];

        // Start with the given node
        pq.add(new AbstractMap.SimpleEntry<>(startNode, 0));

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> node = pq.poll();
            int u = node.getKey();

            // If this node is already processed, skip
            if (visited[u])
                continue;

            // Mark the node as visited
            visited[u] = true;

            // Add weight to total weight
            totalWeight += node.getValue();

            // Visit all adjacent vertices
            for (HashMap<Integer, Integer> neighbor : this.adj.get(u)) {
                for (Map.Entry<Integer, Integer> edge : neighbor.entrySet()) {
                    int v = edge.getKey();
                    int weight = edge.getValue();
                    if (!visited[v])
                        pq.add(new AbstractMap.SimpleEntry<>(v, weight));
                }
            }
        }

        return totalWeight;
    }


}