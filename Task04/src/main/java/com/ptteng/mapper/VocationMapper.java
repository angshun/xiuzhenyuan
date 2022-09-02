package com.ptteng.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shun on 2017/6/8.
 */
@Component
public interface VocationMapper {
    public List getVocationsWithDirection(int v_direction);

}
