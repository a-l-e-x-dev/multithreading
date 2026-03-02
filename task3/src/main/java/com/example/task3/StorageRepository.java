package com.example.task3;

import com.example.task3.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    @Modifying
    @Query(value = "UPDATE counter SET counter = counter + :delta WHERE id = :id", nativeQuery = true)
    void increaseByDelta(@Param("id") Long id, @Param("delta") Long delta);

}
