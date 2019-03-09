package stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 收集器
 *
 * @author yangHX
 * createTime  2019/3/9 22:20
 */
public class CollectDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //收集器
        List<String> collect = list.stream().map(s -> s + "").collect(Collectors.toList());

        //汇总信息 得出平准值之类的
        IntSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingInt(String::length));

        //分块
        Map<Boolean, List<String>> collect2 = list.stream().collect(Collectors.partitioningBy(s -> s.length() == 1));

        //分组
        Map<Integer, List<String>> collect3 = list.stream().collect(Collectors.groupingBy(String::length));
    }

}
