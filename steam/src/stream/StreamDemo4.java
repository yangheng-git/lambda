package stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream流操作 终止操作
 *
 * @author yangHX
 * createTime  2019/3/6 21:56
 */
public class StreamDemo4 {

    public static void main(String[] args) {
        String str = "my name is 007";
        //并行流是没有顺序的
        str.chars().parallel().forEach(i -> System.out.print((char) i));
        //有顺序的并行流
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));

        List<IntStream> collect = Stream.of(str.chars()).collect(Collectors.toList());
        System.out.println(collect);

        //使用reduce 拼接字符串
        Optional<String> reduce = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce.orElse(""));

        //设置初始值 “”
        String reduce1 = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce1);

        //计算字符串的长度
        Integer length = Stream.of(str.split(" ")).map(String::length).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);


        /*短路操作*/

        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());

    }
}
