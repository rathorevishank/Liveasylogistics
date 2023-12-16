package com.liveasy.entities;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Load 
{
	  @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	            name = "UUID",
	            strategy = "org.hibernate.id.UUIDGenerator"
	    )
	    @Column(name = "load_id", updatable = false, nullable = false)
	    private UUID loadId;
	 private String loadingPoint;
	    private String unloadingPoint;
	    private String productType;
	    private String truckType;
	    private int noOfTrucks;
	    private double weight;
	    private String comment;
	    private String date;
	    @ManyToOne
	    @JoinColumn(name = "shipper_id")
	    private Shipper shipper;

	    // Constructors, getters, and setters

	    public Shipper getShipper() {
	        return shipper;
	    }

	    public void setShipper(Shipper shipper) {
	        this.shipper = shipper;
	    }
		
	
		public UUID getLoadId() {
			return loadId;
		}

		public void setLoadId(UUID loadId) {
			this.loadId = loadId;
		}

		public String getLoadingPoint() {
			return loadingPoint;
		}
		public void setLoadingPoint(String loadingPoint) {
			this.loadingPoint = loadingPoint;
		}
		public String getUnloadingPoint() {
			return unloadingPoint;
		}
		public void setUnloadingPoint(String unloadingPoint) {
			this.unloadingPoint = unloadingPoint;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}
		public String getTruckType() {
			return truckType;
		}
		public void setTruckType(String truckType) {
			this.truckType = truckType;
		}
		public int getNoOfTrucks() {
			return noOfTrucks;
		}
		public void setNoOfTrucks(int noOfTrucks) {
			this.noOfTrucks = noOfTrucks;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
	
	    
}
