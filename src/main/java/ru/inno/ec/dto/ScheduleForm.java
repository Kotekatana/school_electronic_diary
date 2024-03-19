package ru.inno.ec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleForm {
    private Long disciplineId;
    private Long groupId;
    private String date;
    private Integer lessonNumber;
}
