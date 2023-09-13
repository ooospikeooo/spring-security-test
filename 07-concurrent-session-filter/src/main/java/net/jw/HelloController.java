package net.jw;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final SessionRegistry registry;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping(value = "/hello_user", method = RequestMethod.GET)
    public String print_HelloUser(ModelMap model) {
        model.addAttribute("message", "Hello User.");
        return "hello";
    }

    @RequestMapping(value = "/admin/hello_admin", method = RequestMethod.GET)
    public String print_HelloAdmin(ModelMap model) {
        model.addAttribute("message", "Hello Admin");
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/public/sessionList", method = RequestMethod.GET)
    public String sessionList(Model model) {

        List<UserSession> userSessions = registry.getAllPrincipals().stream()
                .map(p -> UserSession.builder()
                        .username(((UserDetailsImpl)p).getUsername())
                        .sessions(registry.getAllSessions(p,false)
                                .stream().map(si ->SessionInfo.builder()
                                        .lastRequest(si.getLastRequest())
                                        .sessionId(si.getSessionId())
                                        .build()
                                ).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        model.addAttribute("sessionList",userSessions);

        return "sessionList";
    }
}