class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxA = 0;
        
        while (i < j) {
            // 水的高度取决于容器较矮的那条垂直线
            int h = Math.min(height[i] , height[j]);
            int area = (j - i) * h;
            maxA = Math.max(maxA, area);
            
            // 因为水的高度取决于较低的容器，所以移动较低的那边指针才可能使容器水量增加
            // 移动较低的那边，找到比 h 高一些的垂直线
            while (height[i] <= h && i < j) {
                i++;
            }
            while (height[j] <= h && i < j) {
                j--;
            }
        }
        
        return maxA;
    }
}
