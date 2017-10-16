
/**
 * @author Mythrehee Himachalapathy,
 * @author Vishesh Kumar, 
 * @author Vadym Datsiuk
 */package ca.myseneca.model;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import ca.myseneca.model.Employee;

public class DBAccess {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	Employee loggedEmployee;
	
	public DBAccess() {
		super();
	}
	public Employee getLoggedEmployee() {
		return loggedEmployee;
	}
	public void setLoggedEmployee(Employee loggedEmployee) {
		this.loggedEmployee = loggedEmployee;
	}
	public DBAccess(EntityManagerFactory emf, EntityManager em) {
		super();
		this.emf = emf;
		this.em = em;
	}
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence.createEntityManagerFactory("A2HRManagement");
		em = emf.createEntityManager();
	}
	public void closeEntityManager() {
		// Close the EntityManager
		em.close();
		emf.close();
	}
	public boolean loginCheck(String username,String password){
		boolean login = false;
		getEntityManager();
		try {
			
			TypedQuery<Security> query = em.createNamedQuery("Security.findBySecId", Security.class);
			query.setParameter("user", username);
			Security sec = query.getSingleResult();
			if (!sec.getSecPassword().equals(password) ||
                    !sec.getSecStatus().equals("A"))
                login = false;
			else{
				loggedEmployee = sec.getEmployee();
			login = true;
			}
		} catch (Exception ex) {
			
			System.out.println(ex);
		} finally {
			closeEntityManager();
		}
		return login;
	}
	public List<Employee> findEmployeesByDepartment(Long deparmentid) {
		getEntityManager();
		List<Employee> employees = null;

		try {
			// get the named query
			TypedQuery<Employee> query = em.createNamedQuery("Employee.findAllEmpByDep", Employee.class);
			query.setParameter("did",deparmentid );
			employees = query.getResultList();
			
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		return employees;
	}
	public Employee findEmployee(Long employeeId){
		getEntityManager();
		Employee employee = null;

		try {
			// get the named query
			employee = em.find(Employee.class, employeeId);
			
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		return employee;
	}
	
	public List<Employee> findAllEmployees() {
		getEntityManager();
		List<Employee> employees = null;

		try {
			// get the named query
			TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
			employees = query.getResultList();
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		return employees;
	}

	public Employee empToBeAdded(HttpServletRequest request) throws java.text.ParseException{
		getEntityManager();
		
	 Employee employee = new Employee();
     try {
     

         String firstName = request.getParameter("first_name");
         employee.setFirstName(firstName);

         String lastName = request.getParameter("last_name");
         employee.setLastName(lastName);

         String email = request.getParameter("email");
         employee.setEmail(email);

         String phone = request.getParameter("phone");
         employee.setPhoneNumber(phone);
         
         String hireDateStr = request.getParameter("hire_date");
         if (hireDateStr != null && hireDateStr.length() > 0) {
             java.util.Date tmp = new SimpleDateFormat("yyyy-MM-dd").parse(hireDateStr);
             java.sql.Date hireDate = new java.sql.Date(tmp.getTime());
             employee.setHireDate(hireDate);
         }

         String jobId = request.getParameter("job");
         Job job = em.find(Job.class, jobId);
         employee.setJob(job);

         String salaryStr = request.getParameter("salary");
         if (salaryStr != null && salaryStr.length() > 0) {
             BigDecimal salary = BigDecimal.valueOf(Double.parseDouble(salaryStr));
             employee.setSalary(salary);
         }

         String commissionStr = request.getParameter("commission");
         if (commissionStr != null && commissionStr.length() > 0) {
             BigDecimal commissionPct = BigDecimal.valueOf(Double.parseDouble(commissionStr));
             employee.setCommissionPct(commissionPct);
         }

         String managerIdStr = request.getParameter("manager");
         if (managerIdStr != null && managerIdStr.length() > 0) {
             Long managerId = Long.parseLong(managerIdStr);
             Employee manager = em.find(Employee.class, managerId);
             employee.setEmployee(manager);
         }

         String departmentIdStr = request.getParameter("department");
         if (departmentIdStr != null && departmentIdStr.length() > 0) {
             Long departmentId = Long.parseLong(departmentIdStr);
             Department department = em.find(Department.class, departmentId);
             employee.setDepartment(department);
             
         	String IdStr = request.getParameter("employee_id");
            if (IdStr != null && IdStr.length() > 0) {
                Long Id = Long.parseLong(IdStr);
                employee.setEmployeeId(Id.longValue());
            }
         }
     } catch (ParseException | NumberFormatException ex) {
          ex.getMessage();
     }
     finally {
			closeEntityManager();
		}
return employee;
	}
	public boolean addEmployee(Employee emp){
		
		getEntityManager();
		boolean added = false;
		  em.getTransaction().begin();
		  try {
		  em.persist(emp);
		  em.getTransaction().commit();
		  added = true;
			 } 
			 catch (Exception ex) {
				} 
			 finally {
					closeEntityManager();
				}
		return added;
	}
	
	public boolean updateEmployee(Employee employee){
		boolean updated = false;
		 Employee emp = null ;
		 getEntityManager();
		  em.getTransaction().begin();
		  try {
				 emp = em.find(Employee.class, employee.getEmployeeId());
				 emp.setFirstName(employee.getFirstName());
				 emp.setLastName(employee.getLastName());
				 emp.setEmail(employee.getEmail());
				 emp.setCommissionPct(employee.getCommissionPct());
				 emp.setHireDate(employee.getHireDate());
				 emp.setSalary(employee.getSalary());
				 emp.setPhoneNumber(employee.getPhoneNumber());
				 emp.setJob(employee.getJob());
				 emp.setEmployee(employee.getEmployee());
				 emp.setDepartment(employee.getDepartment());
				 em.getTransaction().commit();
				 updated = true;
				 } 
				 catch (Exception ex) {
					} 
				 finally {
						closeEntityManager();
					}
		  
				return updated;
	}
	
	public boolean deleteEmployee(Employee employee){
		boolean deleted = false;
		 Employee emp = null ;
		 getEntityManager();
		  em.getTransaction().begin();
		  try {
			 emp = em.find(Employee.class, employee.getEmployeeId());
		         em.remove(emp);
		         em.getTransaction().commit();
		         deleted = true;
				 } 
				 catch (Exception ex) {
					} 
				 finally {
						closeEntityManager();
					}
		
				return deleted;
	}
	public List<Employee> search(String pattern){
		
		List<Employee> employees = null;
		getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query =
                em.createNamedQuery("Employee.search", Employee.class);
        query.setParameter(1, "%" + pattern.toLowerCase() + "%");
        employees = query.getResultList();
        return employees;
	}
	

	public List<Job> getJobList(){
	
		List<Job> jobs =null;
		getEntityManager();
		try {
			// get the named query
			TypedQuery<Job> query = em.createNamedQuery("Job.findAll", Job.class);
			jobs = query.getResultList();
		
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		
		return jobs;
		
	}

	
	public List<Department> getDepartmentList(){
		
		List<Department> departments  =null;
		getEntityManager();
		try {
			// get the named query
			TypedQuery<Department> query = em.createNamedQuery("Department.findAll", Department.class);
			departments = query.getResultList();
		
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		
		return departments ;
		
	
}
	
	
	/*public static void main(String args[]){
		Employee emp= new Employee();
		emp.setFirstName("Mythrehee");
		emp.setLastName("lastName");
		
	}*/
	
	}
	
