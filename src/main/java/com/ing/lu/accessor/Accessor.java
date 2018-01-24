package com.ing.lu.accessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.lu.data.MyBatis;
import com.ing.lu.data.MyBatisNeo4j;
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
            LinkedHashMap json =accessor.monsterQuery();

            ObjectMapper objectMapper = new ObjectMapper();
            QueryResult customer = objectMapper.convertValue(json, QueryResult.class);

            logger.info(json.toString());
            List<Person> personList = accessor.selectPerson();
            for (Person person : personList) {
                logger.info(person.getName() + " " + person.getBorn());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
        LinkedHashMap res=null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            BoltMapper boltMapper = sqlSession.getMapper(BoltMapper.class);
            res = boltMapper.monsterQuery();
        }
        return res;
    }
}
