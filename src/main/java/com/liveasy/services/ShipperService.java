package com.liveasy.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveasy.entities.Shipper;
import com.liveasy.repositories.ShipperRepository;

@Service
public class ShipperService
{
	@Autowired
	private ShipperRepository shipperRepository;
	
    public List<Shipper> getAllShippers()
    {
    	return shipperRepository.findAll();
    }
    public Shipper getShipperById(UUID shipperId)
    {
    	return shipperRepository.findById(shipperId).orElse(null);
    }
    public Shipper saveShipper(Shipper shipper)
    {
    	return shipperRepository.save(shipper);
    }
    public String deleteShipper(UUID shipperId)
    {
    	shipperRepository.deleteById(shipperId);
    	return "Shipper : "+shipperId+" deleted succesfully";
    }
}
