package com.ignovate.configuration;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.ignovate.common.FileStorageProperties;

@Configuration
@EnableConfigurationProperties({ FileStorageProperties.class })
public class IgnovateConfiguration {

	@Bean
	@Primary
	public DozerBeanMapper dozerBeanMapper() {
		return new DozerBeanMapper(Arrays.asList("ign-dozer-config.xml"));
	}
}
