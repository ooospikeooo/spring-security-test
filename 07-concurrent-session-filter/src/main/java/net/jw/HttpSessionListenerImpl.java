package net.jw;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class HttpSessionListenerImpl implements HttpSessionListener {
    private static final Map<String, HttpSession> sessions = new HashMap<>();

    public static Map<String, HttpSession> getSessionMap() {
        return sessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        HttpSession httpSession= sessionEvent.getSession();

        sessions.put(httpSession.getId(), httpSession);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        sessions.remove(sessionEvent.getSession().getId());
    }
}
