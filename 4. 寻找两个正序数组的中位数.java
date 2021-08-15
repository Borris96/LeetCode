class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      // 方法1 O(m + n)
        if (nums1 == null || nums1.length == 0) {
            return getMedian(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return getMedian(nums1);
        }
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i = i + 1;
            } else {
                nums[k] = nums2[j];
                j = j + 1;
            }
            k++;
        }

        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }

        return getMedian(nums);
    }

    private double getMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            return (double)(nums[nums.length / 2 - 1] +nums[nums.length/2])/2;
        } else {
            return (double)nums[nums.length / 2];
        }
    }

  // 方法2 O(log(m + n))
    int len1 = nums1.length;
    int len2 = nums2.length;
    int midLine = (len1 + len2 + 1) / 2;

    int left = 0;
    int right = len1;
    while (left < right) {
        int mid1 = right + (right - left + 1) / 2;
        int mid2 = midLine - mid1;
        if (nums1[mid1 - 1] > nums2[mid2]) {
            right = mid1 - 1;
        } else {
            left = mid1;
        }
    }

            int i = left;
            int j = midLine - i;

            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = i == len1 ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = j == len2 ? Integer.MAX_VALUE : nums2[j];

            if (((len1 + len2) % 2) == 1) {
                return Math.max(nums1LeftMax, nums2LeftMax);
            } else {
                return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
            }
    }
}
