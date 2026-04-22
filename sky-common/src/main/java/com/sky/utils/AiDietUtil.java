//package com.sky.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class AiDietUtil {
//
//    @Value("${ai.api.key}")
//    private String apiKey;
//
//    private static final String API_URL = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";
//
//    public String getAdvice(String record, String goal) {
//        try {
//            String prompt = "你是专业营养师，根据用户饮食记录给出菜品推荐和饮食建议，简洁专业：\n饮食记录："
//                    + record + "\n健康目标：" + goal;
//
//            OkHttpClient client = new OkHttpClient();
//            MediaType mediaType = MediaType.parse("application/json");
//
//            // ========== Java 8 兼容写法（已替换） ==========
//            Map<String, Object> msg = new HashMap<>();
//            msg.put("role", "user");
//            msg.put("content", prompt);
//
//            Map<String, Object> input = new HashMap<>();
//            input.put("messages", new Object[]{msg});
//
//            Map<String, Object> bodyMap = new HashMap<>();
//            bodyMap.put("model", "qwen-turbo");
//            bodyMap.put("input", input);
//            // ==============================================
//
//            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(bodyMap));
//            Request request = new Request.Builder()
//                    .url(API_URL)
//                    .addHeader("Authorization", "Bearer " + apiKey)
//                    .post(body)
//                    .build();
//
//            try (okhttp3.Response response = client.newCall(request).execute()) {
//                JSONObject res = JSON.parseObject(response.body().string());
//                return res.getJSONObject("output").getString("text");
//            }
//        } catch (Exception e) {
//            return "AI服务暂时不可用";
//        }
//    }
//}