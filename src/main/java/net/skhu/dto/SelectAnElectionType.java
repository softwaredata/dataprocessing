package net.skhu.dto;

import lombok.Getter;

@Getter
public enum SelectAnElectionType {
    CHAIRPERSON_OF_THE_TOTAL_STUDENT(1), FACULTY_REPRESENTATIVE(2), MAJOR_REPRESENTATIVE(3);

    private int type;

    SelectAnElectionType(int type) {
        this.type = type;
    }
}
