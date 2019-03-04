package stream;

import java.util.stream.IntStream;

/**
 * stream流 概念
 *
 * @author yangHX
 * createTime  2019/3/4 22:43
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //外部迭代
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("外部迭代 结果为" + sum);

        //使用stream的内部迭代
        int sum1 = IntStream.of(nums).sum();
        System.out.println("内部迭代 结果为"+sum1);


    }
}
