package com.ise.broker.sql.repositories;

import com.ise.broker.sql.entities.CurrentlyOwnedAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentlyOwnedAssetsRepository extends JpaRepository<CurrentlyOwnedAssets, Long> {
}
