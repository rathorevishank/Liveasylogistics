package com.liveasy.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liveasy.entities.Shipper;
import com.liveasy.services.ShipperService;

@RestController
@RequestMapping("/shippers")
public class ShipperController 
{
	@Autowired
	private ShipperService service;
	
	@GetMapping
	public List<Shipper> getAllShippers()
	{
		return service.getAllShippers();
	}
	@GetMapping("/{shipperId}")
	public Shipper getShipperById(@PathVariable UUID shipperId)
	{
		return service.getShipperById(shipperId);
	}
	@PostMapping
	public Shipper saveShipper(@RequestBody Shipper shipper)
	{
		return service.saveShipper(shipper);
	}
	@DeleteMapping("/{shipperId}")
	public String deleteShipper(@PathVariable UUID shipperId)
	{
		return service.deleteShipper(shipperId);
	}
}
