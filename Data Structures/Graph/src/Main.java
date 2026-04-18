import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Edge List
        int[][] edgeList = {{0, 2}, {2, 3}, {2, 1}, {1, 3}};
        //Adjacent List
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();
        adjacentList.put(0, Arrays.asList(2));
        adjacentList.put(2, Arrays.asList(0,3,1));
        adjacentList.put(3, Arrays.asList(2,1));
        adjacentList.put(1, Arrays.asList(2,3));
        //Adjacent Matrix
        int[][] adjacentMatrix = {
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };
    }
}