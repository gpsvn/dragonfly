package com.inspireon.dragonfly.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.Repository;
 
/***  
 * * A generic DAO interface definition.  This interface should be extended
  * even if the new interface will add no additional functions.
  * 
  * @author phuongnd11
  *
  * @param <T> The class of the pojo being persisted.
  * @param <I> the class of the pojo's id property.
  */
  public interface BaseRepo<T,I extends Serializable> extends Repository<T, I>{
     /**
      * Get the object with the id specified.
      * 
      * @param id the id of the instance to retrieve.
      * 
      * @return the instance with the given id.
      */
     T find(I id);
     
     /**
      * Get all instances that match the properties that are set in the given 
      * object using a standard Query by Example method.
      *  
      * @param t the example bean
      * 
      * @return a list of beans that match the example.
      * (now we don't see that we really need this feature for every repository, 
      * then currently this feature was temporarily commented, we can open it later)
      * 
      */
//     List<T> find(T t);
     
     /**
      * Get all instances of this bean that have been persisted.
      * 
      * @return a list of all instances.
      */
     List<T> findAll();
     
     /**
      * Persist the given bean.
      * 
      * @param t the bean to persist.
      */
     void add(T t);
     
     /**
      * Persist the given bean.
      * 
      * @param t the bean to persist.
      */
     void store(T t);
     
     /**
      * Remove the bean passed.  same as remove(t.<idProoertyGetter>())
      * 
      * @param t the object to remove.
      */
     void remove(T t);
 }
