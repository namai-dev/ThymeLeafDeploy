package com.amo.amo.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<ProductFile, Long> {
    Optional<ProductFile>findByName(String name);
}
