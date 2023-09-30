package com.spring.bootlearn.serviceImpl;

import com.spring.bootlearn.exception.ResourceNotFound;
import com.spring.bootlearn.model.Employee;
import com.spring.bootlearn.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl underTest;
    @Mock
    EmployeeRepository repo;


    Logger log = LoggerFactory.getLogger(this.getClass());
    PodamFactory factory = new PodamFactoryImpl();

    @Test
    void saveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("genics");
        employee.setEmail("something@gmail.com");
        employee.setLastName("last name");
        when(repo.save(any())).thenReturn(employee);

        Employee expected=underTest.saveEmployee(employee);

        verify(repo,times(1)).save(any());
        assertEquals(expected.getEmail(),employee.getEmail());
    }

    @Test
    void getAllEmployee() {
        List<Employee> employees = factory.manufacturePojoWithFullData(List.class,Employee.class);
        when(repo.findAll()).thenReturn(employees);

        List<Employee> expected = underTest.getAllEmployee();

        assertEquals(expected.stream().count(),employees.stream().count());
        assertEquals(expected.get(1),employees.get(1));
        verify(repo,times(1)).findAll();
    }

    @Test
    void getById() {
        Employee employee = factory.manufacturePojo(Employee.class);

        when(repo.findById(any())).thenReturn(Optional.of(employee));

        Employee expected= underTest.getById(employee.getId());

        assertEquals(expected,employee);
    }

    @Test
    void itShouldNotGetEmployeeItDoesNotExist(){
        Employee employee = factory.manufacturePojoWithFullData(Employee.class);

        when(repo.findById(any())).thenThrow(ResourceNotFound.class);

        verify(repo,times(1)).findById(any());
        assertThrows(ResourceNotFound.class,()-> underTest.getById(employee.getId()));
    }

    @Test
    void delete() {

        Employee employee = factory.manufacturePojoWithFullData(Employee.class);
        when(repo.findById(any())).thenReturn(Optional.ofNullable(employee));
        doNothing().when(repo).deleteById(anyLong());

        String expected = underTest.delete(1L);

        assertEquals("Deleted", expected);
    }
}