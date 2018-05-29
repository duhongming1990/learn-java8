package io.github.biezhi.java8.lambda.lesson1.predicate;

import io.github.biezhi.java8.lambda.lesson1.Project;

/**
 * 项目过滤接口
 *
 * @author biezhi
 * @date 2018/2/9
 */
public interface ProjectPredicate {

    boolean test(Project project);

}
