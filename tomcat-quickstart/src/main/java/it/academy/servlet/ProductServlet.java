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

import java.sql.*;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            ProductSpecDao productSpecDao = daoFactory.getProductSpecDao();
            final List<ProductSpec> productSpecs;
            if (id == null) {
                productSpecs = productSpecDao.readAll();

            }else {
                ProductSpec productSpec = null;
                try{
                productSpec=productSpecDao.read(Integer.parseInt(id));}
                catch (NumberFormatException e){e.printStackTrace();}
                productSpecs = productSpec!=null ? List.of(productSpec): Collections.emptyList();
            }
            PrintWriter writer = resp.getWriter();

            for (ProductSpec product : productSpecs) {
                System.out.println("id= " + product.getId() +
                        //  " name="+ product.getProductName() +
                        " detalis= " + product.getProductDetails());
                writer.println("id=" + product.getId() +
                        //  " name="+ product.getProductName() +
                        " detalis= " + product.getProductDetails());

            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }
}
