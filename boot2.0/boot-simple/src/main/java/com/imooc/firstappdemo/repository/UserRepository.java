package com.imooc.firstappdemo.repository;

import com.imooc.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;
import sun.rmi.transport.ObjectTable;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 */
@Repository
public class UserRepository {


    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final AtomicInteger idGnerator = new AtomicInteger();

    /**
     * 保存用户对象
     *
     * @param user
     * @return
     */
    public boolean save(User user) {
        Integer id = idGnerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
