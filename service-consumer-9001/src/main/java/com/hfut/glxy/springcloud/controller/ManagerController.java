package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.entities.OrderBean;
import com.hfut.glxy.springcloud.entities.User;
import com.hfut.glxy.springcloud.service.BookService;
import com.hfut.glxy.springcloud.service.OrderService;
import com.hfut.glxy.springcloud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private OrderService orderService;
    @Resource
    UserService userService;
    @Resource
    private BookService bookService;

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/manager/bookManager";
    }

    /**
     * 管理员登录，若用户名和密码验证成功，则将当前用户存入session中
     * @param uname
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.getUser(uname, pwd);
        if (user != null && user.getRole() == 1) {
            session.setAttribute("manager", user);
            return "redirect:/manager/toOrderManager";
        }
        return "manager/login_manager";
    }

    /**
     * 查询所所有的订单，并跳转至订单详情页面
     * @param model
     * @return
     */
    @RequestMapping("/toOrderManager")
    public String toOrderManager(Model model) {
        List<OrderBean> orderList = orderService.getAllOrder();
        model.addAttribute("orderList", orderList);
        return "manager/order_manager";
    }

    /**
     * 根据订单id查询该订单的详细图书购买信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toOrderDetail/{id}")
    public String toOrderDetail(@PathVariable Integer id, Model model) {
        OrderBean order = orderService.getOrder(id);
        if (order==null){
            return "fallback";
        }
        model.addAttribute("order", order);
        return "manager/order_detail";
    }

    /**
     * 根据订单id发货
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/deliver/{id}")
    public String deliver(@PathVariable Integer id, Model model) {
        String deliver = orderService.deliver(id);
        model.addAttribute("deliver", deliver);
        return "redirect:/manager/toOrderManager";
    }

    /**
     * 根据图书id查询图书信息，并跳转至图书信息修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable Integer id, Model model) {
        List<Book> bookList = bookService.getBookList();
        for (Book book : bookList) {
            if (book.getId() == id) {
                model.addAttribute("book", book);
                return "manager/book_update";
            }
        }
        return "redirect:/manager/bookManager";
    }



    /**
     * 根据图书id删除图书（逻辑删除，即将图书的状态改成 1 ）
     * @param id
     * @return
     */
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/manager/bookManager";
    }

    /**
     * 添加图书
     * @param book
     * @param model
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(Book book, Model model) {
        String addBook = bookService.addBook(book);
        if (addBook.equals("添加成功")) {
            return "redirect:/manager/bookManager";
        } else {
            model.addAttribute("addBook", addBook);
            return "manager/book_add";
        }
    }

    /**
     * 查询所有图书，并跳转至图书管理界面
     * @param model
     * @return
     */
    @RequestMapping("/bookManager")
    public String bookManager(Model model) {
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "manager/book_manager";
    }
}
