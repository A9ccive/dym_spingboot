package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AwcServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AwcServerApplication.class, args);
    System.out.println("===========================");
    System.out.println("awc-server startup success！");
    System.out.println("===========================");
  }
}
