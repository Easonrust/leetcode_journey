import java.util.*;

public class App {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyForChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyForChar.put(s.charAt(i), frequencyForChar.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char key : frequencyForChar.keySet()) {
            int frequency = frequencyForChar.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        ArrayList<Character> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (int j = 0; j < buckets[i].size(); j++) {
                for (int m = 0; m < i; m++) {
                    resultList.add(buckets[i].get(j));
                }
            }
        }
        char[] resultArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            resultArray[i] = resultList.get(i);
        }
        String result = new String(resultArray);
        return result;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.frequencySort("tree"));
    }
}
