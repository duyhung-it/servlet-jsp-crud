package com.javaweb.dao.impl;

import com.javaweb.dao.INewDAO;
import com.javaweb.mapper.NewMapper;
import com.javaweb.model.NewModel;

import java.util.List;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

    @Override
    public NewModel findOne(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewModel> news = (List<NewModel>) query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public Long save(NewModel newModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
        sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),
                newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
                newModel.getCreatedDate(), newModel.getCreatedBy());
    }

    @Override
    public void update(NewModel updateNew) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
        sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
        sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(),
                updateNew.getCreatedBy(), updateNew.getModifiedDate(),
                updateNew.getModifiedBy(), updateNew.getId());
    }

    @Override
    public List<NewModel> findAll(int offset,int limit) {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");
                        sql.append(" limit "+offset+","+limit);
        return (List<NewModel>)query(sql.toString(),new NewMapper());
    }

    @Override
    public int getTotalItems() {
        String sql = "SELECT COUNT(*) FROM news";
        return count(sql);
    }
}
