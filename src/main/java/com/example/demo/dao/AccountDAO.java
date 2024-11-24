package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Account;
import com.example.demo.form.AccountForm;

@Transactional
@Repository
public class AccountDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public Account findAccount(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Account.class, userName);
    }

    public void save(AccountForm accountForm) {
        Session session = this.sessionFactory.getCurrentSession();
    
        // Sử dụng constructor tiện ích để khởi tạo tài khoản
        Account account = new Account(
            accountForm.getUserName(),
            accountForm.getPassword(),
            true,
            accountForm.getRole()
        );
    
        session.persist(account);
    }
    
 
}
