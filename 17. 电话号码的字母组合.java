class Solution {
    public List<String> letterCombinations(String digits) {
		LinkedList<String> res = new LinkedList<String>();
		if(digits.isEmpty()) return res;
		
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "qprs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        // BFS
        res.add("");
        // 当所有数字还未拼接完成执行循环
		while(res.peek().length() != digits.length()){
			String pString = res.remove(); // 需要拼接组合的字符串
            int i = digits.charAt(pString.length())-'0';
            String cString = map.get(i);
			for(char c: cString.toCharArray()){
				res.addLast(pString+c);
			}
		}
		return res;
	}
}
