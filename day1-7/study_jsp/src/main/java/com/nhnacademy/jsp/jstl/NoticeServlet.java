package com.nhnacademy.jsp.jstl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NoticeServlet", urlPatterns = "/jstl/notice")
public class NoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Notice> noticeList = new ArrayList<>();
        for(int i=0; i<10; i++){
            String subject = "공지사항" + i;
            String name="작성자" + i;
            long counter = new RandomDataGenerator().nextLong(1,1000000000);
            noticeList.add(new Notice(subject,name,counter));
        }
        request.setAttribute("noticeList",noticeList);

        RequestDispatcher rd = request.getRequestDispatcher("/jstl/notice.jsp");
        rd.forward(request,response);
    }
}
