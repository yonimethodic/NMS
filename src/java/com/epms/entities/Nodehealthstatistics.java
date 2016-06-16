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
@Table(name = "nodehealthstatistics")

public class Nodehealthstatistics implements Serializable {
   
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;
    @Column(name = "LogDate")
    private Date logDate;
    @Column(name = "Lat")
    private String lat;
    @Column(name = "Long")
    private String long1;
    @Column(name = "BatteryStatus")
    private String batteryStatus;
    @Column(name = "NetworkSignalStrength")
    private String networkSignalStrength;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getNetworkSignalStrength() {
        return networkSignalStrength;
    }

    public void setNetworkSignalStrength(String networkSignalStrength) {
        this.networkSignalStrength = networkSignalStrength;
    }

    
    
}
