package com.example.ipk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TextMessageRepository extends CrudRepository<TextMessage, Long> {

    public List<TextMessage> findByContact(String contact);
}
