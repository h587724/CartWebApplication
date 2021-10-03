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
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet(name = "ProductsController", value = "/ProductsController")
public class ProductsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("action");
        if (act != null && act.equals("")){
            addToCart(request);
        }
        response.sendRedirect("view/Cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("action");
        if (act != null && act.equals("")){
            addToCart(request);
        }
        response.sendRedirect("view/Cart.jsp");
    }

    protected void addToCart(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String localCode = "en";
        if (cookies != null) {
            for (Cookie e : cookies) {
                if (e.getName().equals("lang")) {
                    localCode = e.getValue();
                }
            }
        }
        String pno = request.getParameter("productNo");
        HttpSession session = request.getSession();
        Database db = (Database) session.getAttribute("database");
        request.setAttribute("descriptions", db.getDescription(localCode));
        Cart cart = null;
        Object cartObj = session.getAttribute("cart");
        if (cartObj != null){
            cart = (Cart) cartObj;
        } else {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(Integer.parseInt(pno), (Database) session.getAttribute("database"));
    }
}
