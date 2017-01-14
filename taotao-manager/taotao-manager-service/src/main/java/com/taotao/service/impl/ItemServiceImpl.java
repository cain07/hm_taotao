package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		TbItemExample example = new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(itemId);
		List<TbItem> selectByExample = itemMapper.selectByExample(example);
		if(selectByExample != null){
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		PageHelper.startPage(page, rows);
		// TODO Auto-generated method stub
		List<TbItem> list = itemMapper.selectByExample(example);
		EUDataGridResult dataGridResult = new EUDataGridResult();
		dataGridResult.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		long total = pageInfo.getTotal();
		dataGridResult.setTotal(total);
		
		return dataGridResult;
	}

}
