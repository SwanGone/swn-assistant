package com.swnerrata.swnassstant.models.data;

import com.swnerrata.swnassstant.models.PsychicDiscipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by seanburk on 8/1/17.
 */
@Transactional
@Repository
public interface PsychicDisciplineDao extends CrudRepository<PsychicDiscipline, Integer> {

    List<PsychicDiscipline> findByApproved(boolean approved);

}
