package Controllers;

import Beans.I18n;
import DAO.Cart;
import DAO.Database;
import DAO.Description;
import DAO.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String localCode = "en";
        if (cookies != null) {
            for (Cookie e : cookies) {
                if (e.getName().equals("lang")) {
                    localCode = e.getValue();
                }
            }
        }
        Database db = new Database(3);
        HttpSession session = request.getSession();
        session.setAttribute("database", db);
        request.setAttribute("langCode", localCode);
        request.setAttribute("products", db.getProducts());
        request.setAttribute("descriptions", db.getDescription(localCode));
        RequestDispatcher rd = request.getRequestDispatcher("view/Product.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
