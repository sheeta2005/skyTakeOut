//package com.sky.service.impl;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//
//import com.sky.context.BaseContext;
//import com.sky.entity.AiDietRecommend;
//import com.sky.entity.UserDietRecord;
//import com.sky.mapper.AiDietRecommendMapper;
//import com.sky.mapper.UserDietRecordMapper;
//import com.sky.service.AiDietService;
//import com.sky.utils.AiDietUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class AiDietServiceImpl implements AiDietService {
//
//    @Autowired
//    private UserDietRecordMapper recordMapper;
//
//    @Autowired
//    private AiDietRecommendMapper recommendMapper;
//
//    @Autowired
//    private AiDietUtil aiDietUtil;
//
//    @Override
//    public void saveRecord(UserDietRecord record) {
//        record.setUserId(BaseContext.getCurrentId());
//        recordMapper.insert(record);
//    }
//
//    @Override
//    public String generateAdvice(Long recordId) {
//        UserDietRecord record = recordMapper.selectById(recordId);
//        String content = aiDietUtil.getAdvice(record.getDishNames(), record.getGoal());
//
//        AiDietRecommend rec = new AiDietRecommend();
//        rec.setUserId(BaseContext.getCurrentId());
//        rec.setDietRecordId(recordId);
//        rec.setRecommendType(1);
//        rec.setContent(content);
//        rec.setStatus(1);
//        recommendMapper.insert(rec);
//        return content;
//    }
//
//    @Override
//    public List<UserDietRecord> getMyRecords() {
//        LambdaQueryWrapper<UserDietRecord> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(UserDietRecord::getUserId, BaseContext.getCurrentId())
//                .orderByDesc(UserDietRecord::getCreateTime);
//        return recordMapper.selectList(wrapper);
//    }
//
//    @Override
//    public List<AiDietRecommend> getMyRecommends() {
//        LambdaQueryWrapper<AiDietRecommend> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(AiDietRecommend::getUserId, BaseContext.getCurrentId())
//                .orderByDesc(AiDietRecommend::getCreateTime);
//        return recommendMapper.selectList(wrapper);
//    }
//}