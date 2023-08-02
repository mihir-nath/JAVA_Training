package service;

import java.util.List;

import entities.Department;

public interface DepartmentService {
      void createDepartment(Department dept);
      Department FindDepartmentService(int id);
      List<Department> findDepartmentService();
      void modifyDepartmentService(Department dept);
      void removeDepartmentService(int deptNumber);
      
}
