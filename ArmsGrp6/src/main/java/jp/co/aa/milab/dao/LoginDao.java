package jp.co.aa.milab.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
    JdbcTemplate jdbcTemplate;

	// ID、PWでユーザー情報を検索する
    public List<Map<String, Object>> searchUser(String id, String pass) {
        String sql = "SELECT userid,username,systemauthorityno FROM user WHERE userid = ? AND password = ?";
        Object[] param = {id, pass};
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);
        return list;
    }

}
