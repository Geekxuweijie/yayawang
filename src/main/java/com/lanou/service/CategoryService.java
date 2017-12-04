package com.lanou.service;


import com.lanou.entity.Category;

import java.util.List;

/**
 * Created by lanou on 2017/12/3.
 */
public interface CategoryService {
    public Category selectByPrimaryKey(Integer cId);
    public List<Integer> selectCidParentIdForZero();

}
