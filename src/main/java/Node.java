import java.util.ArrayList;

/**
 * Created by tarekray on 27/12/16.
 */
public class Node {

    int id ;
    ArrayList<Tuple<Integer, Integer>> neighbors ;
    int distance ;
    boolean  visited ;
    public Node(int id)
    {
        this.visited = false ;
        this.id = id ;
        neighbors = new ArrayList<>();
    }

    public Node addNeighbor(int neighborID, int weight)
    {
        neighbors.add(new Tuple<>(neighborID, weight)) ;
        return  this ;
    }



}
