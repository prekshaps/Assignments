package org.rpa.rpaui.repo;
import org.rpa.rpaui.models.ParameterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepo extends JpaRepository<ParameterData, Integer>{

}
