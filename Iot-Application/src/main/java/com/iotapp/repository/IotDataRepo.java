package com.iotapp.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iotapp.entity.IotData;


@Repository
public interface IotDataRepo extends JpaRepository<IotData, Long>{
	List<IotData> findByDeviceAndChannel(String device, String channel);

}
