package com.javaweb.controller.admin;

import com.javaweb.model.NewModel;
import com.javaweb.service.INewService;
import com.javaweb.service.impl.NewService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewController", value = "/admin-new")
public class NewController extends HttpServlet {
    @Inject
    private INewService newService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewModel model = new NewModel();
        String pageStr = request.getParameter("page");
        String maxPageItemStr = request.getParameter("maxPageItems");
        if(pageStr!=null){
            model.setPage(Integer.parseInt(pageStr));
        }else{
            model.setPage(1);
        }
        if(maxPageItemStr!= null){
            model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
        }
        model.setToTalItem(newService.getTotalItems());
        int offset = (model.getPage()-1) * model.getMaxPageItem();
        List<NewModel> list = newService.findAll(offset,model.getMaxPageItem());
        model.setList(list);
        model.setTotalPage((int) ((model.getToTalItem() - 2)/ model.getMaxPageItem() + 1));
        request.setAttribute("model",model);
        RequestDispatcher rd = request.getRequestDispatcher("views/admin/new/list.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
