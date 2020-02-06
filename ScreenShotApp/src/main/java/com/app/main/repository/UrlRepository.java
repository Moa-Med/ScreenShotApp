package com.app.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.main.model.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long> {

}
