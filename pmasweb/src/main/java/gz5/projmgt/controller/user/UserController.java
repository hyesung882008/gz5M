package gz5.projmgt.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gz5.projmgt.dao.UserDao;
import gz5.projmgt.domain.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("/view")
    public String view() {
        return "/login";
    }

    @RequestMapping("/indexview")
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(User model, HttpSession session) {
        System.out.println(model);
    	User user = userDao.findByUsername(model.getUsername());

        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return new ModelAndView("redirect:/login.jsp");
        } else {
            session.setAttribute("user", user);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index");
            return mav;
        }
    }
}
