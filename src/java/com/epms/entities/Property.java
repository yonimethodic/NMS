/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author yonatang
 */
@Entity
@Table(name = "property")

public class Property implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "PROPERTY_ID")
    private Integer id;
    @Column(name = "SCOPE")
    private String scope;
    @Column(name = "ENTITY_TYPE")
    private String entityType;
    @Column(name = "ENTITY_VALUE")
    private String entityValue;
    
    @Column(name = "KEY")
    private String key;
    
    @Column(name = "VALUE")
    private String value;
    @Column(name = "CREATED_TIMESTAMP")
    private String createdTimestamp;
    @Column(name = "UPDATED_TIMESTAMP")
    private String updatedTimestamp;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "ARCHIVING_STATUS_ID")
    private String archivingStatusId;

    public Property() {
    }

    public Property(Integer propertyId) {
        this.id = propertyId;
    }

    public Integer getPropertyId() {
        return id;
    }

    public void setPropertyId(Integer propertyId) {
        this.id = propertyId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(String entityValue) {
        this.entityValue = entityValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getArchivingStatusId() {
        return archivingStatusId;
    }

    public void setArchivingStatusId(String archivingStatusId) {
        this.archivingStatusId = archivingStatusId;
    }

   
    
}
