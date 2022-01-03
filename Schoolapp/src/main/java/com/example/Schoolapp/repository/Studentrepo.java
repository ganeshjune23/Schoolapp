package com.example.Schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Schoolapp.entity.Students;

public interface Studentrepo extends JpaRepository<Students, Integer> {

}
