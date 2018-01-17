package io.renren.modules.bus.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.bus.entity.BusStudentEntity;
import io.renren.modules.bus.service.BusStudentService;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/bus/student")
@RestController
public class BusStudentController extends AbstractController {

    @Autowired
    private BusStudentService busStudentService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params)
    {
        Query query = new Query(params);

        List<BusStudentEntity> studentList = busStudentService.queryList(query);
        int total = busStudentService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(studentList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 保存学生
     */
    @SysLog("保存学生")
    @RequestMapping("/save")
    @RequiresPermissions("bus:student:save")
    public R save(@RequestBody BusStudentEntity student){

        busStudentService.save(student);

        return R.ok();
    }

    /**
     * 删除学生
     */
    @SysLog("删除学生")
    @RequestMapping("/delete")
    @RequiresPermissions("bus:student:delete")
    public R delete(@RequestBody Long[] studentIds){

        busStudentService.deleteBatch(studentIds);

        return R.ok();
    }

    @RequestMapping("/info/{studentId}")
    public R info(@PathVariable("studentId") Long studentId){

        BusStudentEntity studentEntity = busStudentService.queryObject(studentId);

        return R.ok().put("student", studentEntity);
    }

}
