package com.taotao.rest.reids.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class RedisTest {
	
	@Test
	public void testRedisSingle01(){
		Jedis jedis = new Jedis("192.168.74.128", 6379);
		jedis.set("test01", "hhh");
		String string = jedis.get("test01");
		System.out.println(string);
		jedis.close();
	}
	
	@Test
	public void testRedis02(){
		JedisPool pool = new JedisPool("192.168.74.128", 6379);
		Jedis jedis = pool.getResource();
		jedis.set("j2", "中国");
		String string = jedis.get("j2");
		System.out.println(string);
		jedis.close();
		pool.close();
		
	}
	
	@Test
	public void testRedis03(){
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.74.128", 7001));
		nodes.add(new HostAndPort("192.168.74.128", 7002));
		nodes.add(new HostAndPort("192.168.74.128", 7003));
		nodes.add(new HostAndPort("192.168.74.128", 7004));
		nodes.add(new HostAndPort("192.168.74.128", 7005));
		nodes.add(new HostAndPort("192.168.74.128", 7006));
		
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.set("j3","jiquan");
		String string = cluster.get("j3");
		System.out.println(string);
		cluster.close();
		
	}
	
	@Test
	public void testRedis04(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		JedisPool pool =  (JedisPool) applicationContext.getBean("redisClient");
		Jedis resource = pool.getResource();
		resource.set("spring01", "spirngtest");
		String string = resource.get("spring01");
		System.out.println(string);
	    
		resource.close();
		pool.close();
		
	}

	@Test
	public void testRedis05(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		JedisCluster cluster =  (JedisCluster) applicationContext.getBean("redisClient");
		
		cluster.set("spring02", "spirngtest");
		String string = cluster.get("spring02");
		System.out.println(string);
	    
		cluster.close();
		
	}
	
}
