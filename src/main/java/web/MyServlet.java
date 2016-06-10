package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MyServlet extends HttpServlet {
    private AudioFile audioFile = new AudioFile();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key", "kachok");
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
        audioFile.playAudio();
    }

}
