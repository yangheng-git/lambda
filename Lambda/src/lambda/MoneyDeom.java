package lambda;


import java.text.DecimalFormat;
import java.util.function.Function;

interface IMoneyFormat {


    String format(int i);
}

class MyMoney {

    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }


    public void printMoney(IMoneyFormat moneyFormat) {
        System.out.println("我的存款" + moneyFormat.format(this.money));
    }

    /**
     * jdk8 函数式接口。 输入时Integer 输出是String
     *
     * @param moneyFormat
     */
    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println("我的存款" + moneyFormat.apply(this.money));
    }
}


/**
 * @author yangHX
 * createTime  2019/3/3 9:56
 */
public class MoneyDeom {

    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(32322);

//        myMoney.printMoney(i -> new DecimalFormat("#,###").format(i));
        myMoney.printMoney((IMoneyFormat) i -> new DecimalFormat("#,###").format(i));
        myMoney.printMoney((Function<Integer, String>) i -> new DecimalFormat("#,###").format(i));
    }

}

