package com.javaweb.service.impl;

import com.javaweb.dao.INewDAO;
import com.javaweb.dao.impl.NewDAO;
import com.javaweb.model.NewModel;
import com.javaweb.service.INewService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {
    private INewDAO newDao;
    public NewService (){
        newDao = new NewDAO();
    }
    @Override
    public NewModel findOne(Long id) {
        NewModel newModel = newDao.findOne(id);
        return newModel;
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newModel.setCreatedBy("");
        Long newId = newDao.save(newModel);
        return newDao.findOne(newId);
    }

    @Override
    public List<NewModel> findAll(int offset, int limit) {
        return newDao.findAll(offset,limit);
    }

    @Override
    public int getTotalItems() {
        return newDao.getTotalItems();
    }
}
