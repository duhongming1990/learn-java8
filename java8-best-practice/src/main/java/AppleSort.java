import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class AppleSort {
    List<Apple> inventory = new ArrayList<>();
    @Getter
    @Setter
    class Apple {
        private String color;
        private Integer weight;
    }

    /**
     * 1 第一步：传递代码
     */
    @Test
    public void testAppleCompare(){
        inventory.sort(new AppleComparator());
    }

    public class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }

    /**
     * 2 第二步：使用匿名内部类
     */
    @Test
    public void testAppleCompareByInnerClass(){
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    /**
     * 3 第三步：使用Lambda表达式
     */
    @Test
    public void testAppleCompareByLambda(){
        inventory.sort((Apple o1, Apple o2) ->o1.getWeight().compareTo(o2.getWeight()));
        inventory.sort((o1,o2) -> o1.getWeight().compareTo(o2.getWeight()));
        inventory.sort(comparing((Apple a) -> a.getWeight()));
        inventory.sort(comparing((a) -> a.getWeight()));
    }

    /**
     * 4 第四步：使用方法引用
     */
    @Test
    public void testAppleCompareByLambdaPlus(){
        inventory.sort(comparing(Apple::getWeight));
    }



}
