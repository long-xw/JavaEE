package com.bigjava.factorybean;

import com.bigjava.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author LXW
 * @creat2020-11-13-下午 12:56
 */
public class MyBean implements FactoryBean<Course> {

    //定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
