package spring_mvc_foodapp_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_mvc_foodapp_project.dto.User;

@Repository
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	public User saveUser(User user) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		return user;
	}

	public User loginUser(String email) {
		Query query = entityManager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		return user;
	}

	public User getUserById(int uid) {
		User user = entityManager.find(User.class, uid);
		if (user != null) {
			return user;
		} else
			return null;
	}

	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("select u from User u ");
		List<User> list = query.getResultList();
		return list;
	}

	public User getUserByRole(String role) {
		Query query = entityManager.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, role);
		User user = (User) query.getSingleResult();
		return user;
	}

	public List<User> getManagers(String role) {
		Query query = entityManager.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, role);
		List<User> list = query.getResultList();
		return list;
	}

	public User updateUser(User user) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(user);
		transaction.commit();
		return user;
	}
}
