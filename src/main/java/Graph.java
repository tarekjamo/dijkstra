import java.util.ArrayList;

/**
 * Created by tarekray on 27/12/16.
 */
public class Graph {
    ArrayList<Node> nodes ;

    public Graph(int numberOfNodes)
    {
        nodes = new ArrayList<>();
        for(int i = 0 ; i < numberOfNodes ; i++)
        {
            Node n = new Node(i);
            nodes.add(n) ;
        }
    }

    public int shortestPath(int start, int end) {
        setAllNodesDistanceToInfinity(nodes) ;
        nodes.get(start).distance = 0 ;

        ArrayList<Integer> unvisited = new ArrayList<>() ;

        for(int i = 0 ; i < nodes.size() ; i++)
        {
                unvisited.add(i);
        }

        return shortestPath(start, end, unvisited)  ;
    }

    private int shortestPath(int currentid, int end, ArrayList<Integer> unvisited) {
        Node current = nodes.get(currentid) ;
        for(Tuple<Integer,Integer> t : current.neighbors)
        {
            Node neighbor= getNodeById(nodes, t.first) ;
                neighbor.distance=Math.min(neighbor.distance, current.distance+t.second);
        }

        current.visited = true ;

        unvisited.remove(new Integer(currentid));

        if(nodes.get(end).visited)
        {
            return nodes.get(end).distance;
        }
        else {
            int next = 0;
            int min = Integer.MAX_VALUE;

            for (int n : unvisited) {
                Node temp = nodes.get(n);
                if (temp.distance < min) {
                    next = temp.id;
                    min = temp.distance;
                }
            }
            if (min != Integer.MAX_VALUE) {
                return  shortestPath(next, end, unvisited);
            } else
            {
                return -1 ;//cant reach end node from start
            }
        }
    }


    private Node getNodeById(ArrayList<Node> nodes, int first) {

        for(Node n : nodes)
        {
            if(n.id==first)
            {
                return  n ;
            }
        }
        return  null ;
    }

    private void setAllNodesDistanceToInfinity(ArrayList<Node> nodes) {
        nodes.stream().forEach(n -> n.distance=Integer.MAX_VALUE );
    }
}
