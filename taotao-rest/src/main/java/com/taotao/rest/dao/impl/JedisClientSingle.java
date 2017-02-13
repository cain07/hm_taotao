package com.taotao.rest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient{

	@Autowired
	private JedisPool jedisPool;
	
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		String set = jedis.set(key, value);
		jedis.close();
		return set;
	}

	@Override
	public String hget(String hkey, String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		String hget = jedis.hget(hkey, key);
		
		jedis.close();
		return hget;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long hset = jedis.hset(hkey, key, value);
		jedis.close();
		return hset;
	}

	@Override
	public long incr(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public long expire(String key, int second) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	@Override
	public long ttl(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	

	@Override
	public long hdel(String hkey, String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}

}
