package com.chen.test_project_day01.dao;

import com.chen.test_project_day01.entity.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址dao接口
 */
@Mapper
@Repository
public interface IPlaceDao {

    /**
     * 查询一级地址
     * @return
     */
    public List<Place> findFirstLevel();

    /**
     * 查询一级地址对应的二级地址
     * @return
     */
    public List<Place> findSecondLevel(@Param("p") Place p);
}
