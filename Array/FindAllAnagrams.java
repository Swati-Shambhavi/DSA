import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    public static void main(String[] args) {
        // String s = "cbaebabacd", p = "abc"; //ans=0,6
        String s = "abab", p = "ab"; // ans=0,1,2
        System.out.println("main=" + s + " sub= " + p);
        System.out.println(findAnagrams(s, p));
    }

    public static List findAnagrams(String s, String p) {
        List<Integer> ana = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i))) {
                int count = map.get(p.charAt(i));
                map.put(p.charAt(i), count + 1);
            } else {
                map.put(p.charAt(i), 1);
            }
        }
        int start = 0, end = 0, count = map.size();
        int k = p.length();
        // String s = "cbaebabacd", p = "abc";
        int c = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                char current = s.charAt(end);
                int tempCount = map.get(s.charAt(end)) - 1;
                map.replace(s.charAt(end), tempCount);
                // map.replace(s.charAt(end), 0);

                if (map.get(current) == 0) {
                    count--;
                }
                // System.out.println(end + " start " + map);

            }
            if (end - start + 1 < k) {
                end++;
                continue;
            } else if (end - start + 1 == k) {
                if (count == 0) {
                    // System.out.println("Yayya" + start);
                    ana.add(start);
                    c++;
                }
                char current = s.charAt(start);
                if (map.containsKey(current)) {
                    map.replace(s.charAt(start), map.get(current) + 1);
                    // map.replace(s.charAt(start), 1);
                    if (map.get(s.charAt(start)) > 0)
                        count++;
                }
                // System.out.println(end + " end " + map);
                start++;
                end++;

            }
        }
        return ana;
    }
}
