import javafx.util.Pair;

import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {{2,-3}, {-17, -8}, {13, 8}, {-17, -15}};
        System.out.println(minCostConnectPoints(arr));
    }

    public static int minCostConnectPoints(int[][] points) {
        List<Pair<Integer, Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>>> listPoints = new ArrayList<>();
        List<Pair<Integer,Integer>> point = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int val = Math.abs(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                if(val != 0) {
                    listPoints.add(new Pair<>(val, new Pair<>(new Pair<>(points[i][0], points[i][1]), new Pair<>(points[j][0], points[j][1]))));
                }
            }
        }

        if(points.length > 1) {
            countingSort(listPoints);

            for (Pair<Integer, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> pair : listPoints) {

                if (!(point.contains(pair.getValue().getValue()) && point.contains(pair.getValue().getKey())) ) {
                    answer += pair.getKey();
                    point.add(pair.getValue().getValue());
                    point.add(pair.getValue().getKey());
                }
            }
        }

        return answer;
    }

    public static void countingSort(List<Pair<Integer, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>>> listPoints) {
        List<Integer> list = new ArrayList<>();
        List<Pair<Integer, Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>>> output = new ArrayList<>(Collections.nCopies(listPoints.size(),null));

        for (int i = 0; i < listPoints.size(); i++) {
            list.add(i, listPoints.get(i).getKey());
        }

        int minimumElement = Collections.min(list);
        int maximumElement = Collections.max(list);
        int range = maximumElement - minimumElement;
        int[] counting = new int[range + 1];

        for (int i = 0; i < listPoints.size(); ++i) {
            ++counting[list.get(i) - minimumElement];
        }

        for (int i = 1; i <= range; ++i) {
            counting[i] += counting[i - 1];
        }

        for (int i = listPoints.size() - 1; i >= 0; i--) {
            output.add(counting[list.get(i) - minimumElement] - 1, new Pair<>(listPoints.get(i).getKey(), listPoints.get(i).getValue()));
            output.remove(counting[list.get(i) - minimumElement]);
            --counting[list.get(i) - minimumElement];
        }

        for (int i = 0; i < listPoints.size(); i++) {
            listPoints.set(i, output.get(i));
        }

    }

}
