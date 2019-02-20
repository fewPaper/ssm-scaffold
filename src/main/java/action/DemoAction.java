package action;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class DemoAction {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/get")
    @ResponseBody
    public List<User> test() {
        return userService.getUsers(1,2);
    }

}