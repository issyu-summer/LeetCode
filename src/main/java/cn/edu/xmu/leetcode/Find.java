package cn.edu.xmu.leetcode;

/**
 * @author summer
 * @date 2021/3/18 10:53
 */
public class Find {

    /**
     * 二分搜索
     */
    static class BinarySearch {
        /**
         * 二分搜索的循环写法
         */
        public static int binarySearch(
                int[] nums,
                int target,
                int left,
                int right) {
            while (left <= right) {
                //不要使用mid=(left+right)/2
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    return mid;
                    //比中间的小,去左边找,否则去右边找
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        /**
         * 二分搜索的递归写法
         */
        public static int recurBinarySearch(
                int []nums,
                int target,
                int left,
                int right
        ){
            if(left<=right){
                int mid=left+((right-left)>>1);
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    return recurBinarySearch(nums,target,left,mid-1);
                }else {
                    return recurBinarySearch(nums,target,mid+1,right);
                }
            }
            return -1;
        }

        /**
         * 存在返回位置,不存在返回插入位置
         */
        public static int binarySearchNonToInsert(
                int[] nums,
                int target) {
            int left=0,right=nums.length-1;
            while (left <= right) {
                //不要使用mid=(left+right)/2
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    return mid;
                    //比中间的小,去左边找,否则去右边找
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    //即为插入的位置
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] ints = {
                1, 3, 5, 6
        };
        System.out.println(Find.BinarySearch.binarySearchNonToInsert(ints,7));
    }
}
