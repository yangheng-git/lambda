package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的创建
 *
 * @author yangHX
 * createTime  2019/3/4 22:58
 */
public class StreamDemo2 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //从集合创建
        list.stream();
        //并行流
        list.parallelStream();


        //从数组创建
        Arrays.stream(new int[]{2, 3, 4});

        //创建你数字流
        IntStream.of(12, 2, 3);
        //创建1-10的数字流
        IntStream.rangeClosed(1, 10);


        //使用random 创建一个无限流
        new Random().ints().limit(10);

        //自己创建
        Random random = new Random();
        //创建无限流
        Stream<Integer> limit = Stream.generate(() -> random.nextInt()).limit(20);
        Stream<Integer> limit2 = Stream.generate(random::nextInt).limit(20);
    }
}
