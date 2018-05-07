package io.github.biezhi.java8.growing.jdk5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2018/5/7 21:08
 */
public class Introspector {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        IntrospectorBean introspectorBean = new IntrospectorBean("name","describe");

        //内省是Java语言对Bean类属性、事件的一种缺省处理方法。
        BeanInfo tBeanInfo = java.beans.Introspector.getBeanInfo(introspectorBean.getClass());
        PropertyDescriptor[] propertyDescriptors = tBeanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            Method getter = property.getReadMethod();
            Object value = getter.invoke(introspectorBean);
            System.out.println("key = " + key + ";value = " + value);
        }
    }
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class IntrospectorBean{
    private String name;
    private String describe;
}
