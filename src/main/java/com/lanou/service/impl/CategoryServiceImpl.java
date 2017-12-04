package com.lanou.service.impl;

import com.lanou.dao.CategoryMapper;
import com.lanou.entity.Category;
import com.lanou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/3.
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;

    public Category selectByPrimaryKey(Integer cId) {
        Category category = categoryMapper.selectByPrimaryKey(cId);
        if(category==null){
            return  null;
        }
         category.setCategoryList(findChildCategory(category,cId));
        return category;
    }

    private List<Category> findChildCategory(Category categoryRes, Integer categoryId){
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category categoryItem: categoryList) {
            categoryItem.setCategoryList(findChildCategory(categoryRes,categoryItem.getcId()));
        }
        return categoryList;
    }
    public List<Integer> selectCidParentIdForZero(){
        List<Integer> cids = categoryMapper.selectCidParentIdForZero();
        return cids;
    }


}
