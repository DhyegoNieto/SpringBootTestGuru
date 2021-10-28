package io.boot.test.mapstruct;

import io.boot.test.mapper.EmployeeMapper;
import io.boot.test.model.Division;
import io.boot.test.model.DivisionDto;
import io.boot.test.model.Employee;
import io.boot.test.model.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeMapperTest {

    private EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    @Test
    public void entityToDto() {
        Employee entity = new Employee(1, "Diego", new Division(1, "IT"));

        EmployeeDto dto = mapper.entityToDto(entity);

        assertThat(dto.getEmployeeId()).isEqualTo(entity.getId());
        assertThat(dto.getEmployeeName()).isEqualTo(entity.getName());
        assertThat(dto.getDivision().getName()).isEqualTo(entity.getDivision().getName());
    }

    @Test
    public void dtoToEntity() {
        EmployeeDto dto = new EmployeeDto(1, "Diego", new DivisionDto(1, "IT"));

        Employee entity = mapper.dtoToEntity(dto);

        assertThat(entity.getId()).isEqualTo(dto.getEmployeeId());
        assertThat(entity.getName()).isEqualTo(dto.getEmployeeName());
        assertThat(entity.getDivision().getName()).isEqualTo(dto.getDivision().getName());
    }
}
