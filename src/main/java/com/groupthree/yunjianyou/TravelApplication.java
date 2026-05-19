package com.groupthree.yunjianyou;


import com.groupthree.yunjianyou.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.groupthree.yunjianyou.mapper")
public class TravelApplication {
    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);
        System.out.println("haha");
    }
    /**
     * 将使用雪花算法生成订单ID
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
