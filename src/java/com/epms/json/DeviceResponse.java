/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.json;

import com.epms.entities.Device;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public class DeviceResponse {

    /**
     * Current page of the query
     */
    private String page;

    /**
     * Total pages for the query
     */
    private String total;

    /**
     * Total number of records for the query
     */
    private String records;

    /**
     * An array that contains the actual objects
     */
    private List<Device> rows;

    public DeviceResponse() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public List<Device> getRows() {
        return rows;
    }

    public void setRows(List<Device> rows) {
        this.rows = rows;
    }

    
}
