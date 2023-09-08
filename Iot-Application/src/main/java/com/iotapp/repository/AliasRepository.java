package com.iotapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iotapp.entity.Alias;
import com.iotapp.entity.CustomDto;

@Repository
public interface AliasRepository extends JpaRepository<Alias, Long>{
	
	@Query("SELECT new com.iotapp.entity.CustomDto(i.timestamp AS timestamp, i.value AS value) FROM Alias i WHERE i.device = :device AND i.aliasChannel = :aliasChannel")
	List<CustomDto> findTimestampAndValue(@Param("device") String device, @Param("aliasChannel") String aliasChannel);

}
