package Controllers;

import Beans.I18n;
import DAO.Database;
import DAO.Description;
import DAO.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet(name = "ProductsController", value = "/ProductsController")
public class ProductsController extends HttpServlet {
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
