package servlet;

import dao.BookDAO;
import model.Book;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price"));
            Book book = new Book(0, title, author, price);
            bookDAO.insertBook(book);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price"));
            Book book = new Book(id, title, author, price);
            bookDAO.updateBook(book);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            bookDAO.deleteBook(id);
        }

        response.sendRedirect("BookServlet?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        if (action.equals("list")) {
            List<Book> listBook = bookDAO.selectAllBooks();
            request.setAttribute("listBook", listBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewBooks.jsp");
            dispatcher.forward(request, response);
        }
    }
}
