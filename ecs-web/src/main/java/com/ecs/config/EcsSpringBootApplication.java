package com.ecs.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@Slf4j
@EnableAsync
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableRedisHttpSession(redisNamespace="session:dfs:mo", maxInactiveIntervalInSeconds=1200)
@EnableAutoConfiguration(exclude={FreeMarkerAutoConfiguration.class})
public class EcsSpringBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EcsSpringBootApplication.class);
	}

	public static void main(String[] args) {

		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");

		SpringApplication.run(EcsSpringBootApplication.class, args);
	}
}

