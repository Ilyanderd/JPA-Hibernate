package com.ilyanders.jpa_crud;

import com.ilyanders.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        try (entityManagerFactory; entityManager) {
            student = entityManager.find(Student.class, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(student);
    }
}
