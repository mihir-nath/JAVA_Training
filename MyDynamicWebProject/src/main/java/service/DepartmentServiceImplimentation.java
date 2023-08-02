package service;

import java.util.List;

import dao.DepartmentDAO;
import dao.DepartmentDAOImplementation;
import entities.Department;

public class DepartmentServiceImplimentation implements DepartmentService {
           DepartmentDAO deptDAO=new DepartmentDAOImplementation()
;	@Override
	public void createDepartment(Department dept) {
		deptDAO.insertDepartment(dept);

	}

	@Override
	public Department FindDepartmentService(int id) {
		// TODO Auto-generated method stub
		return deptDAO.selectDepartment(id);
	}

	@Override
	public List<Department> findDepartmentService() {
		// TODO Auto-generated method stub
		return deptDAO.selectDepartments();
	}

	@Override
	public void modifyDepartmentService(Department dept) {
		// TODO Auto-generated method stub
        deptDAO.updateDepartment(dept);
	}


	@Override
	public void removeDepartmentService(int deptNumber) {
		// TODO Auto-generated method stub
		deptDAO.deleteDepartment(deptNumber);
	}

}
