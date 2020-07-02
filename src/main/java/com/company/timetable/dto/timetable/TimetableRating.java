package com.company.timetable.dto.timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TimetableRating {

    COMPLETELY_CORRECT(3),
    NEEDS_IMPROVEMENT(2),
    WRONG(1);

    private final Integer rating;
}
