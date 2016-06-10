package web;

import web.api.PlayerAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MyServlet extends HttpServlet {
    private PlayerAPI playerAPI = new PlayerAPI();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key", "kachok");
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
        playerAPI.play("3 Nick Kamarera & Deepside Deejays - Beautiful Days.mp3");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            playerAPI.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
