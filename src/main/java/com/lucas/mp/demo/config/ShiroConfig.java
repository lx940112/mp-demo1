package com.lucas.mp.demo.config;

import com.lucas.mp.demo.shiro.CustomRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuxu
 */
@Configuration
public class ShiroConfig {

    /**
     * 注入自定义的realm，告诉shiro如何获取哦用户信息来做登录或权限控制
     *
     * @return 自定义的realm
     */
    @Bean
    public Realm realm() {
        return new CustomRealm();
    }

    /**
     * 这里统一做鉴权，判断哪些请求路径需要用户登录，哪些不需要
     * 此处只做鉴权不做权限控制，权限控制用注解来做
     * @return DefaultShiroFilterChainDefinition
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        // 哪些请求可以匿名访问
        chain.addPathDefinition("/auth/login", "anon");
        chain.addPathDefinition("/test/**", "anon");

        // swagger2资源的放行
        chain.addPathDefinition("/swagger-ui.html", "anon");
        chain.addPathDefinition("/webjars/springfox-swagger-ui/**", "anon");
        chain.addPathDefinition("/swagger-resources/**", "anon");
        chain.addPathDefinition("/v2/api-docs/**", "anon");

        // 除了以上请求外，其他请求都需要登录
        chain.addPathDefinition("/**", "authc");
        return chain;
    }

    /**
     * setUsePrefix(true)用于解决一个奇怪的bug。
     * 在引入spring aop 的情况下
     * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致放回404
     * 加入这项配置能解决这个bug
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

}
