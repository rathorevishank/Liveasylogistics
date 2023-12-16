package com.liveasy.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.service.connection.ConnectionDetailsNotFoundException;
import org.springframework.stereotype.Service;

import com.liveasy.entities.Load;
import com.liveasy.entities.Shipper;
import com.liveasy.repositories.LoadRepository;

@Service
public class LoadService {
    @Autowired
    private LoadRepository loadRepository;

    @Autowired
    private ShipperService shipperService;

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipper_ShipperId(shipperId);
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId)
                .orElseThrow(() -> new ConnectionDetailsNotFoundException("Load not found with id: " + loadId));
    }

    public Load saveLoad(Load load) {
        return loadRepository.save(load);
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }

   
    public Load saveLoadWithShipper(UUID shipperId, Load load) {
        Shipper shipper = shipperService.getShipperById(shipperId);

        if (shipper == null) {
            throw new ConnectionDetailsNotFoundException("Shipper with ID " + shipperId + " not found");
        }

        load.setShipper(shipper);

        return loadRepository.save(load);
    }

    public Load updateLoad(UUID loadId, Load updatedLoad,UUID shipperId) {
        Load existingLoad = getLoadById(loadId);
        Shipper getShipper= shipperService.getShipperById(shipperId);
        System.out.println("Updating load with ID: " + loadId + " for shipper with ID: " + shipperId);

        if (getShipper == null) {
        	 System.err.println("Shipper with ID " + shipperId + " not found");
            throw new ConnectionDetailsNotFoundException("Shipper with ID " + shipperId + " not found");
        }
      

        existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
        existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
        existingLoad.setProductType(updatedLoad.getProductType());
        existingLoad.setTruckType(updatedLoad.getTruckType());
        existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
        existingLoad.setWeight(updatedLoad.getWeight());
        existingLoad.setComment(updatedLoad.getComment());
        existingLoad.setDate(updatedLoad.getDate());
        existingLoad.setShipper(getShipper);

       

        return loadRepository.save(existingLoad);
    }
}