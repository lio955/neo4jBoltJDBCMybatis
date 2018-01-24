package com.ing.lu.accessor;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by lionel on 30/12/16.
 */
public interface BoltMapper {
    public List<Person> selectPerson() throws Exception;

    public LinkedHashMap monsterQuery();
}
