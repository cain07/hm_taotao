package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper ;
	
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

	@Override
	public void saveItem(TbItem tbItem, String desc, String itemParams) {
		// TODO Auto-generated method stub
		Date date = new Date();
		long genItemId = IDUtils.genItemId();
		
		
		tbItem.setId(genItemId);
		tbItem.setUpdated(date);
		tbItem.setCreated(date);
		tbItem.setStatus((byte) 1);
		
		itemMapper.insert(tbItem);
		
		TbItemDesc recorddesc = new TbItemDesc();
		recorddesc.setItemId(genItemId);
		recorddesc.setItemDesc(desc);
		recorddesc.setUpdated(date);
		recorddesc.setCreated(date);
		itemDescMapper.insert(recorddesc);
	}

}
