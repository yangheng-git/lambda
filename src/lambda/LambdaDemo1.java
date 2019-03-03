package lambda;

/**
 * @author yangHX
 * createTime  2019/3/3 9:38
 * FunctionalInterface java8函数式接口。 声明为函数接口。
 * 函数接口中只能有一个【需要被实现】的方法。  单一责任制
 * <p>
 * 这样使用lambda 更加方便
 */
@FunctionalInterface
interface Interface1 {

    /**
     * *2
     * 需要被实现的接口。 是函数式接口的函数方法
     *
     * @param i 参数
     * @return int
     */
    int doubleNum(int i);


    /**
     * java8接口的默认实现方法
     *
     * @param x x
     * @param y y
     * @return int
     */
    default int add(int x, int y) {
        return x + y;
    }
}


@FunctionalInterface
interface Interface2 {

    /**
     * *2
     * 需要被实现的接口。 是函数式接口的函数方法
     *
     * @param i 参数
     * @return int
     */
    int doubleNum(int i);


    /**
     * java8接口的默认实现方法
     *
     * @param x x
     * @param y y
     * @return int
     */
    default int add(int x, int y) {
        return x + y;
    }
}


@FunctionalInterface
interface Interface3 extends Interface1, Interface2 {
    /**
     * 两个父接口都有add方法。 要指明调用哪一个接口的父方法。
     *
     * @param x x
     * @param y y
     * @return   Interface1.super.add(x, y);
     */
    @Override
    default int add(int x, int y) {
        return Interface1.super.add(x, y);
    }
}


/**
 * @author yangHX
 * createTime  2019/3/3 9:38
 */
public class LambdaDemo1 {


    public static void main(String[] args) {
        /*常见的4种写法*/


        Interface1 i1 = (i) -> (i * 2);
        Interface1 i2 = i -> (i * 2);
        Interface1 i3 = (int i) -> i * 2;
        Interface1 i4 = (int i) -> {
            System.out.println("_____");
            return i * 2;
        };


        System.out.println(i1.add(1, 3));

    }
}
