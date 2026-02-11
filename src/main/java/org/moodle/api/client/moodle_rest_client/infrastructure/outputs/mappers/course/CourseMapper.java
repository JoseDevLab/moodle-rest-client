package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.moodle.api.client.moodle_rest_client.domain.models.*;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.*;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.CourseSearch;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.course.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.course.course.*;
import org.moodle.api.client.moodle_rest_client.infrastructure.outputs.mappers.NameValueMapper;

import java.util.List;

@Mapper(uses = NameValueMapper.class)
public interface CourseMapper {
    default int map(boolean value){
        return value ? 1 : 0;
    }
    default boolean map(int value){
        return value == 1;
    }
    default Integer map(Boolean value){ return value == null ? null : value ? 1 : 0;}
    default Boolean map(Integer value){ return value == null ? null : value == 1;}
    CustomField toDomain(CustomField dto);
    List<CustomField> toCustomFieldsDomain(List<CustomFieldDTO> dtos);
    Course toDomain(CourseDTO dto);
    List<Course> toDomain(List<CourseDTO> dtos);
    CourseFormatOption toDomain(CourseFormatOptionDTO dto);
    Section toDomain(SectionDTO dto);
    List<Section> toSectionDomain(List<SectionDTO> dtos);
    CourseContentModule toDomain(CourseContentModuleDTO dto);
    CourseModule toDomain(CourseModuleDTO dto);
    CompletionData toDomain(CompletionDataDTO dto);
    ActivityBadge toDomain(ActivityBadgeDTO dto);
    BadgeExtraAttribute toDomain(BadgeExtraAttributeDTO dto);
    CompletionDetail toDomain(CompletionDetailDTO dto);
    CompletionRuleValue toDomain(CompletionRuleValueDTO dto);
    CourseDate toDomain(CourseDateDTO dto);
    Tag toDomain(TagDTO dto);
    CourseContent toDomain(CourseContentDTO dto);
    ContentsInfo toDomain(ContentsInfoDTO dto);
    CourseSearch toDomain(CourseSearchResponseDTO dto);
    @Mapping(source = "shortname", target = "shortName")
    @Mapping(source = "valueraw", target = "valueRaw")
    CustomField toDomain(CustomFieldResponseDTO dto);

    CreateCourseRequestDTO toRequestDTO(CreateCourseRequest request);
    UpdateCourseRequestDTO toRequestDTO(UpdateCourseRequest request);
    DeleteCourseRequestDTO toRequestDTO(DeleteCourseRequest request);
    DuplicateCourseRequestDTO toRequestDTO(DuplicateCourseRequest request);
    ImportCourseRequestDTO toRequestDTO(ImportCourseRequest request);
    CourseFormatOptionDTO toRequestDTO(CourseFormatOption option);
    @Mapping(source = "shortName", target = "shortname")
    CustomFieldRequestDTO toRequestDTO(CustomFieldRequest request);
    ImportOptionRequestDTO toRequestDTO(ImportOptionRequest option);
}
