package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.gradereport.gradeitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GradeItemDTO {
    private Long id;
    @JsonProperty("itemname")
    private String itemName;
    @JsonProperty("itemtype")
    private String itemType;
    @JsonProperty("itemmodule")
    private String itemModule;
    @JsonProperty("iteminstance")
    private Long itemInstance;
    @JsonProperty("itemnumber")
    private Long itemNumber;
    @JsonProperty("idnumber")
    private String idNumber;
    @JsonProperty("categoryid")
    private Long categoryId;
    @JsonProperty("outcomeid")
    private Long outcomeId;
    @JsonProperty("scaleid")
    private Long scaleId;
    private boolean locked;
    @JsonProperty("weightraw")
    private BigDecimal weightRaw;
    @JsonProperty("weightformatted")
    private String weightFormatted;
    @JsonProperty("graderaw")
    private BigDecimal gradeRaw;
    @JsonProperty("gradedatesubmitted")
    private Long gradeDateSubmitted;
    @JsonProperty("gradedategraded")
    private Long gradeDateGraded;
    @JsonProperty("gradehiddenbydate")
    private boolean gradeHiddenByDate;
    @JsonProperty("gradeneedsupdate")
    private boolean gradeNeedsUpdate;
    @JsonProperty("gradeishidden")
    private boolean gradeIsHidden;
    @JsonProperty("gradeislocked")
    private boolean gradeIsLocked;
    @JsonProperty("gradeisoverridden")
    private boolean gradeIsOverridden;
    @JsonProperty("gradeformatted")
    private String gradeFormatted;
    @JsonProperty("grademin")
    private BigDecimal gradeMin;
    @JsonProperty("grademax")
    private BigDecimal gradeMax;
    @JsonProperty("rangeformatted")
    private String rangeFormatted;
    @JsonProperty("percentageformatted")
    private String percentageFormatted;
    private String feedback;
    @JsonProperty("feedbackformat")
    private int feedbackFormat;
}