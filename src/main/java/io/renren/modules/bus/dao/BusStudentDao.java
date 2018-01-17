package io.renren.modules.bus.dao;

import io.renren.modules.bus.entity.BusStudentEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository("busStudentDao")
public interface BusStudentDao extends BaseDao<BusStudentEntity> {


}
