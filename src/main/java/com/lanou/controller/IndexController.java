package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Category;
import com.lanou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanou on 2017/12/3.
 */
@Controller
@RequestMapping("index")
public class IndexController{

    @Autowired
    private CategoryService categoryService;
    @RequestMapping("category")
    public void findCategory(HttpServletResponse response) throws IOException {
          List<Integer> cids = categoryService.selectCidParentIdForZero();
          List<Category> categoryList = new ArrayList      <Category>();
          for(int i=0;i<cids.size();i++){
              Category category = categoryService.selectByPrimaryKey(cids.get(i));
              categoryList.add(category);
          }

        String jsonStr = JSON.toJSONString(categoryList);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer  = response.getWriter();
        writer.println(jsonStr);
        writer.flush();

    }

}
