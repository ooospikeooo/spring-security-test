package net.jw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "singup";
    }

    @RequestMapping(value="/signupProcess", method=RequestMethod.POST)
    public String signup(String userLoginId, String userPwd, String userNm) throws SQLException {
        User user = User.builder()
                .userLoginId(userLoginId)
                .userPwd(userPwd)
                .userNm(userNm)
                .build();

        userService.registerNewUserAccount(user);

        return "login";
    }
}
