package action;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import workflow.TestEngine;
import workflow.entity.User2;

import java.util.List;


@Controller
@RequestMapping("/user")
public class DemoAction {

    private UserService userService;

    @Autowired
    private TestEngine testEngine;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/get")
    @ResponseBody
    public List<User> test() {
        return userService.getUsers(1, 2);
    }

    @RequestMapping("/testEngine")
    @ResponseBody
    public String testEngine() {
        return testEngine.getResult();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User2> selectAll() {
        return testEngine.getUserService2().selectAll();
    }

    @RequestMapping("/getUser2s")
    @ResponseBody
    public List<User2> getUser2s() {
        return testEngine.getUserService2().getUser2s(1, 1);
    }

    @RequestMapping("/updateById")
    @ResponseBody
    public int updateById() {

        userService.transactionTest2();

//        User2 user2 = new User2(1, "ggg", String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
//        testEngine.getUserService2().insert(user2);
        return 1;
    }
}