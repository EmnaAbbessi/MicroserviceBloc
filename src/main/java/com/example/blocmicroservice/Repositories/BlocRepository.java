package com.example.blocmicroservice.Repositories;

import com.example.blocmicroservice.entities.Bloc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    @Query("select c from Bloc c where c.nomBloc like :name")
    public Page<Bloc> candidatByNom(@Param("name") String n, Pageable pageable);
}
