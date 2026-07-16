package com.wenbobi.springbootdemo;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;

@RestController
@RequestMapping("/request")
public class RequestController {
    /**
     * 接收一个参数
     * @param name
     * @return
     */
    @RequestMapping("/r1")
    public String r1(String name, HttpServletRequest request){
        String name1=request.getParameter("name");
        return "接收到参数数，name:"+name;
    }

  /**
     * 接收多个参数
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/r2")
    public String r2(String name,String password){
        return "接收到参数数，name:"+name+",password:"+password;
    }

    /**
     * 参数重命名
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/r3")
    public String r3(String name,String pwd){
        return "接收到参数数，name:"+name+",password:"+pwd;
    }

    //接受数组
    @RequestMapping("/r4")
    public String r4(String[] arr){
        return Arrays.toString(arr);
    }

    /**
     * 接收一个json字符串，并把json字符串转为Person对象
     */
    @RequestMapping("/r5")
    public String r5(@RequestBody Person person){
        return "接收到的json字符串转为Person对象："+person.toString();
    }

    @RequestMapping("/v9")
    public String r9(@RequestBody Person person) {
        return person.toString();
    }

    /**
     * 接收url中的参数
     * @param id
     * @return
     */
    @RequestMapping("/r10/{id}")
    public String r10(@PathVariable int id){
        return "从url中获取id:"+id;
    }
    @RequestMapping("/r11")
    public String r11(@RequestPart("file") MultipartFile multipartFile){//@RequestPart("file") 是前端上传的文件名，后端还是multipartFile
        System.out.println(multipartFile.getOriginalFilename());
        //文件上传
        File dest = new File("D:/java_code/Java_learning/springboot-demo/"+multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "文件上传成功";
    }
}
