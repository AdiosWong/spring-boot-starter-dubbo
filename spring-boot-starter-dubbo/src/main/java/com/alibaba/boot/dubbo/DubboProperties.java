/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * xinqing@yiji.com 2017年3月31日 下午4:02:43 创建
 */

package com.alibaba.boot.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 *
 * @author xinqing@yiji.com
 *
 */
@ConfigurationProperties(DubboProperties.PREFIX)
public class DubboProperties {
	
	public static final String PREFIX = "spring.dubbo";
	
    private String applicationName;

	private String protocol;

    private String registryAddress;

    private String protocolName;

    private int protocolPort;

    private int timeout;

    private int retries;

    private int delay;

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getRegistryAddress() {
		return this.registryAddress;
	}

	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	public String getProtocolName() {
		return this.protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public int getProtocolPort() {
		return this.protocolPort;
	}

	public void setProtocolPort(int protocolPort) {
		this.protocolPort = protocolPort;
	}

	public int getTimeout() {
		return this.timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetries() {
		return this.retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	}

	public int getDelay() {
		return this.delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

}
