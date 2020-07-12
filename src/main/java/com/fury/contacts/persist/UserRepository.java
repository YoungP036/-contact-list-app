package com.fury.contacts.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fury.contacts.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}