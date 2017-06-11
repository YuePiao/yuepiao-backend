package edu.sysu.yuepiao.dao;

import javax.transaction.Transactional;

import edu.sysu.yuepiao.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by moret on 2017/6/5.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
} // class UserDao