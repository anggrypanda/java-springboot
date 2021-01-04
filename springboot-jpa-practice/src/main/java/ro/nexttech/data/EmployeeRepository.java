package ro.nexttech.data;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.nexttech.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
