package test.myblog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("test.myblog.mapper")
public class MybatisConfig {
	
	public MybatisConfig() {
		System.out.println("Mybatis Configured.");
	}

}
