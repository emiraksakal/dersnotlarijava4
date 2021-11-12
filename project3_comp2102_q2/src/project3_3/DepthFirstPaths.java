package project3_3;

public class DepthFirstPaths {


    boolean[] marked;
    City[] edgeTo;
    City from;

    public boolean hasPathTo(City w) {
        return marked[w.hashCode()];
    }

    public City[] pathTo(City w) {
        City k = edgeTo[w.hashCode()];
        java.util.Stack<City> st = new java.util.Stack<City>();
        st.push(k);
        while (k != this.from) {
            k = edgeTo[k.hashCode()];
            st.push(k);
        }
        //st.push(from);

        City[] path = new City[st.size()];
        for (int i = 0; i < path.length; i++)
            path[i] = st.pop();
        return path;

    }

    public void printPathTo(City w) {

        City[] path = pathTo(w);

        for (int i = 0; i < path.length; i++) {

            System.out.print("->" + path[i]);
        }
        System.out.println("->" + w);

    }

    public DepthFirstPaths(Graph g, City from) {
        edgeTo = new City[g.getNumV()];
        marked = new boolean[g.getNumV()];
        this.from = from;
        dfs(g, from);
    }

    public void dfs(Graph g, City source) {
        marked[source.hashCode()] = true;
        City[] a = source.neighbours.toArray(new City[0]);
        for (int i = 0; i < a.length; i++) {
            City neighbor = a[i];
            if (!marked[neighbor.hashCode()]) {
                //System.out.println("..."+neighbor);
                dfs(g, neighbor);

                edgeTo[neighbor.hashCode()] = source;
            }
        }
    }
}

