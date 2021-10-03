package Controllers;

import Beans.I18n;
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

        request.setAttribute("langCode", localCode);
        request.setAttribute("products", db.getProducts());
        request.setAttribute("descriptions", db.getDescription(localCode));
        //request.setAttribute("showProducts", getJSPLocalGoods(localCode, db.getDescription(localCode), db.getProducts(), I18n.getLocale(localCode)));
        RequestDispatcher rd = request.getRequestDispatcher("view/Product.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Database db = new Database(3);
        Cookie[] cookies = request.getCookies();
        String localCode = "en";
        if (cookies != null) {
            for (Cookie e : cookies) {
                if (e.getName().equals("lang")) {
                    localCode = e.getValue();
                }
            }
        }
        request.setAttribute("products", db.getProducts());
        request.setAttribute("descriptions", db.getDescription(localCode));*/
    }

    public String getJSPLocalGoods (String locale, Description[] descriptions, Product[] products, ResourceBundle rb) {
        String output = "<div>";
        if (descriptions == null || products == null) {
            return "An error occurred!";
        } else {
            for (int i = 0; i < products.length; i++) {
                output += "<h2>" + (i + 1) + ". " + rb.getString("productName") + ": " + products[i].getpName() + "</h2><br>"
                        + "<img float=\"right\" alt=\"cup" + i + "\" src=\"http://localhost:8080/Oblig2/view/images/cup" + (i+1) + ".png\" width=\"10%\" height=\"10%\"/><br>"
                        + rb.getString("price") + ": " + I18n.convertCurrency(products[i].getPriceInEuro(), locale) + " " + rb.getString("currency") + "<br>"
                        + rb.getString("description") + ": " + descriptions[i].getText() + "<br>";
            }
            return output + "</div>";
        }
    }

}
