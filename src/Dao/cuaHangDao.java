/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author NGUYEN TRI TUE
 */
public abstract class cuaHangDao<E,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K Key);
    abstract public List<E> selectAll();
    abstract public E selectById(K key);
    abstract protected List<E> selectBySql(String sql,Object...args);
}