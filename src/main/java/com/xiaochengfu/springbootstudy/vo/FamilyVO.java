package com.xiaochengfu.springbootstudy.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.xiaochengfu.springbootstudy.model.Family;
import com.xiaochengfu.springbootstudy.model.Person;

import java.util.HashMap;

public class FamilyVO {

    /**
     * 知识点：
     * 1. 返回自定义key的json时，使用hashmap
     * 2. fastjson中的NameFilter接口，可使用lambda表达式来设置/过滤key和值
     */
    public String familyMember(){
        HashMap<String, Object> familyMember = new HashMap<>();
        Family family = new Family();
        family.setFather("爸爸");
        family.setMather("妈妈");
        family.setAddr("中国");
        family.setId(1L);
        Person person = new Person();
        person.setName("hp");
        person.setSex(Person.MAN);
        person.setAddr("北京");
        NameFilter familyFilter = (object,name, value)->{
            if (object instanceof Person){
                if(name.equals("addr")){
                    //修改属性名
                    name = "current_address";
                }
                if(name.equals("sex")){
                    //修改属性值
                    if( person.getSex().equals(Person.MAN)){
                        person.setSexTxt("男");
                    }else {
                        person.setSexTxt("女");
                    }
                }
            }
            if (object instanceof Family){
                if(name.equals("addr")){
                    name = "address";
                }
            }
            return name;
        };
        //属性过滤器
        PropertyFilter propertyFilter = (object,name, value)->{
            if (object instanceof Person){
                //过滤掉sex属性
                return !name.equals("sex");
            }
            return true;
        };
        familyMember.put("family",family);
        familyMember.put("me",person);
        family.setMemberNum(3);
        return JSON.toJSONString(familyMember,familyFilter,propertyFilter);
    }

    public Object familyMemberObject(){
        HashMap<String, Object> familyMember = new HashMap<>();
        Family family = new Family();
        family.setFather("爸爸");
        family.setMather("妈妈");
        family.setAddr("中国");
        family.setId(1L);
        Person person = new Person();
        person.setName("hp");
        person.setSex(Person.MAN);
        person.setAddr("北京");
        familyMember.put("family",family);
        familyMember.put("me",person);
        family.setMemberNum(3);
        return familyMember;
    }
}
