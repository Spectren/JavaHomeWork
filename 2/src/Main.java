import java.util.*;

public class Main {
    public static<T> Collection<T> first(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public static <Key, Val> Map<Val, Collection<Key>> second(Map<? extends Key, ? extends Val> map) {
        Map<Val, Collection<Key>> invertMap = new TreeMap<>();
        Set<? extends Key> keyMap = map.keySet();

        for (Key key : keyMap) {
            Val value = map.get(key);
            invertMap.compute(value, (v, k) -> {
                if (k == null) {
                    k = new TreeSet<>();
                }
                k.add(key);
                return k;
            });
        }
        return invertMap;
    }

    public static String third(String[] entries) {
        HashMap<String, Integer> scores = new HashMap<>();
        String winner_name = "-";
        int winner_score = 0;
        for (String entry : entries) {
            String[] e = entry.split(" ");
            String name = e[0];
            int score = Integer.parseInt(e[1]);
            int prev_score = scores.getOrDefault(name, 0);
            int cur_score = prev_score + score;
            scores.put(name, cur_score);
            if (cur_score > winner_score) {
                winner_score = cur_score;
                winner_name = name;
            }
        }
        return winner_name;
    }

}
