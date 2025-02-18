package com.assignment.demo.dto;

import com.assignment.demo.entity.Address;
import lombok.Data;

@Data
public class CompanyDto {
    private String department;
    private String name;
    private String title;
    private AddressDto address;


    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompanyDto() {
    }
}
