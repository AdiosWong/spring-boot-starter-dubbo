/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * xinqing@yiji.com 2017年3月31日 下午4:37:46 创建
 */

package com.alibaba.boot.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

/**
 *
 *
 * @author xinqing@yiji.com
 *
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {
	
	@Autowired
	private DubboProperties properties;
	
    /**
     * 设置dubbo扫描包
     * @param packageName
     * @return
     */
    @Bean
    public static AnnotationBean annotationBean(@Value("${spring.dubbo.scan}") String scan) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(scan);
        return annotationBean;
    }
	
	/**
	 * 注入dubbo上下文
	 * 
	 * @return
	 */
	@Bean
	public ApplicationConfig applicationConfig() {
		// 当前应用配置
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(properties.getApplicationName());
		return applicationConfig;
	}
	
	/**
	 * 注入dubbo注册中心配置,基于zookeeper
	 * 
	 * @return
	 */
	@Bean
	public RegistryConfig registryConfig() {
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol(properties.getProtocol());
		registry.setAddress(properties.getRegistryAddress());
		return registry;
	}
	
	/**
     * 默认基于dubbo协议提供服务
     * 
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(properties.getProtocolName());
        protocolConfig.setPort(properties.getProtocolPort());
        protocolConfig.setThreads(200);
        return protocolConfig;
    }
    
	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setTimeout(properties.getTimeout());
		providerConfig.setCluster("failfast");
		//设置延迟暴露,dubbo会用另外一个线程来暴露服务,加快启动过程
		providerConfig.setDelay(1);
		return providerConfig;
	}
	
}
