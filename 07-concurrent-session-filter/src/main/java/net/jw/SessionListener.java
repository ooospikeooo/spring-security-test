package net.jw;

import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;

public class SessionListener implements HttpSessionListener, HttpSessionIdListener, HttpSessionAttributeListener {

    private static final Map<String, HttpSession> sessions = new HashMap<>();

    public static Map<String, HttpSession> getSessionMap() {
        return sessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 세션 생성시 호출
        System.out.println("[ session ] created / id : " + se.getSession().getId());

        HttpSession httpSession= se.getSession();

        sessions.put(httpSession.getId(), httpSession);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 세션 소멸시 호출
        System.out.println("[ session ] destroyed / id : " + se.getSession().getId());

        sessions.remove(se.getSession().getId());
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
        // 세션ID 변경시 호출
        System.out.println("[ session ] changed / oldId : " + oldSessionId + " / newId : " + se.getSession().getId());

        sessions.remove(oldSessionId);

        HttpSession httpSession= se.getSession();
        sessions.put(httpSession.getId(), httpSession);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // 프라퍼티 추가시 호출
        System.out.println("[ session ] add / key : " + se.getName() + ", value : " + se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // 프라퍼티 삭제시 호출
        System.out.println("[ session ] remove / key : " + se.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // 프라퍼티 값 변경시 호출
        System.out.println("[ session ] replace / key : " + se.getName() + ", value : " + se.getValue() + " --> " +  se.getSession().getAttribute(se.getName()));
    }
}
