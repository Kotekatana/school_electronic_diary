package ru.inno.ec.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.inno.ec.models.User;
import ru.inno.ec.repositories.UsersRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account";

    //language=SQL
    private static final String SQL_INSERT = "insert into account(email, password) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    private final static RowMapper<User> userRowMapper = (row, rowNum) ->
            User.builder()
                    .id(row.getLong("id"))
                    .email(row.getString("email"))
                    .password(row.getString("password"))
                    .build();

    @Override
    public List<User> findAll(String orderByColumn, String direction) {
        String resultQuery = SQL_SELECT_ALL;

        if (orderByColumn != null && !orderByColumn.contains(" ")) {
            resultQuery += " order by " + orderByColumn;
        }

        if (direction != null && (direction.equals("asc") || direction.equals("desc"))) {
            resultQuery += " " + direction;
        }

        return jdbcTemplate.query(resultQuery, userRowMapper);
    }

    @Override
    public void save(User newUser) {
        jdbcTemplate.update(SQL_INSERT, newUser.getEmail(), newUser.getPassword());
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
    }
}
