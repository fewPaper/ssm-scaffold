package service;

import com.github.pagehelper.PageHelper;
import dao.UserMapper;
import po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workflow.TestEngine;

import java.util.List;


@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    private TestEngine testEngine;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    public List<User> getUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }

    public int insert(User record) {
        return userMapper.insert(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public void transactionTest1() {
        User user = new User(1, "aaa", String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
        userMapper.updateByPrimaryKey(user);
    }

    @Transactional
    public void transactionTest2() {
        User user = new User(1, "aaa", String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
        userMapper.updateByPrimaryKey(user);
//        User user1 = new User(4, "ddd", String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
//        userMapper.insert(user1);
//        User2 user2 = new User2(5, "eee", String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
        testEngine.getUserService2().transactionTest2();
    }
}