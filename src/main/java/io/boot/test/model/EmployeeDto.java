package io.boot.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private int employeeId;
    private String employeeName;
    private DivisionDto division;
}
