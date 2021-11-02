package com.blizzard.todoapi.repository;

import com.blizzard.todoapi.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends MongoRepository<Todo, String> {}
