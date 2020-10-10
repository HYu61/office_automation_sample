import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hyu.oa.dao.DepartmentDao;
import pers.hyu.oa.entity.Department;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_dao.xml")
public class TestDao {
    @Resource(name = "departmentDao")
    DepartmentDao departmentDao;
    @Test
    public void testDeptDao(){
//        System.out.println(departmentDao.selectAll());
//        Department department = new Department();
//        department.setName("tt");
//        department.setAddress("a1");
//        departmentDao.insert(department);
//        Department department = departmentDao.selectById(1020);
//        department.setName("tt");
//        departmentDao.update(department);
//        departmentsDao.delete(1004);
//        System.out.println(departmentsDao.selectAll());
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1018);
//        list.add(1014);
//        list.add(1015);
//
//        departmentDao.deleteMulti(list);
//        System.out.println(departmentDao.selectById(1004));
        List<Integer> list = new ArrayList<Integer>();
        list.add(1001);
        departmentDao.deleteMulti(list);
    }
}
