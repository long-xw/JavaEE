package com.bigjava.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LXW
 * @creat2020-11-13-下午 8:07
 */

@Configuration      //作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.bigjava"})
public class SpringConfig {

}
