// 描述
// 给一个升序的数组，以及一个target，找到它在数组中出现的次数。

// 样例
// 样例1：

// 输入：[1,3,3,4,5]和target= 3，
// 输出：2。
// 样例2：

// 输入：[2,2,3,4,6]和target= 4，
// 输出：1。
// 样例3：

// 输入：[1,2,3,4,5]和target= 6，
// 输出：0。
// 挑战
// 时间复杂度在O(logn)内

// 算法：二分
// 代码思路
// 找到第一个出现的位置first
// 设置左边界为0，有边界为ALen - 1

// 对于mid所指向的数，若A[mid] >= target，即target在mid或者左侧，则right = mid,否则left = mid

// 判断A[left]是否等于target，若等于first = left，再判断A[left]是否等于target，若等于first = right，注意一定要先判A[left]，因为A[right]可能也等于target，但不是第一个位置。若两者都不等于则说明数组中没有target，返回0

// 找到最后一个出现的位置last
// 设置左边界为0，有边界为ALen - 1

// 对于mid所指向的数，若A[mid] <= target，即target在mid或者右侧，则left = mid,否则right = mid

// 不断重复 2 直到 left + 1 == right 退出

// 判断A[right]是否等于target，若等于返回right，否则返回left，注意一定要先判A[right]，因为A[left]可能也等于target，但不是最后的位置；这边不需要考虑是否target的存在性，因为在寻找第一个出现位置时已经判断过

// 最后计算位置差值last - first + 1即出现次数，并将其返回
// 复杂度分析
// N表示数组A长度

// 空间复杂度：O(1)

// 时间复杂度：O(logN)

public class Solution {

    /**

     * @param A: A an integer array sorted in ascending order

     * @param target: An integer

     * @return: An integer

     */

    public int totalOccurrence(int[] A, int target) {

        if (A == null || A.length == 0){

            return 0;

        }

        int first = 0, last = 0;

        //寻找第一次出现的位置

        int left = 0, right = A.length - 1;

        while (left + 1 < right){

            int mid = left + (right - left) / 2;

            if (A[mid] >= target){

                right = mid;

            }else{

                left = mid;

            }

        }

        if (A[left] == target){

            first = left;

        }else if (A[right] == target){

            first = right;

        //若找不到直接返回0

        }else{

            return 0;

        }

        //寻找最后一次出现的位置

        left = 0; right = A.length - 1;

        while (left + 1 < right){

            int mid = left + (right - left) / 2;

            if (A[mid] <= target){

                left = mid;

            }else{

                right = mid;

            }

        }

        //注意与first的判断顺序有别，要先判右侧的

        if (A[right] == target){

            last = right;

        }else if (A[left] == target){

            last = left;

        }

        

        return last - first + 1;

    }

}