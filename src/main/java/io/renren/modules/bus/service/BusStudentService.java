package io.renren.modules.bus.service;

import io.renren.modules.bus.entity.BusStudentEntity;

import java.util.List;
import java.util.Map;

public interface BusStudentService {

    /**
     * 查询学生列表
     */
    List<BusStudentEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存学生
     */
    void save(BusStudentEntity user);

    /**
     * 删除学生
     */
    void deleteBatch(Long[] studentIds);

    /**
     *根据Id查询学生
     */
    BusStudentEntity queryObject(long studentId);
}
