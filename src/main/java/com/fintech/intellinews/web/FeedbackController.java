package com.fintech.intellinews.web;

import com.fintech.intellinews.Result;
import com.fintech.intellinews.service.FeedbackService;
import com.fintech.intellinews.service.UserService;
import com.fintech.intellinews.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wanghao
 * create 2018-03-11 21:35
 **/

@RestController
@Api(tags = "反馈信息资源接口")
@RequestMapping("/v1/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "获取未读用户消息列表", produces = "application/json")
    public Result listNotReadFeedBack() {
        return ResultUtil.success(feedbackService.listNotReadFeedback());
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加用户反馈信息接口", produces = "application/json")
    public Result addFeedBack(
            @ApiParam(name = "msg", value = "用户反馈信息", required = true)
            @RequestBody String msg) {
        Long currentUserId = userService.getCurrentUserId();
        return ResultUtil.success(feedbackService.addFeedback(currentUserId,msg));
    }

    @GetMapping("/count/{userId}")
    @ResponseBody
    @ApiOperation(value = "统计当前用户未读取反馈信息数量", produces = "application/json")
    public Result countFeedbackById(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @PathVariable(name = "userId") Long userId) {
        //TODO 权限验证
        return ResultUtil.success(feedbackService.countNotFeedbackById(userId));
    }

    @GetMapping("/count")
    @ResponseBody
    @ApiOperation(value = "统计所有未读取反馈信息数量", produces = "application/json")
    public Result countFeedback() {
        //TODO 权限验证
        return ResultUtil.success(feedbackService.notReadFeedbackCount());
    }
}
