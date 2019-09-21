package com.tyss.hibernateAss;

import java.util.List;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class Implementation implements InterfaceFood {

	Scanner sc = new Scanner(System.in);
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction ts = null;

	public List<Food> showAllFoodItems() {

		emf = Persistence.createEntityManagerFactory("TestPersistence");
		em = emf.createEntityManager();
		String jpql = "from Food";
		Query query = em.createQuery(jpql);
		List<Food> al = query.getResultList();

		return al;
	}

	public boolean addFoodItem(Food food) {
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			ts = em.getTransaction();
			ts.begin();
			em.persist(food);
			ts.commit();
			return true;
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

	public boolean removeFood(int id) {

		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			ts = em.getTransaction();
			ts.begin();
			Food f = em.find(Food.class, id);
			em.remove(f);
			ts.commit();
			return true;
		} catch (Exception e) {
			ts.rollback();
			System.out.println("enter proper food id");
		} finally {
			em.close();
		}
		return false;
	}

	public boolean updateFood(int id) {
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			ts = em.getTransaction();
			ts.begin();
			Food f = em.find(Food.class, id);
			System.out.println("enter new food name");
			f.setFoodName(sc.nextLine());
			ts.commit();
			return true;
		} catch (Exception e) {
			ts.rollback();
			System.out.println("enter proper food id");
		} finally {
			em.close();
		}
		return false;
	}

	public double totalBill() {
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			ts = em.getTransaction();
			ts.begin();
			String jpql2 = "select sum(price) from Food";
			Query query = em.createQuery(jpql2);
			double sum = (Double) query.getSingleResult();
			ts.commit();
			return sum;

		} catch (Exception e) {
			ts.rollback();
			System.out.println("enter proper food id");
		} finally {
			em.close();
		}
		return 0;
	}

	public double userBill(int id) {
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			ts = em.getTransaction();
			ts.begin();
			Food f = em.find(Food.class, id);
			double d2 = f.getPrice();
			ts.commit();
			return d2;

		} catch (Exception e) {
			ts.rollback();
			System.out.println("enter proper food id");
		} finally {
			em.close();
		}
		return 0;

	}
}
