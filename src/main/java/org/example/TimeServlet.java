package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String time;
        if (req.getParameterMap().containsKey("timezone")) {
            String zone = req.getParameter("timezone");
            time = ZonedDateTime.now(ZoneId.of(zone))
                    .format(DateTimeFormatter.ofPattern(
                    "Дата: yyy-MM-dd, Час: HH:mm:ss")) + ", Часовий пояс: " + ZonedDateTime.now(ZoneId.of(zone)).getOffset();
        } else {
            time = LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                    "Дата: yyy-MM-dd, Час: HH:mm:ss")) + ", Часовий пояс: " + ZonedDateTime.now().getOffset();
        }
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(time);
        resp.getWriter().close();
    }
}
