package com.liveasy.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liveasy.entities.Load;

public interface LoadRepository extends JpaRepository<Load, UUID>
{
	 List<Load> findByShipper_ShipperId(UUID shipperId);
}
