package com.taotao.rest.service;

import com.taotao.common.utils.TaotaoResult;

public interface ItemService {

	/**
	 * 商品基础信息
	 * @param itemId
	 * @return
	 */
	public TaotaoResult getItemBaseInfo(long itemId);
	/**
	 * 商品详情
	 * @param itemId
	 * @return
	 */
	public TaotaoResult getItemDesc(long itemId);
	/**
	 * 商品规格参数
	 * @param itemId
	 * @return
	 */
	public TaotaoResult getItemParam(long itemId);
}
