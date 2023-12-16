package com.liveasy.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Shipper 
{
	 @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	            name = "UUID",
	            strategy = "org.hibernate.id.UUIDGenerator"
	    )
	
	    @Column(name = "shipper_id", updatable = false, nullable = false)
	    private UUID shipperId; // Unique identifier

    private String shipperName;
    private String contactNumber;
    private String emailAddress;
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy = "shipper",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Load> loads;
	public UUID getShipperId() {
		return shipperId;
	}
	public void setShipperId(UUID shipperId) {
		this.shipperId = shipperId;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Load> getLoads() {
		return loads;
	}
	public void setLoads(List<Load> loads) {
		this.loads = loads;
	}
    
    
}
