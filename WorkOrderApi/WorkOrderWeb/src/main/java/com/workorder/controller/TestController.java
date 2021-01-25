package com.workorder.controller;

import com.workorder.service.WosUserService;
import com.workorder.utils.result.JsonResult;
import com.workorder.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@ResponseBody
public class TestController {
    @GetMapping("/test")
    public JsonResult index() {
        return ResultCode.success("获取成功");
    }
}
