package com.zeroesones.dataaccess;


import com.zeroesones.dto.Student;
import com.zeroesones.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Persistence logic using ORM tool Hibernate
public class StudentDaoImpl implements IStudentDao {

    Session session = HibernateUtil.getSession();

    @Override
    public Integer save(Student s) {
        Integer status = 0;
        Transaction transaction = session.beginTransaction();
        boolean flag = false;
        try {
            if (transaction != null) {
                session.save(s);
                flag = true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                transaction.commit();
                status = 1;
            } else {
                transaction.rollback();
            }
        }
        return status;
    }

    @Override
    public Student getById(Integer sid) {
        Student s = session.get(Student.class, sid);
        if (s != null) {
            return s;
        } else
            return null;
    }

    @Override
    public Integer updateById(Student s) {
        Integer status = 0;
        boolean flag = true;
        Transaction t = null;
        try {
            t = session.beginTransaction();
            if (s != null && t != null) {
                session.merge(s);
                flag = true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                t.commit();
                status = 1;
            } else {
                t.rollback();
                status = 0;
            }
        }
        return status;
    }


    @Override
    public Integer deleteById(Integer sid) {
        //load and delete
        Student s = getById(sid);
        Integer status = 0;
        Transaction transaction = session.beginTransaction();
        boolean flag = false;
        try {
            if (transaction != null) {
                if (s != null) {
                    session.delete(s);
                    flag = true;
                }
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                transaction.commit();
                status = 1;
            } else {
                transaction.rollback();
            }
        }
        return status;
    }
}
