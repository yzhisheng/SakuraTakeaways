package com.sakura.takeaway.service;


import com.sakura.takeaway.dto.EmployeeLoginDTO;
import com.sakura.takeaway.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

}
