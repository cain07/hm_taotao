package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

public class TestPageHelper {

	@Test
	public void test01() {
		// 创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");
		// 从spring容器中获得Mapper的代理对象
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		PageHelper.startPage(2, 10);
		List<TbItem> selectByExample = tbItemMapper.selectByExample(example);
		
		for (TbItem item:selectByExample ) {
			System.out.println(item.getTitle());
		}
		
		PageInfo<TbItem> pageInfo = new PageInfo<>(selectByExample);
		long total = pageInfo.getTotal();
		System.out.println(total);

	}
}
