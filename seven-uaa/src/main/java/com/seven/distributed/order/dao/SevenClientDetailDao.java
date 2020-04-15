package com.seven.distributed.order.dao;

import com.seven.distributed.order.model.SevenClientDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface SevenClientDetailDao {
    SevenClientDetails selectClientInfoByClientId(String clientId);
}
