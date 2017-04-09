package com.epam.mentoring.db.aop;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.epam.mentoring.db.api.RsColumnMapper;
import com.epam.mentoring.db.api.RsColumnMappers;
import com.epam.mentoring.db.api.Select;

@Aspect
@Component
public class RepositoryAspect {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Around("@target(com.epam.mentoring.db.api.Repository)"
            + " && @annotation(select)"
            + " && @annotation(mappers)")
    public Object doSelect(ProceedingJoinPoint pjp, Select select, RsColumnMappers mappers) throws Throwable {
        return jdbcTemplate.query(select.value(), (rs, num) -> {
            try {
                Class<?> modelClass = mappers.modelType();
                Object obj = modelClass.newInstance();
                for (RsColumnMapper mapper : mappers.value()) {
                    Object columnValue = rs.getObject(mapper.columnName());
                    BeanUtils.setProperty(obj, mapper.propertyName(), columnValue);
                }
                return obj;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
