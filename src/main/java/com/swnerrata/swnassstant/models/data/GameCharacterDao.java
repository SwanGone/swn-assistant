package com.swnerrata.swnassstant.models.data;

import com.swnerrata.swnassstant.models.GameCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by seanburk on 7/28/17.
 */
@Transactional
@Repository
public interface GameCharacterDao extends CrudRepository<GameCharacter, Integer> {



}
