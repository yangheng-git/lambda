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
        System.out.println("内部迭代 结果为" + sum1);

        //中间操作。终止操作 。 惰性求直播
        //map就是中间操作。（返回stream的操作）
        //sum 就是终止操作
///       int sum2 = IntStream.of(nums).map(i -> i * 2).sum();
        int sum2 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
        System.out.println(sum2);

        System.out.println("惰性操作。就是终止没有掉用的情况下。中间操作不会执行");
        IntStream intStream = IntStream.of(nums).map(StreamDemo1::doubleNum);

    }

    private static int doubleNum(int i) {
        System.out.println("执行了x2");
        return i * 2;

    }


}
