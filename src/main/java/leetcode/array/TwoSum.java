package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;


/**
 Given an array of intergers, find two numbers such that they add up to a specific target number. The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 题目翻译： 这道题目的意思是给定一个数组和一个值，让求出这个数组中两个值的和等于这个给定值的坐标。输出是有要求的，1， 坐标较小的放在前面，较大的放在后面。2， 这俩坐标不能为零。

 题目分析： 第一步： 我们要分析题意，其中有三个关键点：

 求出来的坐标值要按序排列。
 这两个坐标不能从零开始。
 这道题目假设是只有一组答案符合要求，这样降低了我们解题的难度。
 根据题目我们可以得到以下信息：

 我们得到坐标的时候，要根据大小的顺序放入数组。
 因为坐标值不能为零，所以我们得到的坐标都要+1。
 因为有且只有一组答案符合要求，所以这大大的降低了这道题目的难度，也就是说，我们只要找到符合条件的两个数，存入结果，直接终止程序，返回答案即可。
 解题思路： 这道题不是很难，是leetcode最开始的题目，要求很明确，很直接，如果我们用两个for循环，O(n2)的时间复杂度去求解的话，很容易计算出来，但这明显不是面试官需要的答案。brute force只有在你不知道如何优化题目的时候，将就的给出的一个解法。。那么我们能不能用O(n)的时间复杂度去解这道题呢？很显然是可以的，不过，天下没有掉馅饼的事情啦，既然优化了时间复杂度，我们就要牺牲空间复杂度啦。在这里用什么呢？stack？queue？vector？还是hash_map?

 对于stack和queue，除了pop外，查找的时间复杂度也是O(n)。明显不是我们所需要的，那么什么数据结构的查找时间复杂度小呢？很显然是 hash_map, 查找的时间复杂度理想情况下是O(1)。所以我们先来考虑hash_map，看看hash_map怎么求解这个问题。

 我们可以先把这个数组的所有元素存到hashmap中，一次循环就行， 时间复杂度为O(n),之后对所给数组在进行遍历，针对其中的元素我们只要用another_number = target-numbers[i],之后用hashmap的find function来查找这个值，如果存在的话，在进行后续比较（详见代码），如果不存在的话，继续查找，好啦，思路已经摆在这里了，详见代码吧。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                int index = map.get(num);
                if (index == i) {
                    continue;
                } else if (index < i) {
                    result[0] = index + 1;
                    result[1] = i + 1;
                    return result;
                } else {
                    result[0] = i + 1;
                    result[1] = index + 1;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] inputArray = new int[] {1, 3, 6, 5, 3};

        System.out.println(Arrays.toString(twoSum.twoSum(inputArray, 10)));

    }
}

