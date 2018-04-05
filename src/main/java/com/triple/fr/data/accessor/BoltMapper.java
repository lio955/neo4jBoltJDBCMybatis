package fr.triple.data.accessor;

import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by lionel on 30/12/16.
 */
public interface BoltMapper {
    public List<Person> selectPerson() throws Exception;

    public LinkedHashMap monsterQuery();

    public Person SELECT_1_PERSON(@Param(value = "firstname") String firstname);

    public List<PersonCompany> SELECT_PERSON_COMPANY(@Param(value = "firstname") String firstname);
}
