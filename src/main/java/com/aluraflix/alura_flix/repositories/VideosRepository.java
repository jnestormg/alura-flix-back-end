package com.aluraflix.alura_flix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluraflix.alura_flix.entities.Videos;

@Repository
public interface VideosRepository  extends JpaRepository<Videos, Long>{

}
