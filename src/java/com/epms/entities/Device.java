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

/**
 *
 * @author yonatang
 */
@Entity
@Table(name = "device")

public class Device implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "Devicetype_Id")
    private Integer devicetypeId;
    @Column(name = "TestingPoint")
    private String testingPoint;
    @Column(name = "LastMaintenanceDate")
    private Date lastMaintenanceDate;
    @Column(name = "SeculededPreventiveMaintenaceDate")
    private Date seculededPreventiveMaintenaceDate;

    
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getDevicetypeId() {
        return devicetypeId;
    }

    public void setDevicetypeId(Integer devicetypeId) {
        this.devicetypeId = devicetypeId;
    }

    public String getTestingPoint() {
        return testingPoint;
    }

    public void setTestingPoint(String testingPoint) {
        this.testingPoint = testingPoint;
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public Date getSeculededPreventiveMaintenaceDate() {
        return seculededPreventiveMaintenaceDate;
    }

    public void setSeculededPreventiveMaintenaceDate(Date seculededPreventiveMaintenaceDate) {
        this.seculededPreventiveMaintenaceDate = seculededPreventiveMaintenaceDate;
    }

    
}
