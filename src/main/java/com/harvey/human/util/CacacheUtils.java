package com.harvey.human.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ObjectUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehcache 工具类
 * 
 * @author Harvey
 * @date 2020年12月29日
 */
public class CacacheUtils {
	private static Logger logger = LoggerFactory.getLogger(CacacheUtils.class);
	
	private static CacheManager cacheManager = null;
	
	private static String DEFAULT_CACHE_NAME = "humanCache";
	
	static {
		try {
			ClassPathResource resource = new ClassPathResource("ehcache.xml");
			cacheManager = CacheManager.create(resource.getInputStream());
		} catch (Exception e) {
			logger.error("load ehcache config file fail, error msg:{}", e);
		}
	}

	/**
	 * 通过key在默认缓存中获取缓存值
	 * 
	 * @param key 缓存key
	 * @return 缓存value
	 */
	public static Object getValue(String key) {
		return getValue(DEFAULT_CACHE_NAME, key);
	}

	/**
	 * 通过key在指定缓存中获取缓存值
	 * 
	 * @param cacheName 缓存名称
	 * @param key 缓存key
	 * @return 缓存value
	 */
	public static Object getValue(String cacheName, String key) {
		if (cacheManager == null || ObjectUtils.isEmpty(cacheName) || ObjectUtils.isEmpty(key)) {
			return null;
		}
		
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			return null;
		}
		
		Element element = cache.get(key);
		if (element == null) {
			return null;
		}
		
		return element.getObjectValue();
	}
	
	/**
	 * 把数据存入缓存中
	 * 
	 * @param key 缓存key
	 * @param value 缓存value
	 * @return true-成功， false- 失败
	 */
	public static boolean putCache(String key, Object value) {
		return putCache(DEFAULT_CACHE_NAME, key, value);
	}
	
	/**
	 * 把数据存入缓存中
	 * 
	 * @param cacheName 缓存名称
	 * @param key 缓存key
	 * @param value 缓存value
	 * @return true-成功， false-失败
	 */
	public static boolean putCache(String cacheName, String key, Object value) {
		if (cacheManager == null || ObjectUtils.isEmpty(cacheName) || ObjectUtils.isEmpty(key)
				|| ObjectUtils.isEmpty(value)) {
			return false;
		}
		
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			return false;
		}
		
		Element element = new Element(key, value);
		cache.put(element);
		return true;
	}
	
	/**
	 * 删除缓存中指定的数据
	 * 
	 * @param key 缓存key
	 * @return true-成功， false-失败
	 */
	public static boolean remove(String key) {
		return remove(DEFAULT_CACHE_NAME, key);
	}
	
	/**
	 * 删除缓存中指定的数据
	 * 
	 * @param cacheName 缓存名称
	 * @param key 缓存key
	 * @return true-成功， false-失败
	 */
	public static boolean remove(String cacheName, String key) {
		if (cacheManager != null && !ObjectUtils.isEmpty(cacheName) && !ObjectUtils.isEmpty(key)) {
			Cache cache = cacheManager.getCache(cacheName);
			if (cache != null) {
				return cache.remove(key);
			}
		}
		return false;
	}
}
