package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- TEST 1 : seller findy id ===");
		Seller seller = sellerDao.findByid(3);
		
		System.out.println(seller);
		
		System.out.println("\n--- TEST 2 : seller findyDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 3 : seller filleAll ===");

		list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 4 : seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 400.0, department);
	System.out.println("inserted! New id = "+ newSeller.getId());
	
	
	System.out.println("\n--- TEST 5 : seller update ===");
	 seller = sellerDao.findByid(1);
	 seller.setName("Martha waine");
	 sellerDao.update(seller);
	 System.out.println("Updade completed");
	
	 System.out.println("\n--- TEST 6 : seller delete ===");
	 System.out.println("Enter id for delete test: ");
	 int id = sc.nextInt();
	 sellerDao.deleteById(id);
	 System.out.println("Delete completed");
	 
	 sc.close();
	}

}
