package my;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * @author duhongming
 * @version 1.0
 * @description List<User>按照id分组，每组取top3
 * @date 2019-09-13 09:55
 */
public class TestGroupLimit {

    public static void main(String[] args) {

        Map<Integer, List<User>> userGroup = Lists.newArrayList(
                new User(1, "dhm"),
                new User(1, "dhm"),
                new User(1, "dhm"),
                new User(1, "dhm"),
                new User(2, "dhm2"),
                new User(2, "dhm2"),
                new User(2, "dhm2"),
                new User(2, "dhm2")
        ).stream().collect(
                //按照id分组
                groupingBy(User::getId,
                        //分组后每组取top3
                        collectingAndThen(toList(), e -> e.stream().limit(3).collect(toList())
                        )
                )

        );
        System.out.println("userGroup:" + JSON.toJSONString(userGroup));
    }

}


@AllArgsConstructor
@Getter
class User {

    private Integer id;

    private String name;

}