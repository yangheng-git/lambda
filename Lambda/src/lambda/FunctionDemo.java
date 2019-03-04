package lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author yangHX
 * createTime  2019/3/3 10:04
 */
public class FunctionDemo {

    public static void main(String[] args) {
        //断言函数接口
        Predicate<Integer> predicate = i -> i > 0;
        System.out.println(predicate.test(-9));
        //指明类型的断言函数接口
        IntPredicate intPredicate = i -> i > 0;



        //消费函数接口
        Consumer<String> consumer = s -> System.out.println("消费:  " + s);
        consumer.accept("输入的数据");


    }

}
