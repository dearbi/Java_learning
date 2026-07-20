package com.wenbobi.springiocdemo1;

import com.wenbobi.springiocdemo1.controller.UserController;
import com.wenbobi.springiocdemo1.model.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocDemo1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocDemo1Application.class, args);

        //适用场景：该类型只有一个对象
        UserController bean = context.getBean(UserController.class);
        System.out.println(bean);
        bean.print();
//
//		UserController bean1 = (UserController) context.getBean("aa");
//		bean1.print();
//		Sys tem.out.println(bean1);
//
//		UserController bean2 = context.getBean(UserController.class, "userController");
//		System.out.println(bean2);

        //适用场景：该类型有多个对象
//		UserService bean = context.getBean(UserService.class);
//		bean.print();
//
//		UserRepository bean1=context.getBean(UserRepository.class);
//		bean1.print();
//
//		UserComponent bean2=context.getBean(UserComponent.class);
//		bean2.print();
//
//		UserConfiguration bean3=context.getBean(UserConfiguration.class);
//		bean3.print();

//		UserInfo bean4=context.getBean("userInfo",UserInfo.class);
//		System.out.println(bean4);
//		UserInfo bean5=context.getBean("userInfo2",UserInfo.class);
//		System.out.println(bean5);
//
//		UserInfo bean6=(UserInfo) context.getBean("userInfo");
//		System.out.println(bean6);
    }

}
