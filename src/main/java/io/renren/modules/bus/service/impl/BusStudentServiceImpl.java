package io.renren.modules.bus.service.impl;

import io.renren.modules.bus.dao.BusStudentDao;
import io.renren.modules.bus.entity.BusStudentEntity;
import io.renren.modules.bus.service.BusStudentService;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("busStudentService")
public class BusStudentServiceImpl implements BusStudentService {

    @Autowired
    private BusStudentDao busStudentDao;

    @Override
    public List<BusStudentEntity> queryList(Map<String, Object> map) {
        return busStudentDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return busStudentDao.queryTotal(map);
    }

    @Override
    public void save(BusStudentEntity student)
    {
        Long userId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUserId();

        student.setCreateTime(new Date());
        student.setCreateBy(userId);
        student.setUpdateTime(new Date());
        student.setUpdateBy(userId);

        busStudentDao.save(student);
    }

    @Override
    public void deleteBatch(Long[] studentIds)
    {
        busStudentDao.deleteBatch(studentIds);
    }

    @Override
    public BusStudentEntity queryObject(long studentId)
    {
        return busStudentDao.queryObject(studentId);
    }
}
