package com.springjpa.advance.springbootjpahibernateadvance;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaHibernateAdvanceApplication implements CommandLineRunner{
	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Autowired
//	private PassportRepository passportRepository;
//	
//	@Autowired
//	private CourseRepository courseRepository;
//	
//	@Autowired
//	private ReviewRepository reviewRepository;
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaHibernateAdvanceApplication.class, args);
	}

	@Override
//	@Transactional
	public void run(String... args) throws Exception {	
//		TypedQuery<Student> typedQuery = em.createQuery("Select c from Student c",Student.class);
//		System.out.println(typedQuery.getResultList());
//		addNewPassportForStudent();
//		addReviewsForCourse();
//		Student rout = studentRepository.findByID(2l);
//		Student tim = studentRepository.findByID(40000l);
//
//		
//		courseRepository.addStudents(10000l,rout);
//		courseRepository.addStudents(10001l,rout);
//		courseRepository.addStudents(10001l,tim);
		
	}

//	private void addNewPassportForStudent() {
//		Passport passport = new Passport("GHDT65784");
//		Student student = new Student("Rout",passport);
//		passportRepository.save(passport);
//		studentRepository.save(student);
//		passport.setStudent(student);
//		studentRepository.findAll().stream().forEach(System.out::println);
//	}

//	@Transactional
//	private void addReviewsForCourse() {
//		//testReview
//		Review review = new Review("very nice book by satya", 3);
//		Review review1 = new Review("very nice book by satya 2", 3);
////		Course course = courseRepository.findByID(10000l);
////		course.addReview(review);
////		course.addReview(review1);
////		review.setCourse(course);
////		review1.setCourse(course);
////		reviewRepository.save(review);
////		reviewRepository.save(review1);
//		
//		courseRepository.addReviewsToCourse(10000l, Arrays.asList(review, review1));
//	}

}
