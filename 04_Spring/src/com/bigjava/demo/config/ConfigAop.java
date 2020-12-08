package com.bigjava.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 *
 * @author LXW
 * @creat2020-11-16-上午 9:29
 */
@Configuration
@ComponentScan(basePackages = ("com.bigjava"))
@EnableAspectJAutoProxy(proxyTargetClass =  true)
public class ConfigAop {
}
