package io.github.biezhi.java8.stream.menu;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author duhongming
 * @version 1.0
 * @description 流式菜单搜索
 * @date 2019-08-31 14:31
 */
public class MenuSearchDemo {
    public static void main(String[] args) {
        List<DishEntity> menu = DishEntity.menu;
        List<String> names = menu.stream()
                //过滤掉小于300卡路里的菜
                .filter((d) -> d.getCalories() > 300)
                //按照卡路里默认ASC排序/reversed()方法 DESC排序
                .sorted(comparing(DishEntity::getCalories).reversed())
                //获取菜名
                .map(DishEntity::getName)
                //取前三个
                .limit(3)
                //去重
                .distinct()
                //按照List收集
                .collect(toList());
        System.out.println(names);
    }
}
