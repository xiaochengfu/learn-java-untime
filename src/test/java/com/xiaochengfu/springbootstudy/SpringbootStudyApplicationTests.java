package com.xiaochengfu.springbootstudy;

import com.alibaba.fastjson.JSON;
import com.xiaochengfu.springbootstudy.model.Person;
import com.xiaochengfu.springbootstudy.vo.ResultVO;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class SpringbootStudyApplicationTests {

	@Test
	void fastjsonToJson() {
		Person person = new Person();
		person.setAddr("北京市");
		person.setName("hp");
		person.setId(1L);
		ResultVO<Person> success = ResultVO.success(person);
		String s = JSON.toJSONString(success);
		System.out.println(s);
	}

	@Test
	void fastjsonToJson2(){
		String jsonStr = "{\"address\":\"河南\",\"birthDay\":\"2021-08-17 03:38:09\",\"id\":1,\"name\":null,\"pwd\":\"123\",\"registerDate\":\"2021-08-17 03:38:09\",\"websiteUrl\":\"http://www.roadjava.com\"}";
		// 反序列化为person对象
		Person person = JSON.parseObject(jsonStr, Person.class);
		System.out.println(person);
		// 返回给调用端ResultVO
		ResultVO<Person> personResultVO = ResultVO.success(person);
		String voJsonStr = JSON.toJSONString(personResultVO);
		System.out.println("voJsonStr:"+voJsonStr);
	}

}
