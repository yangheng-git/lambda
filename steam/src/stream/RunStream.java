package stream;

import com.sun.org.apache.xalan.internal.xsltc.trax.StAXStream2SAX;

import java.util.Random;
import java.util.stream.Stream;

/**
 * stream的运行机制
 * <p>
 * 1.所有操作是链式调用。一个元素只迭代一次
 * 2.每个中间操作返回一个新的流
 * 流里面有一个属性sourceStage指向同一个地方，就是Head
 * 3. Head -> nextStage -> nextSage ->... null
 * <p>
 * 4.有状态操作会把无状态操作截断。单独处理
 *
 * 5.并行环境下。有状态的中间操作不一定能并行执行
 * 6.parallel /sewuetial 这两个操作也是中间操作。（也是返回Stream）
 *      但是他们不创建流。他们只修改heard的并行标志
 * <p>
 * <p>
 * //两个参数 约等于 有状态操作
 *
 *
 *
 *
 * 总结
 * 1。惰性求值
 *  中间操作 有状态/无状态
 *  中间操作
 * 2.收集器 分组
 * 3. 运行机制
 *      链式 head->nextSage
 *     并行 fork/join 阻塞
 *
 * @author yangHX
 * createTime  2019/3/9 22:39
 */
public class RunStream {

    public static void main(String[] args) {
        Random random = new Random();
        long count = Stream.generate(random::nextInt)
                //产生500个（无限流需要短路操作)
                .limit(500)
                //第一个无状态操作
                .peek(s -> System.out.println(" peek:" + s))
                //第二个无状态操作
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s > 1000000;
                })
                //有状态操作
                .sorted((i1, i2) -> {
                    System.out.println("排序" + i1 + i2);
                    return i1.compareTo(i2);
                })
                //又一个无状态操作
                .peek(s -> {
                    System.out.println("peek2" + s);
                }).parallel()
                //终止操作
                .count();


    }
}
