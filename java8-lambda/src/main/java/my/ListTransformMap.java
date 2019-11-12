package my;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/11/12 15:06
 */
public class ListTransformMap {
    public static void main(String[] args) {
        List<UserBehavior> userBehaviors = Lists.newArrayList(
                new UserBehavior("19919912414", "APPLE", "aaaa"),
                new UserBehavior("13342406610", "VIVO", "dddd"));
        Map<String, UserBehavior> userBehaviorsMap = userBehaviors.stream().collect(Collectors.toMap(UserBehavior::getUserphone, Function.identity()));
        System.out.println("userBehaviorsMap:" + JSON.toJSONString(userBehaviorsMap));
    }
}