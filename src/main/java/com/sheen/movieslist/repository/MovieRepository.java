package com.sheen.movieslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sheen.movieslist.models.Movie;

// JpaRepository automatically gives methods like: save, findAll, deletById, update...
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // Java generics uses object not primitives. The type of id was int, so I changed it from int to Integer
    // Java automatically convert between int and Integer (autoboxing)
}
