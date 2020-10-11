import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hyu.oa.entity.Department;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.service.DepartmentService;
import pers.hyu.oa.service.EmployeeService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_service.xml")
public class TestService {
    @Resource(name = "departmentService")
    DepartmentService departmentService;

    @Resource(name = "employeeService")
    EmployeeService employeeService;


    @Test
    public void testS(){
        Department department = new Department();
        department.setName("finace");
        department.setAddress("a1");
        departmentService.add(department);
    }

    @Test
    public void testEmpAddAop(){
        Employee e1 = employeeService.getBySn("gm0001");
        e1.setSn("gg0004");
        e1.setName("JJ");
//        System.out.println(e1.getName());
//        System.out.println(e1.getDeptId());
//        System.out.println(e1.getDept().getName());
//        System.out.println(e1.getDept().getId());
        e1.setCaSin("910000110");
//        String msg = employeeService.add(e1);
//        System.out.println(msg);
        String msg = employeeService.add(e1);
        System.out.println(msg);
    }

}
