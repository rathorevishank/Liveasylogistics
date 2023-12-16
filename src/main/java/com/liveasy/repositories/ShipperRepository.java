package com.liveasy.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveasy.entities.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, UUID>
{

}
