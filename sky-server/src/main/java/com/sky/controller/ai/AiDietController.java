//package com.sky.controller.ai;
//
//import com.sky.entity.AiDietRecommend;
//import com.sky.entity.UserDietRecord;
//import com.sky.result.Result;
//import com.sky.service.AiDietService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/user/ai/diet")
//public class AiDietController {
//
//    @Autowired
//    private AiDietService aiDietService;
//
//    // 保存饮食记录
//    @PostMapping("/record")
//    public Result<String> save(@RequestBody UserDietRecord record) {
//        aiDietService.saveRecord(record);
//        return Result.success("保存成功");
//    }
//
//    // 生成AI饮食建议
//    @GetMapping("/advice/{recordId}")
//    public Result<String> advice(@PathVariable Long recordId) {
//        return Result.success(aiDietService.generateAdvice(recordId));
//    }
//
//    // 查询我的饮食记录
//    @GetMapping("/record/list")
//    public Result<List<UserDietRecord>> records() {
//        return Result.success(aiDietService.getMyRecords());
//    }
//
//    // 查询我的AI推荐
//    @GetMapping("/recommend/list")
//    public Result<List<AiDietRecommend>> recommends() {
//        return Result.success(aiDietService.getMyRecommends());
//    }
//}