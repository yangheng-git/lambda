package lambda;

import java.util.function.Function;

/**
 * 级联表达式 和柯里化
 *
 * @author yangHX
 * createTime  2019/3/4 22:13
 */
public class CurryDemo {

    /**
     * 级联表达式   x -> y -> x+y
     * 柯里化 ： 把多个参数的函数转换为只有一个参数的函数
     * 柯里化的目的： 函数标准化 【更方便统一处理】
     * 高阶函数 : 返回函数的函数
     */
    public static void main(String[] args) {

//        x -> y -> x + y;
        //级联表达式 实现了x+y 的效果
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;
//        Function<Integer, Integer> apply = fun.apply(12);

        Integer apply = fun.apply(12).apply(3);
        System.out.println(apply);

        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x + y + z;
        Integer apply1 = fun2.apply(1).apply(2).apply(3);
        System.out.println(apply1);


        /*柯里化的用法。循环*/
        int[] nums = {2, 3, 4};
        Function function = fun2;

        for (int num : nums) {
            if (function instanceof Function) {
                Object obj = function.apply(num);
                if (obj instanceof Function) {
                    function = (Function) obj;
                } else {
                    System.out.println("调用结束： 结果为" + obj);
                }
            }
        }


    }
}
