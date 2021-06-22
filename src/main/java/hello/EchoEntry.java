package hello;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class EchoEntry {
    Map<String, String> headers = new HashMap<>();
    Cookie[] cookies;

    public EchoEntry(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        if (headers.hasMoreElements()) {
            for (String value = headers.nextElement(); headers.hasMoreElements(); value = headers.nextElement()) {
                this.headers.put(value, request.getHeader(value));
            }
        }

        cookies = request.getCookies();

    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Cookie[] getCookies() {
        return cookies;
    }
}
