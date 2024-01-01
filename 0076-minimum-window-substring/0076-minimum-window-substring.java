class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetCntMap = initializeTargetCntMap(t);
        int start = 0, end = 0, minStart = 0, sameSize = 0;
        int minLength = Integer.MAX_VALUE;
        int required = targetCntMap.size();
        Map<Character, Integer> windowCounts = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (isCharCountEqual(windowCounts, targetCntMap, c)) {
                sameSize++;
            }

            while (start <= end && sameSize == required) {
                c = s.charAt(start);
                if (updateMinLength(start, end, minStart, minLength)) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (isCharCountLess(windowCounts, targetCntMap, c)) {
                    sameSize--;
                }

                start++;
            }

            end++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    private Map<Character, Integer> initializeTargetCntMap(String t) {
        Map<Character, Integer> targetCntMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCntMap.put(c, targetCntMap.getOrDefault(c, 0) + 1);
        }
        return targetCntMap;
    }

    private boolean isCharCountEqual(Map<Character, Integer> windowCounts, Map<Character, Integer> targetCntMap, char c) {
        return targetCntMap.containsKey(c) && windowCounts.get(c).intValue() == targetCntMap.get(c).intValue();
    }

    private boolean updateMinLength(int start, int end, int minStart, int minLength) {
        return end - start + 1 < minLength;
    }

    private boolean isCharCountLess(Map<Character, Integer> windowCounts, Map<Character, Integer> targetCntMap, char c) {
        return targetCntMap.containsKey(c) && windowCounts.get(c).intValue() < targetCntMap.get(c).intValue();
    }
}
