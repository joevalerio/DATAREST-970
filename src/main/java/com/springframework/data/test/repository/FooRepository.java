package com.springframework.data.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.data.test.model.Foo;

public interface FooRepository extends JpaRepository<Foo, String>{

}
