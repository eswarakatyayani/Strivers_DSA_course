class Solution {    
    public int numberOfSubstrings(String s) {
        int n = s.length();
        // lastSeen[0] -> 'a', lastSeen[1] -> 'b', lastSeen[2] -> 'c'
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        for (int i = 0; i < n; i++) {
            // update last seen index
            lastSeen[s.charAt(i) - 'a'] = i;
            // if all three characters are seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // add 1 + minimum of last seen positions
                count += 1 + Math.min(
                        lastSeen[0],
                        Math.min(lastSeen[1], lastSeen[2])
                );
            }
        }
        return count;
    }
}
