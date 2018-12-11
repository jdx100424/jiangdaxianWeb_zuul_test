package com.rule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡算法方式
 * 
 * @author jiangdaxian
 *
 */
public class MySelfRule extends AbstractLoadBalancerRule {
	private final int num = 5;
	private AtomicInteger total = new AtomicInteger(0);
	private AtomicInteger index = new AtomicInteger(0);

	public MySelfRule() {
        
    }

	/**
	 * Randomly choose from all living servers
	 */
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes only get more
				 * restrictive.
				 */
				return null;
			}
			int add = total.addAndGet(1);
			int result = 0;
			if(add >= num) {
				result = index.addAndGet(1);
				total.getAndSet(0);
			}else {
				result = index.get();
			}
			server = upList.get(result % upList.size());

			if (server == null) {
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				System.out.println("找到为'"+server.getId() + "'的机器");
				return (server);
			}
			server = null;
			Thread.yield();
		}
		return server;
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub

	}

}
