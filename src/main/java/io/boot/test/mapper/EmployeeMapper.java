package io.boot.test.mapper;

import io.boot.test.model.Division;
import io.boot.test.model.DivisionDto;
import io.boot.test.model.Employee;
import io.boot.test.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeMapper {
    @Mappings({
        @Mapping(target = "employeeId", source = "entity.id"),
        @Mapping(target = "employeeName", source = "entity.name")
    })
    EmployeeDto entityToDto(Employee entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.employeeId"),
            @Mapping(target = "name", source = "dto.employeeName")
    })
    Employee dtoToEntity(EmployeeDto dto);

    DivisionDto divisionEntityToDto(Division entity);

    Division DivisionDtoToEntity(DivisionDto dto);
}