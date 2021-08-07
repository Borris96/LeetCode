/**
将遍历的元素存入哈希表，每当字母重复，则从该字母第一次出现的后一位开始遍历，并清空哈希表
更新长度
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int curLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int p = 0;
        while (p < s.length()) {
            char c = s.charAt(p);
						if (!map.containsKey(c)) {
								map.put(c, p);
                curLength += 1;
                maxLength = Math.max(maxLength, curLength);
                p++;
						} else {
								p = map.get(c) + 1;
                map = new HashMap<>();
                curLength = 0;
						}
				}
        return maxLength;
    }
}
