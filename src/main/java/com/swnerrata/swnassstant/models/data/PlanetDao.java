package com.swnerrata.swnassstant.models.data;

import com.swnerrata.swnassstant.models.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by seanburk on 8/1/17.
 */
@Transactional
@Repository
public interface PlanetDao extends CrudRepository<Planet, Integer> {
}
