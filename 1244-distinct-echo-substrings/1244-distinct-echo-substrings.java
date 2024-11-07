import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> seen = new HashSet<>();
        for (int length = 1; length <= text.length() / 2; length++) {
            for (int i = 0; i + 2 * length <= text.length(); i++) {
                String firstHalf = text.substring(i, i + length);
                String secondHalf = text.substring(i + length, i + 2 * length);
                if (firstHalf.equals(secondHalf)) {
                    seen.add(firstHalf + firstHalf);
                }
            }
        }
        
        return seen.size();
    }
}
