package hello;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {
    private static final DateFormat dfDate = new SimpleDateFormat("dd MMM yyyy");
    private static final DateFormat dfTime = new SimpleDateFormat("HH:mm:ss");

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/time")
    public CurrentDate date() {
        Date date = new Date();

        return new CurrentDate(
                dfDate.format(date),
                dfTime.format(date));
    }

    @RequestMapping("/**")
    public EchoEntry echo(HttpServletRequest request) {
        return new EchoEntry(request);
    }
}
