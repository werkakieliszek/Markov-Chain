import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class TMarkov {
    private String text;
    private int k;
    private Map<String, List<String>> transitionMap;
    private Random rand;

    public TMarkov(String text, int k) {
        this.text = text;
        this.k = k;
        this.transitionMap = new HashMap<>();
        this.rand = new Random();
        buildTransitionMap();
    }

    private void buildTransitionMap() {
        for (int i = 0; i <= text.length() - k; i++) {
            String kevent = text.substring(i, i + k);
            String next = (i + k < text.length()) ? Character.toString(text.charAt(i + k)) : "";
            transitionMap.putIfAbsent(kevent, new ArrayList<>());
            transitionMap.get(kevent).add(next);
        }
    }

    public int freq(String kevent) {
        return transitionMap.getOrDefault(kevent, new ArrayList<>()).size();
    }

    public int freq(String kevent, String c) {
        List<String> nextEvents = transitionMap.getOrDefault(kevent, new ArrayList<>());
        int count = 0;
        for (String event : nextEvents) {
            if (event.equals(c)) {
                count++;
            }
        }
        return count;
    }

    public String rand(String kevent) {
        List<String> nextEvents = transitionMap.getOrDefault(kevent, new ArrayList<>());
        if (nextEvents.isEmpty()) {
            return "";
        }
        int index = rand.nextInt(nextEvents.size());
        return nextEvents.get(index);
    }

    public String gen(String kevent, int T) {
        StringBuilder result = new StringBuilder(kevent);
        String currentEvent = kevent;

        for (int i = 0; i < T - k; i++) {
            String nextEvent = rand(currentEvent);
            if (nextEvent.isEmpty()) {
                break;
            }
            result.append(nextEvent);
            currentEvent = result.substring(result.length() - k, result.length());
        }
        return result.toString();
    }
}