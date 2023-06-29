package com.iv.data.mysql;

import com.iv.configuration.TestDatabaseConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
public abstract class BaseDaoTestClass
{
    @Autowired
    protected DataSource dataSource;

    @AfterEach
    public void rollback() throws SQLException
    {
        Connection connection = dataSource.getConnection();
        if(!connection.getAutoCommit())
        {
            dataSource.getConnection().rollback();
        }
    }
}
