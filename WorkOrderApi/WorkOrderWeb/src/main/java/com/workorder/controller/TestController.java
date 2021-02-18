package com.workorder.controller;

import com.workorder.config.Dome;
import com.workorder.utils.result.JsonResult;
import com.workorder.utils.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Api(tags = "测试")
public class TestController {
    @GetMapping("/test")
    @ApiOperation(value="这是个测试方法")
    @Dome(path = false)
    public JsonResult index(String ag) throws Exception {
        return ResultCode.success(ag);
    }
}
