package com.chen.test_project_day01.service;

import com.chen.test_project_day01.entity.Place;

import java.util.List;

/**
 * 地址管理service接口
 */
public interface IPlaceService {
    /**
     * 查询所有地址
     * @return
     */
    public List<Place> findAllPlace();

}
