package com.zzm.datasource;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zzm.datasource.aop.DynamicDataSourceAnnotationAdvisor;
import com.zzm.datasource.aop.DynamicDataSourceAnnotationInterceptor;
import com.zzm.datasource.register.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(DynamicDataSourceRegister.class)
@MapperScan("com.zzm.datasource.repository")
@SpringBootApplication
@EnableTransactionManagement
public class DatasourceApplication extends SpringBootServletInitializer {

	@Bean
	public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
		return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
	}

	@Bean//使用@Bean注入fastJsonHttpMessageConvert
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//1.需要定义一个Convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter=fastConverter;
		return new HttpMessageConverters(converter);
	}

	public static void main(String[] args) {
		SpringApplication.run(DatasourceApplication.class, args);
	}
}
