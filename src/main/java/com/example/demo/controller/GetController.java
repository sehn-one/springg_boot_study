package com.example.demo.controller;


import com.example.demo.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(method= RequestMethod.GET, path = "/getMethod")
    public String getRequest(){
        return "Hi";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd){
        System.out.println("id:"+id);
        System.out.println("password:"+pwd);
        return id+pwd;
    }
    // public String getMultiParameter(@RequestParam String id,) => 이렇게 파라메터가 많게 되는 경우는 모델을 쓴다
    @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        return "success";
    }
}
