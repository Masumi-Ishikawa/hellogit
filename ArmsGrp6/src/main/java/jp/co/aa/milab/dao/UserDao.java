package jp.co.aa.milab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.aa.milab.form.UserForm;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// データーベースへユーザー情報新規登録
	public int inputUser(UserForm userForm) {

		String sql = "INSERT INTO user (userid, username, password, agreementno) VALUES(?, ?, ?, ?)";
		Object[] param = {userForm.getUserid(), userForm.getUsername(), userForm.getPassword(), userForm.getAgreementno()};
		int result = jdbcTemplate.update(sql, param);

		return result;

	}

	// データーベースへユーザー情報編集
	public int updateUser(UserForm userForm) {

		String sql = "UPDATE user SET userid = ?, username = ?, password = ?, agreementno = ? WHERE userid = ?";
		Object[] param = {userForm.getUserid(), userForm.getUsername(), userForm.getPassword(), userForm.getAgreementno(), userForm.getUserid()};
		int result = jdbcTemplate.update(sql, param);

		return result;
	}

}
