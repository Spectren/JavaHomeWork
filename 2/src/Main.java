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

    public static void third(String[] gamers) {
        String winnerName = "";
        int maxScore = 0;

        for (String player : gamers) {
            String[] playerAndScoreSplit = player.split("\\s+");

            int score = Integer.parseInt(playerAndScoreSplit[1]);
            if (maxScore < score) {
                maxScore = score;
                winnerName = playerAndScoreSplit[0];
            }
        }

        System.out.print(winnerName);
    }
}
