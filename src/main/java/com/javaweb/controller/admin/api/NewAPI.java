package com.javaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.model.NewModel;
import com.javaweb.service.INewService;
import com.javaweb.service.impl.NewService;
import com.javaweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "new-api", value = "/api-admin-new")
public class NewAPI extends HttpServlet {
    @Inject
    private INewService newService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        newService = new NewService();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        newModel = newService.save(newModel);
        mapper.writeValue(resp.getOutputStream(),newModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}
