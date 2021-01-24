package com.harvey.human.common;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HumanThreadPool {
	private HumanThreadPool() {}
	
	public static Executor getInstance() {
		return HumanThreadPoolHolder.executor;
	}

	private static class HumanThreadPoolHolder{
		private static final Executor executor = new ThreadPoolExecutor(
				10, // corePoolSize
				50, // maximumPoolSize
				5, // keepAliveTime
				TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
	}
}
