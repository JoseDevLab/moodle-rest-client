package org.moodle.api.client.moodle_rest_client.domain.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class GradeItem {
    private Long id;
    private String itemName;
    private String itemType;
    private String itemModule;
    private Long itemInstance;
    private Long itemNumber;
    private String idNumber;
    private Long categoryId;
    private Long outcomeId;
    private Long scaleId;
    private boolean locked;
    private BigDecimal weightRaw;
    private String weightFormatted;
    private BigDecimal gradeRaw;
    private Long gradeDateSubmitted;
    private Long gradeDateGraded;
    private boolean gradeHiddenByDate;
    private boolean gradeNeedsUpdate;
    private boolean gradeIsHidden;
    private boolean gradeIsLocked;
    private boolean gradeIsOverridden;
    private String gradeFormatted;
    private BigDecimal gradeMin;
    private BigDecimal gradeMax;
    private String rangeFormatted;
    private String percentageFormatted;
    private String feedback;
    private int feedbackFormat;
}