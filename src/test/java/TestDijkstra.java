import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by tarekray on 27/12/16.
 */
public class TestDijkstra {


    @Test
    public void test() {

       Graph g = new GraphBuilder()
               .build(5)
               .withEdge(0, 1, 50)
               .withEdge(0,2,100)
               .withEdge(1,2,10)
               .withEdge(2, 3, 20)
               .get() ;
        assertThat(g.nodes.size()).isEqualTo(5);
        assertThat(g.nodes.get(0).neighbors.size()).isEqualTo(2);
        assertThat(g.nodes.get(0).neighbors.stream().mapToInt(t -> t.second).sum()).isEqualTo(150);
        assertThat(g.nodes.get(3).neighbors.size()).isEqualTo(1);

        assertThat(g.shortestPath(0,2)).isEqualTo(60);
        assertThat(g.shortestPath(0,4)).isEqualTo(-1);
        assertThat(g.shortestPath(0,1)).isEqualTo(50);

    }


}
