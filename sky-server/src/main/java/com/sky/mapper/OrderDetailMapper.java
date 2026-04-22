package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    public void insertBatch(List<OrderDetail> orderDetailList) ;

    /**
     * 根据orderid查订单详情并返回
     * @param orderId
     * @return
     */
    List<OrderDetail> getByOrderId(Long orderId);
}
