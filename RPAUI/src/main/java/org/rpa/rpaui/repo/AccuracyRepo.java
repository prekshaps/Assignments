package org.rpa.rpaui.repo;

import org.rpa.rpaui.models.AccuracyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccuracyRepo extends JpaRepository<AccuracyData, Integer> {

}
