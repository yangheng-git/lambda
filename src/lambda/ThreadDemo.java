package lambda;

import java.util.Objects;

/**
 * @author yangHX
 * createTime  2019/3/3 9:35
 */
public class ThreadDemo {


    public static void main(String[] args) {
        Object runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable) runnable).start();

        Runnable ok = () -> System.out.println("ok");


    }
}
