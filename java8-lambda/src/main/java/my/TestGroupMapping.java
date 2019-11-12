package my;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * @author duhongming
 * @version 1.0
 * @description List<UserBehavior>按照手机厂商分组，每组只取设备号
 * @date 2019/7/27 21:55
 */
public class TestGroupMapping {

    public static void main(String[] args) {
        Map<String, List<String>> equipnumGroup = Lists.newArrayList(
                new UserBehavior("19919912414", "APPLE", "aaaa"),
                new UserBehavior("19919912414", "APPLE", "bbbb"),
                new UserBehavior("19919912414", "VIVO", "cccc"),
                new UserBehavior("13342406610", "VIVO", "dddd"),
                new UserBehavior("13342406610", "XIAOMI", "eeee"),
                new UserBehavior("13342406610", "XIAOMI", "ffff")
        ).stream().collect(Collectors.groupingBy(
                UserBehavior::getMname,
                mapping(UserBehavior::getEquipnum, toList())
                )
        );
        System.out.println("equipnumGroup:" + JSON.toJSONString(equipnumGroup));
    }

}

@AllArgsConstructor

@Getter
class UserBehavior {

    /**
     * 手机号
     */

    private String userphone;

    /**
     * 手机厂商
     */

    private String mname;

    /**
     * 设备号
     */

    private String equipnum;

}