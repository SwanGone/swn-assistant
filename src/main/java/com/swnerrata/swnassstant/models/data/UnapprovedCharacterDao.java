package com.swnerrata.swnassstant.models.data;

import com.swnerrata.swnassstant.models.UnapprovedCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by seanburk on 8/2/17.
 */
@Transactional
@Repository
public interface UnapprovedCharacterDao extends CrudRepository<UnapprovedCharacter, Integer>{



}
