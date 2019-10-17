package mapper;

import model.userinfo;

public interface userinfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(userinfo record);

    int insertSelective(userinfo record);

    userinfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(userinfo record);

    int updateByPrimaryKey(userinfo record);

//    userinfo test(String uname);
}