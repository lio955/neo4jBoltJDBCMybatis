package fr.triple.data.accessor;

import fr.triple.data.data.MyBatisNeo4j;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by lionel on 30/12/16.
 */
public class Accessor implements BoltMapper {
    private static Logger logger = LoggerFactory.getLogger(Accessor.class);

    private MyBatisNeo4j myBatisNeo4j;

    public Accessor() throws Exception {
        List<String> mappers = new ArrayList<>();
        mappers.add("bolt-mapper.xml");
        myBatisNeo4j = new MyBatisNeo4j(mappers);
    }

    public static void main(String[] args) {
        try {
            Accessor accessor = new Accessor();
            Person person = accessor.SELECT_1_PERSON("Blake");
           List< PersonCompany> personCompany = accessor.SELECT_PERSON_COMPANY("Leonora");



          /*  LinkedHashMap json = accessor.monsterQuery();

            ObjectMapper objectMapper = new ObjectMapper();
            QueryResult customer = objectMapper.convertValue(json, QueryResult.class);

            logger.info(json.toString());
            List<Person> personList = accessor.selectPerson();
            for (Person person : personList) {
                logger.info(person.getName() + " " + person.getBorn());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<PersonCompany> SELECT_PERSON_COMPANY(String firstname) {
        List<PersonCompany> person = null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            BoltMapper boltMapper = sqlSession.getMapper(BoltMapper.class);
            person = boltMapper.SELECT_PERSON_COMPANY(firstname);
            logger.info(person.toString());


        }
        return person;
    }

    @Override
    public Person SELECT_1_PERSON(String firstname) {
        Person person = null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            BoltMapper boltMapper = sqlSession.getMapper(BoltMapper.class);
            person = boltMapper.SELECT_1_PERSON(firstname);
            logger.info(person.toString());

            person = boltMapper.SELECT_1_PERSON("Libby");
            logger.info(person.toString());

        }
        return person;
    }

    @Override
    public List<Person> selectPerson() throws Exception {
        List<Person> personList = null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            BoltMapper boltMapper = sqlSession.getMapper(BoltMapper.class);
            personList = boltMapper.selectPerson();
        }
        return personList;
    }

    @Override
    public LinkedHashMap monsterQuery() {
        LinkedHashMap res = null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            BoltMapper boltMapper = sqlSession.getMapper(BoltMapper.class);
            res = boltMapper.monsterQuery();
        }
        return res;
    }
}
