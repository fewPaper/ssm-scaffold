package service;

import com.github.pagehelper.PageHelper;
import dao.UserMapper;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(Integer userid){
        return userMapper.selectByPrimaryKey(userid);
    }

    public List<User> getUsers(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }
}