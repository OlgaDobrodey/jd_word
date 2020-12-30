package it.academy.servlet;

import it.academy.data.DaoFactory;
import it.academy.data.DatabaseName;
import it.academy.data.ProductSpec;
import it.academy.data.ProductSpecDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "newProductServlet", urlPatterns = "/new-product")
public class NewProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            ProductSpecDao productSpecDao = daoFactory.getProductSpecDao();
            ProductSpec product = new ProductSpec();
            product.setId(Integer.parseInt(req.getParameter("product.id")));
            product.setProductName(req.getParameter("product.name"));
            product.setProductDetails(req.getParameter("product.details"));
            product.setProductDate(Date.valueOf(req.getParameter("product.date")));

            productSpecDao.create(product);
           writer.println("New product " +product+ " ddg");
        } catch (Exception e) {
           e.printStackTrace();
           writer.println("Error"+ e.getMessage());
        }
    }
    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.MYSQL);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
