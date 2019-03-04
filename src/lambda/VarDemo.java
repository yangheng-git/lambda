package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 *
 * @author yangHX
 * createTime  2019/3/4 22:07
 */
public class VarDemo {


    public static void main(String[] args) {
        //lambda 中的变量是final的。 即 匿名类应用外部变量。必须是final
        String str = "我们的时间";
        Consumer<String> tConsumer = s -> System.out.println(s + str);
        tConsumer.accept("rerwer");



        List<String> list = new ArrayList<>();
//        list=null;
//
//        List<String> finalList = list;
        Consumer<String> consumer = s -> System.out.println(s + list);
        consumer.accept("1212");


    }
}
