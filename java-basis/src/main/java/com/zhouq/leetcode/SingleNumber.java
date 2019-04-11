package com.zhouq.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了2次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 */
public class SingleNumber {
    public static void main(String[] args) {

        Assert.assertEquals(0, singleNumber2(new int[]{}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 1, 3, 2, 2}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 3, 1, 2, 4, 2, 4}));
        Assert.assertEquals(3, singleNumber2(new int[]{1, 4, 2, 3, 2, 4, 1}));
    }

    /**
     * 利用外部计数的方式
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {

        HashMap<Integer, Integer> tmpMap = new HashMap<Integer, Integer>(nums.length);

        for (int num : nums) {
            Integer value = tmpMap.get(num);
            tmpMap.put(num, value != null ? value + 1 : 1);
        }

        for (Map.Entry<Integer, Integer> entry : tmpMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }


    /**
     * 题目给的是只有一个出现了一次，其他的都出现了2两次。
     * 那么按照步数为 2  进行遍历，如果是一个数字的，就必然会出现 i ！= i + 1 的情况
     */
    public static int singleNumber2(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 >= nums.length) {
                return nums[i];
            }

            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }


    public  int singleNumber3(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
            System.out.println(res);
        }
        return res;
    }

    @Test
    public void tes (){
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        singleNumber3(nums);
    }


}
