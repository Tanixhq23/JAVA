
import java.util.*;

public class graphs {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // static class Edge implements Comparable<Edge> {

    //     int src;
    //     int dest;
    //     int wt;

    //     public Edge(int src, int dest, int wt) {
    //         this.src = src;
    //         this.dest = dest;
    //         this.wt = wt;
    //     }

    //     @Override
    //     public int compareTo(Edge e2) {
    //         return this.wt - e2.wt;
    //     }
    // }
    // Info: For Connecting cities
    // static class Edge implements Comparable<Edge> {
    //     int dest;
    //     int cost;

    //     public Edge(int d, int c) {
    //         this.cost = c;
    //         this.dest = d;
    //     }

    //     @Override
    //     public int compareTo(Edge e2) {
    //         return this.cost - e2.cost;
    //     }

    // }

    // @SuppressWarnings("unchecked")
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Info: For has Path Ques
        // // Edges for node 0
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // // Edges for node 1
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));
        // // Edges for node 2
        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));
        // // Edges for node 3
        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));
        // // Edges for node 4
        // graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));
        // // Edges for node 5
        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));
        // // Edges for node 6
        // graph[6].add(new Edge(6, 5, 1));
        // Info: For Cycle Detection
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));
        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));
        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));
        // Info: Check if graph is bipartite
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));
        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // Info: Cycle Detection in directed graph
        // Info: Cycle exists
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 0));
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));
        // Info: No cycle exists
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));
        // graph[1].add(new Edge(1,3));
        // graph[2].add(new Edge(2,3));
        // Info: For topological Sorting using DFS
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 1));
        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));
        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));
        // Info: For topological Sorting using BFS
        // graph[0].add(new Edge(0, 3));
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 1));
        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));
        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));
        // Info: Dijkstra's Algorithm
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));
        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[2].add(new Edge(2, 4, 3));
        // graph[3].add(new Edge(3, 5, 1));
        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));
        // Info: Cycle Detection in undirected graph using BFS
        // graph[1].add(new Edge(1, 9));
        // graph[1].add(new Edge(1, 5));
        // graph[2].add(new Edge(2, 4));
        // graph[2].add(new Edge(2, 5));
        // graph[4].add(new Edge(4, 2));
        // graph[5].add(new Edge(5, 1));
        // graph[5].add(new Edge(5, 2));
        // graph[9].add(new Edge(9, 5));
        // graph[9].add(new Edge(9, 1));
        // Info: Bellman Ford Algorithm
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));
        // Topic: Prim's Algorithm
        // graph[0].add(new Edge(0, 1, 10));
        // graph[0].add(new Edge(0, 2, 15));
        // graph[0].add(new Edge(0, 3, 30));

        // graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 3, 40));

        // graph[2].add(new Edge(2, 0, 15));
        // graph[2].add(new Edge(2, 3, 50));

        // graph[3].add(new Edge(3, 1, 40));
        // graph[3].add(new Edge(3, 2, 50));
        // Info: Kosaraju's Algo
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 4));
        // Info: Bridge In Graph
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));
        // // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 3));
        // // graph[4].add(new Edge(4, 5));

        // // graph[5].add(new Edge(5, 3));
        // // graph[5].add(new Edge(5, 4));
        // Info: Articulation Point (Tarjan's Algoriothm)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // static void createGraph(ArrayList<Edge> edges) {
    //     // graph.add(new Edge(0, 1, 2));
    //     // graph.add(new Edge(0, 2, 4));
    //     // graph.add(new Edge(1, 2, -4));
    //     // graph.add(new Edge(2, 3, 2));
    //     // graph.add(new Edge(3, 4, 4));
    //     // graph.add(new Edge(4, 1, -1));
    //     // Topic: Kruskal's Algorithm 
    //     edges.add(new Edge(0, 1, 10));
    //     edges.add(new Edge(0, 2, 15));
    //     edges.add(new Edge(0, 3, 30));
    //     edges.add(new Edge(1, 3, 40));
    //     edges.add(new Edge(2, 3, 50));
    // }

    // Topic: Breadth First Search
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // Info: Source -> 0
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Topic: Depth First Search
    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        // Visit curr
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // Topic: Has Path
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    // Topic: Cycle Detection (Undirected Graph)
    public static boolean DetectCycleUndir(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (DetectCycleUndirUtil(graph, vis, i, -1)) {
                    return true;
                    // Info: Cycle exits in one of the parts!
                }
            }
        }
        return false;
    }

    public static boolean DetectCycleUndirUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            // CASE 3: Neighbour is not visited then visit and if detectUtil also return true for neighbour then cycle exists
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (DetectCycleUndirUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // CASE 1: Neighbour visited and neighbour's value is not equal to parent's value, Then guranteed cycle exists
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // CASE 2: Do Nothing case where Neighbour is visited and parent's value is equal to the value of neighbour, then do nothing
        }
        return false;
    }

    // Topic: Is Bipartite
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // Info: BFS
                q.add(i);
                col[i] = 0; // Info: Yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // Info: Neighbour -> e.dest
                        // CASE 1: No colour
                        if (col[e.dest] == -1) {
                            int nextcol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        }
                        // CASE 2: Colour exists for neighbour ans is same as my colour (Current Node)
                        else if (col[e.dest] == col[curr]) {
                            return false; // Info:Not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    // Topic: Cycle Detection in Directed Graph -> DFS
    public static boolean DetectCycleDir(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (DetectCycleDirUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DetectCycleDirUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // CASE 1: Neighbour already exsts in sstack then cycle is present
            if (stack[e.dest]) {
                return true;
            }
            // CASE 2: Neghibour is no visited
            if (!vis[e.dest] && DetectCycleDirUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    // Topic: Topological Sort using DFS
    public static void topologicalsortDFS(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalsortDFSUtil(graph, i, vis, s); // Info: Modifies DFS
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }

    public static void topologicalsortDFSUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalsortDFSUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    // Topic: Topological Sort Using BFS (Kahn's ALgorithm)
    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topologicalsortBFS(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // Topic: All paths from source to target
    // public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
    //     if (src == dest) {
    //         System.out.println(path + dest);
    //         return;
    //     }
    //     for (int i = 0; i < graph[src].size(); i++) {
    //         Edge e = graph[src].get(i);
    //         printAllPaths(graph, e.dest, dest, path + src);
    //     }
    // }

    // Topic: Dijkstra's Algortihm
    // static class Pair implements Comparable<Pair> {
    //     int n;
    //     int path;

    //     public Pair(int n, int path) {
    //         this.n = n;
    //         this.path = path;
    //     }

    //     @Override
    //     public int compareTo(Pair p2) {
    //         return this.path - p2.path; // Info: Path based sorting for my pairs
    //     }

    // }

    // public static void dijkstrasAlgo(ArrayList<Edge>[] graph, int src) {
    //     int dist[] = new int[graph.length];
    //     for (int i = 0; i < graph.length; i++) {
    //         if (i != src) {
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }
    //     boolean vis[] = new boolean[graph.length];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     pq.add(new Pair(src, 0));
    //     while (!pq.isEmpty()) {
    //         Pair curr = pq.remove();
    //         if (!vis[curr.n]) {
    //             vis[curr.n] = true;
    //             for (int i = 0; i < graph[curr.n].size(); i++) {
    //                 Edge e = graph[curr.n].get(i);
    //                 int u = e.src;
    //                 int v = e.dest;
    //                 int wt = e.wt;
    //                 if (dist[u] + wt < dist[v]) {
    //                     dist[v] = dist[u] + wt;
    //                     pq.add(new Pair(v, dist[v]));
    //                 }
    //             }
    //         }
    //     }
    //     // Info: Print all source to vertices shortest distance
    //     for (int i = 0; i < dist.length; i++) {
    //         System.out.print(dist[i] + "->");
    //     }
    //     System.out.println();
    // }

    // Sol: Cycle Detection in undirected graph using BFS
    public static boolean cycleDetectionUndirectedBFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int src = 0; src < graph.length; src++) {
            if (bfs(src, vis, graph)) {
                return true;
            }
        }
        return false;
    }

    public static boolean bfs(int src, boolean[] vis, ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == true) {
                return true;
            }
            vis[curr] = true;
            for (Edge e : graph[curr]) {
                int nbr = e.dest;
                if (src == nbr) {
                    return true;
                }
                if (vis[nbr] == true) {
                    continue;
                }
                q.add(nbr);
            }

        }
        return false;
    }

    // Sol: courseScheduleII

    static class Graph { // O(E + V)
        ArrayList<Integer>[] adj;
        int n;

        Graph(int n) { // O(n)
            this.n = n;
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void addEdges(int[][] edges) { // O(E)
            for (int[] i : edges) {
                addEdge(i[1], i[0]);
            }
        }
    }

    int[] topoArray;
    int ptr;

    public boolean topoSort(Graph g, int src, int[] vis) {
        // preorder
        if (vis[src] == 0)
            return true; //cycle
        if (vis[src] == 1)
            return false; //no cycle
        vis[src] = 0;
        for (int nbr : g.adj[src]) {
            if (topoSort(g, nbr, vis)) {
                return true;
            }
        }
        // postorder
        topoArray[ptr--] = src;
        vis[src] = 1;
        return false;
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        Graph g = new Graph(n);
        g.addEdges(prerequisites);
        ptr = n - 1;
        topoArray = new int[n];
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            if (vis[i] != -1) {
                continue;
            }
            if (topoSort(g, i, vis)) {
                return new int[0];
            }
        }
        return topoArray;
    }

    // Topic: Bellman Ford Algorithm
    // public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
    //     int dist[] = new int[V];
    //     for (int i = 0; i < dist.length; i++) {
    //         if (i != src) {
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }
    //     // Info: Algo
    //     for (int i = 0; i < V - 1; i++) {
    //         // Info: Edges
    //         // for (int j = 0; j < graph.size(); j++) {
    //         //     for (int k = 0; k < graph[k].size(); k++) {
    //         //         Edge e = graph[j].get(k);
    //         //         int u = e.src;
    //         //         int v = e.dest;
    //         //         int wt = e.wt;
    //         //         // Info: Relaxation
    //         //         if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
    //         //             dist[v] = dist[u] + wt;
    //         //         }
    //         //     }
    //         // }

    //         for (int j = 0; j < graph.size(); j++) {
    //             Edge e = graph.get(j);
    //             int u = e.src;
    //             int v = e.dest;
    //             int wt = e.wt;
    //             // Info: Relaxation
    //             if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
    //                 dist[v] = dist[u] + wt;
    //             }
    //         }
    //     }

    //     for (int i = 0; i < dist.length; i++) {
    //         System.out.println(dist[i] + " ");
    //     }

    // }

    // Topic: Prims Algorithm
    // static class Pair implements Comparable<Pair> {
    //     int v;
    //     int cost;

    //     public Pair(int v, int cost) {
    //         this.v = v;
    //         this.cost = cost;
    //     }

    //     @Override
    //     public int compareTo(Pair p2) {
    //         return this.cost - p2.cost;
    //     }
    // }

    // public static void primsAlgo(ArrayList<Edge> graph[]) {
    //     boolean vis[] = new boolean[graph.length];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     pq.add(new Pair(0, 0));
    //     int finalcost = 0;
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     while (!pq.isEmpty()) {
    //         Pair curr = pq.remove();
    //         if (!vis[curr.v]) {
    //             vis[curr.v] = true;
    //             finalcost += curr.cost;
    //             ans.add(curr.v);
    //             for (int i = 0; i < graph[curr.v].size(); i++) {
    //                 Edge e = graph[curr.v].get(i);
    //                 pq.add(new Pair(e.dest, e.wt));
    //             }
    //         }
    //     }
    //     System.out.println("Final Cost of MST: " + finalcost);
    //     for (int i = 0; i < ans.size(); i++) {
    //         System.out.print(ans.get(i) + "->");
    //     }
    //     System.out.println();
    // }

    // Topic: Cheapest Flights within k stops
    // public static void createGraph(int[][] flights, ArrayList<Edge> graph[]) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     for (int i = 0; i < flights.length; i++) {
    //         int src = flights[i][0];
    //         int dest = flights[i][1];
    //         int wt = flights[i][2];

    //         Edge e = new Edge(src, dest, wt);
    //         graph[src].add(e);

    //     }
    // }

    // static class Info {
    //     int v;
    //     int cost;
    //     int stops;

    //     public Info(int v, int c, int s) {
    //         this.v = v;
    //         this.cost = c;
    //         this.stops = s;
    //     }

    // }

    // public static int cheapestFlights(int n, int flights[][], int src, int dest, int k) {
    //     ArrayList<Edge> graph[] = new ArrayList[n];
    //     createGraph(flights, graph);
    //     int dist[] = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         if (i != src) {
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }
    //     Queue<Info> q = new LinkedList<>();
    //     q.add(new Info(src, 0, 0));
    //     while (!q.isEmpty()) {
    //         Info curr = q.remove();
    //         if (curr.stops > k) {
    //             break;
    //         }
    //         for (int i = 0; i < graph[curr.v].size(); i++) {
    //             Edge e = graph[curr.v].get(i);
    //             int u = e.src;
    //             int v = e.dest;
    //             int wt = e.wt;
    //             if (curr.cost + wt < dist[v] && curr.stops <= k) {
    //                 dist[v] = curr.cost + wt;
    //                 q.add(new Info(v, dist[v], curr.stops + 1));
    //             }
    //         }
    //     }
    //     if (dist[dest] == Integer.MAX_VALUE) {
    //         return -1;
    //     } else {
    //         return dist[dest];
    //     }
    // }

    // Topic: Connecting Citites
    // public static int connectCities(int[][] cities) {
    //     PriorityQueue<Edge> pq = new PriorityQueue<>();
    //     boolean vis[] = new boolean[cities.length];
    //     pq.add(new Edge(0, 0));
    //     int finalcost = 0;
    //     while (!pq.isEmpty()) {
    //         Edge curr = pq.remove();
    //         if (!vis[curr.dest]) {
    //             vis[curr.dest] = true;
    //             finalcost += curr.cost;
    //             for (int i = 0; i < cities[curr.dest].length; i++) {
    //                 if (cities[curr.dest][i] != 0) {
    //                     pq.add(new Edge(i, cities[curr.dest][i]));
    //                 }
    //             }
    //         }
    //     }
    //     return finalcost;
    // }

    // Topic: Disjoint Set
    static int n = 4; //vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    // Info: Find Function
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    // Info: Union Function
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // Topic: Kruskal's Algorithm
    // public static void KruskalAlgo(ArrayList<Edge> edges, int V) {
    //     init();
    //     Collections.sort(edges);
    //     int mstCost = 0;
    //     int count = 0;
    //     for (int i = 0; count < V - 1; i++) {
    //         Edge e = edges.get(i);
    //         int parA = find(e.src);
    //         int parB = find(e.dest);
    //         if (parA != parB) {
    //             union(e.src, e.dest);
    //             mstCost += e.wt;
    //             count++;
    //         }
    //     }
    //     System.out.println("MST Cost: " + mstCost);
    // }

    // Topic: Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        FloodFillhelper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public void FloodFillhelper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        // Info: Base Case
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }
        image[sr][sc] = color;
        // Info: Left
        FloodFillhelper(image, sr, sc - 1, color, vis, orgCol);
        // Info: Right
        FloodFillhelper(image, sr, sc + 1, color, vis, orgCol);
        // Info: Up
        FloodFillhelper(image, sr - 1, sc, color, vis, orgCol);
        // Info: Down
        FloodFillhelper(image, sr + 1, sc, color, vis, orgCol);
    }

    // Sol: Minimum Time To Rotten Oranges
    // static class Pair {
    //     int row;
    //     int col;
    //     int tm;

    //     Pair(int r, int c, int t) {
    //         this.row = r;
    //         this.col = c;
    //         this.tm = t;
    //     }
    // }

    // public static int rottenOranges(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     Queue<Pair> q = new LinkedList<>();
    //     int[][] vis = new int[n][m];
    //     int cntFresh = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (grid[i][j] == 2) {
    //                 q.add(new Pair(i, j, 0));
    //                 vis[i][j] = 2;
    //             } else {
    //                 vis[i][j] = 0;
    //             }
    //             if (grid[i][j] == 1) {
    //                 cntFresh++;
    //             }
    //         }
    //     }
    //     int tm = 0;
    //     int[] drow = { -1, 0, +1, 0 };
    //     int[] dcol = { 0, 1, 0, -1 };
    //     int cnt = 0;

    //     while (!q.isEmpty()) {
    //         int r = q.peek().row;
    //         int c = q.peek().col;
    //         int t = q.peek().tm;
    //         q.poll();
    //         tm = Math.max(tm, t);
    //         for (int i = 0; i < 4; i++) {
    //             int nr = r + drow[i];
    //             int nc = c + dcol[i];

    //             if (nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
    //                 q.add(new Pair(nr, nc, t + 1));
    //                 vis[nr][nc] = 2;
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return (cnt == cntFresh) ? tm : -1;
    // }

    // Sol: Word Ladder
    // static class Pair {
    //     String word;
    //     int len;

    //     Pair(String w, int l) {
    //         this.word = w;
    //         this.len = l;
    //     }
    // }

    // public static int WordLadder(String begin, String end, String[] dic) {
    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(begin, 1));
    //     Set<String> st = new HashSet<String>();
    //     int len = dic.length;
    //     for (int i = 0; i < len; i++) {
    //         st.add(dic[i]);
    //     }
    //     st.remove(begin);
    //     while (!q.isEmpty()) {
    //         String word = q.peek().word;
    //         int steps = q.peek().len;
    //         q.remove();
    //         if (word.equals(end) == true) {
    //             return steps;
    //         }
    //         for (int i = 0; i < word.length(); i++) {
    //             for (char ch = 'a'; ch <= 'z'; ch++) {
    //                 char replacedchararray[] = word.toCharArray();
    //                 replacedchararray[i] = ch;
    //                 String replacedWord = new String(replacedchararray);
    //                 if (st.contains(replacedWord)) {
    //                     st.remove(replacedWord);
    //                     q.add(new Pair(replacedWord, steps + 1));
    //                 }
    //             }
    //         }
    //     }
    //     return 0;
    // }

    // Sol: Find the area of the largest region in the boolean matrix
    static int ROW, COL, count;

    // Check if a cell is safe to visit
    static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    // DFS to explore the region
    static void DFS(int[][] M, int row, int col, boolean[][] visited) {
        // Directions for 8 possible neighbors (up, down, left, right, and diagonals)
        int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark the current cell as visited
        visited[row][col] = true;
        // Explore all 8 neighbors
        for (int k = 0; k < 8; k++) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                count++; // Increment region count
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    // Function to find the largest region in the grid
    public static void largestRegion(int[][] M) {
        ROW = M.length;
        COL = M[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int result = 0;

        // Traverse all cells in the grid
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                // If the cell is land (1) and hasn't been visited, start DFS
                if (M[i][j] == 1 && !visited[i][j]) {
                    count = 1; // Initialize region count
                    DFS(M, i, j, visited);
                    // Update the largest region found
                    result = Math.max(result, count);
                }
            }
        }
        System.out.println(result); // Return the size of the largest region
    }

    // SOl: Alien Dictionary
    public static List<Integer> topoSort(int V, ArrayList<List<Integer>> adj) {
        int[] indeg = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indeg[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.peek();
            q.remove();
            topo.add(curr);
            for (int i : adj.get(curr)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }
        return topo;
    }

    public static void alienDictionary(String dic[], int n, int k) {

        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String s1 = dic[i];
            String s2 = dic[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        List<Integer> res = topoSort(k, adj);
        StringBuilder ans = new StringBuilder();
        for (int i : res) {
            ans.append((char) (i + 'a'));
        }
        System.out.println(ans);
    }

    // Topic: Strongly Connected Components(Kosaraju's Algorithm)
    public static void topsort(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topsort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfsUtil2(ArrayList<Edge> graph[], int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil2(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int v) {
        // Info: Step 1
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topsort(graph, i, vis, s);
            }
        }
        // Info: Step 2
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); // reverse edge e.dest->e.src
            }
        }
        // Info: Step 3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC -> ");
                dfsUtil2(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    // Topic: Bridge In Graph (Tarjan's Algorithm)
    public static void tarjandfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[],
            int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // e.src --------- e.dest
            int neigh = e.dest;
            // CASE 1: Neighbour is equal to Parent
            if (neigh == par) {
                continue;
            }
            // CASE 2: Neighbour not visited
            else if (!vis[neigh]) {
                tarjandfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                // Info: Bridge Condition
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge: " + curr + "----" + neigh);
                }
            }
            // CASE 3: Neighbour already visited
            else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjansBridge(ArrayList<Edge> graph[], int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean vis[] = new boolean[v];
        int time = 0;
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                tarjandfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    // Topic: Articulation Points
    public static void APdfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean vis[],
            boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            // CASE 1: Parent == neighbour
            if (par == neigh) {
                continue;
            }
            // CASE 2: Neighbour already visited (Backkedge)
            else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            // CASE 3: Neighbour not visited
            else {
                APdfs(graph, neigh, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        // CASE 4: Starting Point of the DFS
        if (par == -1 && children > 1) {

            ap[curr] = true;
        }
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean vis[] = new boolean[v];
        boolean ap[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                APdfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }
        for(int i = 0; i<ap.length; i++){
            if(ap[i]){
                System.out.println("Articulation point -> " + i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // int V = 5;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // for (int i = 0; i < V; i++) {
        //     graph[i] = new ArrayList<>();
        // }
        // // for 0 vertex
        // graph[0].add(new Edge(0, 1, 5));
        // // for 1 vertex
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));
        // // for 2 vertex 
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));
        // // for 3 vertex 
        // graph[3].add(new Edge(3, 2, 1));
        // graph[3].add(new Edge(3, 1, 3));
        // // for 4 vertex 
        // graph[4].add(new Edge(4, 2, 2));
        // // Info: 2's neighbour
        // for (int i = 0; i < graph[2].size(); i++) {
        //     Edge e = graph[i].get(i);
        //     System.out.println(e.dest);
        // }
        // Topic: Breadth First Search
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // bfs(graph);
        // Topic: Depth First Search
        // dfs(graph);
        // Topic: Has Path
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));
        // Topic: Cycle Detection (Undirected Graph) - DFS
        // V = 5;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(DetectCycleUndir(graph));
        // Topic: Is Bipartite?
        // V = 5;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(isBipartite(graph));
        // Topic: Cycle Detection in Directed graph -> modified dfs
        // V = 4;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(DetectCycleDir(graph));
        // Topic: Topological Sort using DFS
        // V = 6;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // topologicalsortDFS(graph);
        // Topic: Topological Sort using BFS(Kahn's Algorithm)
        // V = 6;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // topologicalsortBFS(graph);
        // Topic: All paths form source to target
        // printAllPaths(graph, 5, 1, "");
        // Topic: Dijkstra's Algortihm
        // V = 6;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // dijkstrasAlgo(graph, 0);
        // Ques 1: Cycle Detection in undirected graph using BFS
        // V = 10;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(cycleDetectionUndirectedBFS(graph));
        // Ques 2: Course Schedule II
        // Info: An 2d Array is required for this problem which i havn't prepared rn! Hope you understand :)
        // Topic: Bellman Ford Algorithm
        // V = 5;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // bellmanFord(graph, 0);
        // Info: Using ArrayList
        // ArrayList<Edge> graph = new ArrayList<>();
        // createGraph2(graph);
        // bellmanFord(graph, 0, V);
        // Topic: MST 
        // Topic: Prim's Algorithm
        // V = 4;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // primsAlgo(graph);
        // Topic: Cheapest Flights within k stops
        // int n = 4;
        // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        // int src = 0, dst = 3, k = 1;
        // System.out.println(cheapestFlights(n, flights, src, dst, k));
        // Topic: Conneting cities
        // int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
        //         { 4, 7, 0, 0, 0 } };
        // System.out.println(connectCities(cities));
        // Topic: Disjoint Set
        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);
        // Topic: Kruskal's 
        // V = 4;
        // ArrayList<Edge> edges = new ArrayList<>();
        // createGraph(edges);
        // KruskalAlgo(edges, V);
        // Ques 3: Minimum Time To Rotten Oranges
        // Ques 4: Find the area of the largest region in the boolean matrix
        // int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 0, 1, 1, 1 } };
        // System.out.println("Largest region: ");
        // largestRegion(grid);
        // Ques 5: Find whether it is possible to finish all tasks or not
        // Info: Similar to Course Schedule II
        // Ques 6: Alien Dictionary
        // String[] dictionary = { "baa", "abcd", "abca", "cab", "cad" };
        // int N = dictionary.length; // Number of words
        // int K = 4; // Number of unique characters
        // alienDictionary(dictionary, N, K);
        // Topic: Strongly Connected Components (Kosaraju's Algorithm)
        // V = 5;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // kosaraju(graph, V);
        // Topic: Bridge In Graph
        // V = 5;
        // graph = new ArrayList[V];
        // createGraph(graph);
        // tarjansBridge(graph, V);
        // Topic: Articulation Points (Tarjan's Algorithm)
        V = 5;
        graph = new ArrayList[V];
        createGraph(graph);
        getArticulationPoint(graph, V);
    }
}