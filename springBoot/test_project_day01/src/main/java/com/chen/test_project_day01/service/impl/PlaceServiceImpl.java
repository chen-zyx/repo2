package com.chen.test_project_day01.service.impl;

import com.chen.test_project_day01.dao.IPlaceDao;
import com.chen.test_project_day01.entity.Place;
import com.chen.test_project_day01.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PlaceServiceImpl implements IPlaceService {

    @Autowired
    private IPlaceDao iPlaceDao;

    /**
     * 查询所有地址
     * @return
     */
    @Override
    public List<Place> findAllPlace() {
        List<Place> firstLevel = iPlaceDao.findFirstLevel();
        for (Place p:firstLevel) {
            //System.out.println("一级地址"+p.getName()+"p_id"+p.getP_id());
            List<Place> secondLevel = iPlaceDao.findSecondLevel(p);
            /*for (Place pl: secondLevel
            ) {
                System.out.println("二级"+pl.getName());
            }*/
            p.setChildren(secondLevel);
        }
        return firstLevel;
    }

}
