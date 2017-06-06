package my.test.web.controller;


import my.test.web.form.JoinParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/")
public class JoinWechat {


    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public void doGet(@ModelAttribute JoinParam joinParam, HttpServletResponse response) {
        try {
            if (joinParam.validate()) {
                response.getWriter().print(joinParam.getEchostr());
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }
}
