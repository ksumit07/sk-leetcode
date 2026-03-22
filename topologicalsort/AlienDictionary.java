package topologicalsort;

import java.util.*;

public class AlienDictionary {
    

    public String alienOrder(String[] words) {
        // TODO: Implement here

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String w: words){
            for(char c: w.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i=0; i<words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w2.length() < w1.length() && w1.startsWith(w2)) return "";

            for(int j=0; j<Math.min(w1.length(), w2.length()); j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2){
                    if(!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c: indegree.keySet()){
            if(indegree.get(c) == 0){
                q.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();  
            res.append(c);
            for(char neighbor: graph.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        //cycle check
        if(res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }

    public static void main(String[] args) {

        AlienDictionary sol = new AlienDictionary();

        runTest(sol, new String[]{"wrt","wrf","er","ett","rftt"}, "wertf");
        runTest(sol, new String[]{"z","x"}, "zx");
        runTest(sol, new String[]{"z","x","z"}, ""); // cycle
        runTest(sol, new String[]{"abc","ab"}, ""); // invalid prefix
        runTest(sol, new String[]{"ab","ac"}, "any"); // multiple valid answers
        runTest(sol, new String[]{"a"}, "a");
        runTest(sol, new String[]{"abc","bcd","cde"}, "any");
    }

    private static void runTest(AlienDictionary sol, String[] words, String expected) {
        String result = sol.alienOrder(words);

        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);

        if (expected.equals("any")) {
            System.out.println("Check: " + (result.length() > 0 ? "PASS (any valid)" : "FAIL"));
        } else {
            System.out.println("Check: " + (result.equals(expected) ? "PASS" : "FAIL"));
        }

        System.out.println("--------------------------------------------------");
    }
}
