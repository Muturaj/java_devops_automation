package com.example.demo.nokia.serviceimpl;

import com.example.demo.nokia.dto.Employee;
import com.example.demo.nokia.entity.EmployeeEntity;
import com.example.demo.nokia.repo.EmployeeAddressRepo;
import com.example.demo.nokia.repo.EmployeeRepo;
import com.example.demo.nokia.service.EmployeeService;
import com.example.demo.nokia.utility.ClientAPICalls;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {


    /**
     * @return
     */
    private final ClientAPICalls clientAPICalls;
    private final EmployeeRepo employeeRepo;

    private final EmployeeAddressRepo employeeAddressRepo;

    @Override
    public Employee getEmployeeinfo() {

        return clientAPICalls.getEmployeeinfoDisable();

    }

    /**
     * @param employeeinfo
     * @return
     */
    @SneakyThrows
    @Override
    public EmployeeEntity saveEmployeeDetails(Employee employeeinfo, MultipartFile m) {

        EmployeeEntity e=  EmployeeEntity.builder()
                .avatar(employeeinfo.getData().getAvatar())
                .email(employeeinfo.getData().getEmail())
                .first_name(employeeinfo.getData().getFirst_name())
                .text(employeeinfo.getSupport().getText())
                .url(employeeinfo.getSupport().getUrl())
                .last_name(employeeinfo.getData().getLast_name())
                .employeedata(m.getBytes())
                .filename(m.getOriginalFilename())
                .filetype(m.getContentType())
                .build();

        employeeRepo.save(e);
        return e;
    }

    /**
     * @param fileId
     * @return
     */
    @Override
    public EmployeeEntity getFile(Long fileId) {


        return employeeRepo.findById(fileId).get();
    }

    /**
     * @param employee
     * @return
     */
    @Override
    public com.example.demo.nokia.jpastuff.Employee saveEmpAddressDetails(com.example.demo.nokia.jpastuff.Employee employee) {
        return employeeAddressRepo.save(employee);
    }

    /**
     * @param emp_id
     * @return
     */
    @Override
    public com.example.demo.nokia.jpastuff.Employee getEmployyeDetailsFromDB(String emp_id) {
       // Optional<com.example.demo.nokia.jpastuff.Employee> emp=  employeeAddressRepo.findById(emp_id);
        com.example.demo.nokia.jpastuff.Employee e= employeeAddressRepo.findByEmpId(emp_id);

        return e;
//       if(emp.isPresent()) {
//           emp.get().getEmpAddress();
//           return emp.get();
//       }
//       else {
//           throw new RuntimeException("Employee Id not found");
//       }

    }
}
