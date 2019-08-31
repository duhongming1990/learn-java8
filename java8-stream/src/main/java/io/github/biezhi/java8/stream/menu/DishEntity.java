package io.github.biezhi.java8.stream.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * @author duhongming
 * @version 1.0
 * @description 菜盘
 * @date 2019-08-31 14:28
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishEntity {
    /**
     * 菜名
     */
    private String name;
    /**
     * 是否素食
     */
    private boolean vegetarian;
    /**
     * 卡路里
     */
    private int calories;
    /**
     * 种类
     */
    private Type type;

    public enum Type{MEAT,FISH,OTHER}

    public static final List<DishEntity> menu =
            Arrays.asList(
                    new DishEntity("pork", false, 800, DishEntity.Type.MEAT),
                    new DishEntity("beef", false, 700, DishEntity.Type.MEAT),
                    new DishEntity("chicken", false, 400, DishEntity.Type.MEAT),
                    new DishEntity("french fries", true, 530, DishEntity.Type.OTHER),
                    new DishEntity("rice", true, 350, DishEntity.Type.OTHER),
                    new DishEntity("season fruit", true, 120, DishEntity.Type.OTHER),
                    new DishEntity("pizza", true, 550, DishEntity.Type.OTHER),
                    new DishEntity("prawns", false, 400, DishEntity.Type.FISH),
                    new DishEntity("salmon", false, 450, DishEntity.Type.FISH)
            );
}
