package com.samyak.forex.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samyak.forex.data.entity.ExchangeEntity;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {

	ExchangeEntity findByFromAndTo(String from, String to);
}
