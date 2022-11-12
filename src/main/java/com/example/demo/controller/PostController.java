package com.example.demo.controller;

import com.example.demo.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    @PostMapping(value = "/postMethod", produces = {"application/json", "text/plain"})
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping("/put")
    public void put(){}
    @PatchMapping("patch")
    public void patch(){}

}