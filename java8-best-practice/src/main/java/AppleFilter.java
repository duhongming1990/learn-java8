import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 第二章 通过行为参数化传递代码
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2019/4/20 10:49
 */

public class AppleFilter {
    @Getter
    @Setter
    class Apple{
        private String color;
        private int weight;
    }

    @Test
    public void testFilterGreenApples() {
    }

    /**
     * 1 初试牛刀：筛选绿苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenAples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 2 再展身手：把颜色作为参数
     *
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 2 再展身手：把重量作为参数
     *
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 3 第三次尝试：对你能想到的每个属性做筛选
     *
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getWeight() > weight) || (flag && color.equals(apple.getColor()))) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 4 第四次尝试：根据抽象条件筛选
     *
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }

    public class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return false;
        }
    }

    public class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return false;
        }
    }


    /**
     * 5 第五次尝试：使用匿名类
     */
    @Test
    public void testFilterApples() {
        filterApples(new ArrayList<>(), new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return false;
            }
        });
    }

    /**
     * 6 第六次尝试：使用Lambda表达式
     */
    @Test
    public void testLambda() {
        AppleFilter.filterApples(new ArrayList<>(),(Apple a)-> "red".equals(a.getColor()));
    }



    /**
     * 7 第七次尝试：将List类型抽象化
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list,Predicte<T> p){
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;

    }

    public interface Predicte<T> {
        boolean test(T t);
    }




}