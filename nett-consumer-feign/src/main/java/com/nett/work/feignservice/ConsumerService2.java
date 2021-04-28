package com.nett.work.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nett.work.dto.User;

/*以后调用microservicecloud-provider微服务中的方法，只需要调用下面对应的接口既可以了*/
@FeignClient(value = "microservicecloud-provider2")
public interface ConsumerService2 {

	/* 调用接口中的get方法，即可以向microservicecloud-provider微服务发送/get/{id}请求 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") int id);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean add(User user);

	@RequestMapping(value = "/getUser/list", method = RequestMethod.GET)
	public List<User> getAll();
}