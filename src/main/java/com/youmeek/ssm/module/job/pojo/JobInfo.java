package com.youmeek.ssm.module.job.pojo;

import java.util.Date;

public class JobInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.job_id
     *
     * @mbggenerated
     */
    private Integer jobId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.job_type
     *
     * @mbggenerated
     */
    private String jobType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.job_status
     *
     * @mbggenerated
     */
    private String jobStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.job_create_time
     *
     * @mbggenerated
     */
    private Date jobCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.job_modify_time
     *
     * @mbggenerated
     */
    private Date jobModifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column job_info.job_params
     *
     * @mbggenerated
     */
    private String jobParams;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.job_id
     *
     * @return the value of job_info.job_id
     *
     * @mbggenerated
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.job_id
     *
     * @param jobId the value for job_info.job_id
     *
     * @mbggenerated
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.user_name
     *
     * @return the value of job_info.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.user_name
     *
     * @param userName the value for job_info.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.job_type
     *
     * @return the value of job_info.job_type
     *
     * @mbggenerated
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.job_type
     *
     * @param jobType the value for job_info.job_type
     *
     * @mbggenerated
     */
    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.job_status
     *
     * @return the value of job_info.job_status
     *
     * @mbggenerated
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.job_status
     *
     * @param jobStatus the value for job_info.job_status
     *
     * @mbggenerated
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.job_create_time
     *
     * @return the value of job_info.job_create_time
     *
     * @mbggenerated
     */
    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.job_create_time
     *
     * @param jobCreateTime the value for job_info.job_create_time
     *
     * @mbggenerated
     */
    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.job_modify_time
     *
     * @return the value of job_info.job_modify_time
     *
     * @mbggenerated
     */
    public Date getJobModifyTime() {
        return jobModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.job_modify_time
     *
     * @param jobModifyTime the value for job_info.job_modify_time
     *
     * @mbggenerated
     */
    public void setJobModifyTime(Date jobModifyTime) {
        this.jobModifyTime = jobModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column job_info.job_params
     *
     * @return the value of job_info.job_params
     *
     * @mbggenerated
     */
    public String getJobParams() {
        return jobParams;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column job_info.job_params
     *
     * @param jobParams the value for job_info.job_params
     *
     * @mbggenerated
     */
    public void setJobParams(String jobParams) {
        this.jobParams = jobParams == null ? null : jobParams.trim();
    }
}