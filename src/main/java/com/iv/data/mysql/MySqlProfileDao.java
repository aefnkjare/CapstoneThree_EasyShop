package com.iv.data.mysql;

import com.iv.models.Product;
import com.iv.models.Profile;
import org.springframework.stereotype.Component;
import com.iv.data.ProfileDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class MySqlProfileDao extends MySqlDaoBase implements ProfileDao
{
    public MySqlProfileDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public Product add(Product product) {
        return null;
    }

    @Override
    public List<Product> getByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public Profile create(Profile profile)
    {
        String sql = "INSERT INTO profiles (user_id, first_name, last_name, phone, email, address, city, state, zip) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, profile.getUserId());
            ps.setString(2, profile.getFirstName());
            ps.setString(3, profile.getLastName());
            ps.setString(4, profile.getPhone());
            ps.setString(5, profile.getEmail());
            ps.setString(6, profile.getAddress());
            ps.setString(7, profile.getCity());
            ps.setString(8, profile.getState());
            ps.setString(9, profile.getZip());

            ps.executeUpdate();

            return profile;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Profile getByUserId(int userId) {
        return null;
    }

    @Override
    public Profile update(Profile profile) {
        return null;
    }

}
