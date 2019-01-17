package com.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swagger2.entity.User;

@RestController
@RequestMapping("/swagger")
@Api(value="person" ,description="针对用户的插入，删除，查看等操作")
public class UuController {
	//用在方法上，说明方法的作用
		@ApiOperation(value="创建用户",notes="根据User对象创建用户")
		@ApiImplicitParams({
			  @ApiImplicitParam(dataType="java.lang.Long",name="id",value="id",required=true, paramType="path"),
			  @ApiImplicitParam(dataType="User",name="user",value="用户信息",required=true)  
		})
		@RequestMapping(value="/user/{id}",method=RequestMethod.POST)
		public User insert(@PathVariable Long id,@RequestBody User user){
			System.out.println("id:"+id+",user:"+user);
			user.setId(id);
			return user;
		}
		
		@ApiOperation(value="获取指定id用户",notes="根据id获取用户对象")
		@ApiImplicitParams({
			  @ApiImplicitParam(dataType="java.lang.Long",name="id",value="id",required=true, paramType="path"),
		})
		@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
		public User getUser(@PathVariable Long id){
			User user = new User();
			user.setId(id);
			user.setUsername("马云");
			user.setPassword("1111");
			return user;
		}

	@ApiOperation(value = "删除指定id用户", notes = "根据User的id删除用户信息")
	@ApiImplicitParam(dataType = "java.lang.Long", name = "id", value = "用户id", required = true, paramType = "path")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		System.out.println("delete user:" + id);
		return "ok";
	}
}
