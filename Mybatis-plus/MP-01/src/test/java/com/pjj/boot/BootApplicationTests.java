package com.pjj.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjj.boot.bean.User;
import com.pjj.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
@SpringBootTest
@Slf4j
class BootApplicationTests {

	//使用自动注入，注入mapper对象
	@Autowired
	private UserMapper mapper;

	@Test
	public void InsertUser(){
		User user = new User();
		user.setId(1012);
		user.setName("德鲁伊");
		user.setEmail("deluyi@qq.com");
		user.setAge(99);

		mapper.insert(user);
	}

	@Test
	public void updateUser(){
		User user = new User();
		user.setName("张三他爹");
		user.setId(1001);
		int i = mapper.updateById(user);
		log.info("修改的行数：" + i);
	}


	@Test
	public void deleteById(){
		User user = new User();
		boolean i = user.deleteById(1016);
		log.info("删除的行数: " +i);
	}

	@Test
	public void deleteByMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1010);
		map.put("age", 21);
		int i = mapper.deleteByMap(map);
		log.info("删除的条数:" + i);

	}


	@Test
	public void deleteByBatchId(){
		List<Integer> list = new ArrayList<>();
		list.add(1019);
		list.add(1018);
		list.add(1017);
		int i = mapper.deleteBatchIds(list);
		log.info("删除的行数：" + i);
	}

	@Test
    public void allEqTest(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "小煤球");
        map.put("age",5);
        wrapper.allEq(map);
        List<User> users = mapper.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
	public void neTest(){
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.between("age", 10,20);
		List<User> users = mapper.selectList(wrapper);
		users.forEach(user -> System.out.println("输出的结果：" + user));
	}

	@Test
	public void nullTest(){
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.isNotNull("name");
		List<User> users = mapper.selectList(wrapper);
		users.forEach(user -> System.err.println("输出的结果：" + user));
	}

	@Test
	public void inSqlTest(){
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.inSql("age", "select age from user where id = 1010");
		List<User> users = mapper.selectList(wrapper);
		users.forEach(user -> System.err.println("查询结果：" + user));
	}

	@Test
	public void orderByTest(){
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.orderBy(true, false, "id")
			   .orderBy(true, false, "age");
		List<User> users = mapper.selectList(wrapper);
		users.forEach(user -> System.err.println("查询结果：" + user));
	}


























}
