package com.sakura.takeaway.controller.user;


import com.sakura.takeaway.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取店铺的营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        // 使用 Optional 优雅处理 null
        Optional<Integer> statusOptional = Optional.ofNullable(status);

        if (statusOptional.isPresent()) {  // 检查状态是否存在
            Integer actualStatus = statusOptional.get();
            // 记录状态信息（假设 1=营业，其他值=打烊）
            String statusDesc = actualStatus == 1 ? "营业中" : "打烊中";
            log.info("获取到店铺的营业状态为：{}", statusDesc);
            return Result.success(actualStatus);
        } else {
            // 处理状态不存在的情况（例如未初始化状态）
            log.warn("未查询到店铺营业状态，KEY: {}", KEY);
            return Result.success(1);
        }
    }
}
