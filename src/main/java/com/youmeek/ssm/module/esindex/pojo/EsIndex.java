package com.youmeek.ssm.module.esindex.pojo;

import java.util.Date;

public class EsIndex {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column es_index.index_id
     *
     * @mbggenerated
     */
    private Integer indexId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column es_index.index_name
     *
     * @mbggenerated
     */
    private String indexName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column es_index.type_name
     *
     * @mbggenerated
     */
    private String typeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column es_index.index_create_time
     *
     * @mbggenerated
     */
    private Date indexCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column es_index.index_modify_time
     *
     * @mbggenerated
     */
    private Date indexModifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column es_index.index_mapping_field
     *
     * @mbggenerated
     */
    private String indexMappingField;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column es_index.index_id
     *
     * @return the value of es_index.index_id
     *
     * @mbggenerated
     */
    public Integer getIndexId() {
        return indexId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column es_index.index_id
     *
     * @param indexId the value for es_index.index_id
     *
     * @mbggenerated
     */
    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column es_index.index_name
     *
     * @return the value of es_index.index_name
     *
     * @mbggenerated
     */
    public String getIndexName() {
        return indexName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column es_index.index_name
     *
     * @param indexName the value for es_index.index_name
     *
     * @mbggenerated
     */
    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column es_index.type_name
     *
     * @return the value of es_index.type_name
     *
     * @mbggenerated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column es_index.type_name
     *
     * @param typeName the value for es_index.type_name
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column es_index.index_create_time
     *
     * @return the value of es_index.index_create_time
     *
     * @mbggenerated
     */
    public Date getIndexCreateTime() {
        return indexCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column es_index.index_create_time
     *
     * @param indexCreateTime the value for es_index.index_create_time
     *
     * @mbggenerated
     */
    public void setIndexCreateTime(Date indexCreateTime) {
        this.indexCreateTime = indexCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column es_index.index_modify_time
     *
     * @return the value of es_index.index_modify_time
     *
     * @mbggenerated
     */
    public Date getIndexModifyTime() {
        return indexModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column es_index.index_modify_time
     *
     * @param indexModifyTime the value for es_index.index_modify_time
     *
     * @mbggenerated
     */
    public void setIndexModifyTime(Date indexModifyTime) {
        this.indexModifyTime = indexModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column es_index.index_mapping_field
     *
     * @return the value of es_index.index_mapping_field
     *
     * @mbggenerated
     */
    public String getIndexMappingField() {
        return indexMappingField;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column es_index.index_mapping_field
     *
     * @param indexMappingField the value for es_index.index_mapping_field
     *
     * @mbggenerated
     */
    public void setIndexMappingField(String indexMappingField) {
        this.indexMappingField = indexMappingField == null ? null : indexMappingField.trim();
    }
}