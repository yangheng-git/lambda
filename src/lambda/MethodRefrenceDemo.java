package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;


class Dog {
    private String name = "哮天犬";

    /**
     * 默认10斤狗粮
     */
    private int food = 10;


    public Dog() {
    }

    /**
     * 带参数的构造函数
     *
     * @param name
     */
    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * 吃狗粮
     *
     * @param num 数量
     * @return 还剩下多少斤
     * <p>
     * <p>
     * jdk默认会把当前实例传入到非静态方法。 参数名为this。 位置是第一个
     */
    public int eat(Dog this, int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}


/**
 * 函数引用
 *
 * @author yangHX
 * createTime  2019/3/3 10:09
 */
public class MethodRefrenceDemo {

    public static void main(String[] args) {

        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("接受字符串");

        //静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        Dog dog = new Dog();
        consumer2.accept(dog);

        //非静态方法。使用对象实例的方法引用
///        Function<Integer, Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
//        System.out.println("还剩下" + function.apply(2) + "斤");
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");


        /*
         * 静态方法和非静态方法的区别
         * 静态方法没有this  非静态方法有this .当前对象
         *
         */
        //直接用类名引用非静态方法
        //有两个入参 一个返回值
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤");

        //构造函数的方法引用
        //使用默认构造函数。 创建提供者
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象" + supplier.get());

        //带参数的构造函数
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象" + function2.apply("旺财"));


        //可以通过查看字节码本地变量表的方法。看到jdk会把当前对象示例加入每一个非静态方法


        //java的传值引用

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");

        test(strings);
        System.out.println(strings);
        ///[1, 1, 1, 1]

    }


    private static void test(List<String> list) {
        list = null;
    }
}
