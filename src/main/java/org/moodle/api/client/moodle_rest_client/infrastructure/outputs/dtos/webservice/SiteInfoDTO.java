package org.moodle.api.client.moodle_rest_client.infrastructure.outputs.dtos.webservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteInfoDTO {
    @JsonProperty("sitename")
    private String siteName;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("fullname")
    private String fullName;
    private String lang;
    @JsonProperty("userid")
    private Long userId;
    @JsonProperty("siteurl")
    private String siteUrl;
    @JsonProperty("userpictureurl")
    private String userPictureUrl;
    private List<FunctionDTO> functions;
    @JsonProperty("downloadfiles")
    private Integer downloadFiles;
    @JsonProperty("uploadfiles")
    private Integer uploadFiles;
    private String release;
    private String version;
    @JsonProperty("mobilecssurl")
    private String mobileCssUrl;
    @JsonProperty("advancedfeatures")
    private List<AdvancedFeatureDTO> advancedFeatures;
    @JsonProperty("usercanmanageownfiles")
    private Boolean userCanManageOwnFiles;
    @JsonProperty("userquota")
    private Integer userQuota;
    @JsonProperty("usermaxuploadfilesize")
    private Integer userMaxUploadFileSize;
    @JsonProperty("userhomepage")
    private Integer userHomePage;
    @JsonProperty("userhomepageurl")
    private String userHomePageUrl;
    @JsonProperty("userprivateaccesskey")
    private String userPrivateAccessKey;
    @JsonProperty("siteid")
    private Long siteId;
    @JsonProperty("sitecalendartype")
    private String siteCalendarType;
    @JsonProperty("usercalendartype")
    private String userCalendarType;
    @JsonProperty("userissiteadmin")
    private Boolean userIsSiteAdmin;
    private String theme;
    @JsonProperty("limitconcurrentlogins")
    private Integer limitConcurrentLogins;
    @JsonProperty("usersessionscount")
    private Integer userSessionsCount;
    @JsonProperty("policyagreed")
    private Integer policyAgreed;
}
