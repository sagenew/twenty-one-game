package com.listener.repository;

import com.listener.entity.CustomMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMessageRepo extends CrudRepository<CustomMessage, Long> { }
