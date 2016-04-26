package Google;

/**
 * Created by xyunpeng on 4/25/16.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets.length == 0 || tickets[0].length == 0) {
            return result;
        }

        Map<String, ArrayList<String>> hash = new HashMap<>();
        int tlen = tickets.length;
        for (int i = 0; i < tlen; i++) {
            if (!hash.containsKey(tickets[i][0])) {
                hash.put(tickets[i][0], new ArrayList<>());
            }
            hash.get(tickets[i][0]).add(tickets[i][1]);
        }

        for (String s : hash.keySet()) {
            Collections.sort(hash.get(s));
        }


        backtracing(result, "JFK", hash);

        return result;
    }

    public void backtracing(List<String> result, String current, Map<String, ArrayList<String>> graph){
        while(graph.containsKey(current) && !graph.get(current).isEmpty()){
            String s = graph.get(current).remove(0);
            backtracing(result, s, graph);
        }
        result.add(0,current);
    }
}


//其实还不是很懂: https://leetcode.com/problems/reconstruct-itinerary/