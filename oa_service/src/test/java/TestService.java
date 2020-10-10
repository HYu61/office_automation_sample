import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hyu.oa.entity.Department;
import pers.hyu.oa.service.DepartmentService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_service.xml")
public class TestService {
    @Resource(name = "departmentService")
    DepartmentService departmentService;

    @Test
    public void testS(){
        Department department = new Department();
        department.setName("finace");
        department.setAddress("a1");
        departmentService.add(department);
    }
}
