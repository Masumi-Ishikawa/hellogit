package jp.co.aa.milab.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aa.milab.dao.LoginDao;
import jp.co.aa.milab.dao.UserDao;
import jp.co.aa.milab.form.UserForm;


@Service
public class UserService {

	@Autowired
    LoginDao loginDao;


	@Autowired
	UserDao userDao;


	// ID、PWで名前を取得
    public String searchUserName(String id, String pass) {
        String name = "";
        List<Map<String, Object>> list = loginDao.searchUser(id, pass);
        if(list.size() > 0) {
            name = (String)list.get(0).get("username");
        }

        return name;
    }

    public String searchUserSystem(String id, String pass) {
        String system ="";
        List<Map<String, Object>> list = loginDao.searchUser(id, pass);
        if(list.size() > 0) {
            system = (String)list.get(0).get("systemauthorityno");
        }

        return system;
    }

	// ユーザー情報新規登録メソッド
	public int inputUser(UserForm userForm) {
		int count = userDao.inputUser(userForm);
		return count;
	}

	// ユーザー情報編集メソッド
	public int updateUser(UserForm userForm) {
		int count = userDao.updateUser(userForm);
		return count;
	}

}
