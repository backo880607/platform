package com.pisces.platform.application;

import com.pisces.framework.core.utils.AppUtils;
import com.pisces.framework.rds.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 应用程序
 *
 * @author jason
 * @date 2022/12/07
 */
//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.pisces"})
@MapperScan(basePackages = {"com.pisces.**.dao", "com.pisces.**.dao.impl"})
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        AppUtils.setContext(app.run(args));
    }
}
