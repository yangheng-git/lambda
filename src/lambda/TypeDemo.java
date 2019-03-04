package lambda;


@FunctionalInterface
interface IMath23 {

    int add2(int x, int y);
}


@FunctionalInterface
interface IMath {

    int add(int x, int y);
}

/**
 * 类型推断
 *
 * @author yangHX
 * createTime  2019/3/4 21:57
 */
public class TypeDemo {

    public static void main(String[] args) {

        //变量类型定义
        IMath lambda = (x, y) -> x + y;
        //数组里
        IMath[] lambdas = {(x, y) -> x + y};

        //强转
        Object lambda2 = (IMath) (x, y) -> x + y;

        //通过返回类型
        IMath createLambda = createLambda();

        TypeDemo typeDemo = new TypeDemo();
//        IMath test = typeDemo.test((x, y) -> x + y);
        //当有二义性时。 使用强转对应的接口解决
        IMath test2 = typeDemo.test((IMath) (x, y) -> x + y);
        IMath test3 = typeDemo.test((IMath23) (x, y) -> x + y);


    }

    private IMath test(IMath iMath) {
        return null;
    }

    /**
     * 重载。 会出现无法匹配的问题
     *
     * @param iMath
     * @return
     */
    private IMath test(IMath23 iMath) {
        return null;
    }

    private static IMath createLambda() {
        return (x, y) -> x + y;
    }
}
