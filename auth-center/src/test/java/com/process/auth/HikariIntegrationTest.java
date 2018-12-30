//package com.process.auth;
//
//import com.zaxxer.hikari.HikariDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//
///**
// * @author Danfeng
// * @since 2018/12/9
// */
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HikariIntegrationTest {
//
////    @Autowired
////    private DataSource dataSource;
//
////    @Test
////    public void hikariConnectionPoolIsConfigured() {
////        System.out.println(dataSource.getClass().getName());
////
////        try {
////            int loginTimeout = dataSource.getLoginTimeout();
////            log.info("aaa",loginTimeout);
////            Connection connection = dataSource.getConnection();
////            Statement statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery("select * from oauth_client_details");
////            connection.close();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
//
//}
