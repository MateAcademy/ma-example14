package servlet;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class);
    private static final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Optional<User> userFromDb =  userDao.getUserByName(name);
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            if (user.getPassword().equals(password)) {

                req.getSession().setAttribute("user", user);
                req.setAttribute("name", name);
                if (user.getRole().equals("user")) {
                    logger.debug("User with id " + user.getId() + " logged in system like user");
                    req.getRequestDispatcher("userPage.jsp").forward(req, resp);
                } else if (user.getRole().equals("admin")){
                    logger.debug("User with id " + user.getId() + " logged in system like admin");
                    req.getRequestDispatcher("/admin").forward(req, resp);
                }
            }
        }
        req.setAttribute("error", "Пользователь с таким сочетанием логина/пароля не найден!" );
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
