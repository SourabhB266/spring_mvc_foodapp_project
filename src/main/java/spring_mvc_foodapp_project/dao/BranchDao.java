package spring_mvc_foodapp_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_mvc_foodapp_project.dto.Branch;
import spring_mvc_foodapp_project.dto.User;

@Repository
public class BranchDao {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private UserDao dao;

	public Branch saveBranch(Branch branch) {
		EntityTransaction transaction = entityManager.getTransaction();
		User user = dao.getUserByRole("admin");
		transaction.begin();
		branch.setUser(user);
		entityManager.persist(branch);
		transaction.commit();
		return branch;
	}

	public List<Branch> getAllBranchs() {
		Query query = entityManager.createQuery("select b from Branch b ");
		List<Branch> list = query.getResultList();
		return list;
	}

	public boolean deleteBranch(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, id);
		if (branch != null) {
			transaction.begin();
			entityManager.remove(branch);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Branch getBranchById(int id) {
		return entityManager.find(Branch.class, id);
	}

	public Branch updateBranch(Branch branch) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(branch);
		transaction.commit();
		return branch;

	}
}
