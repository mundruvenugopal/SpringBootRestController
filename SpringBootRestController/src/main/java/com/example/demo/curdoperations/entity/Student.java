package com.example.demo.curdoperations.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Getter
@Data
@Table(name="StudentsDetails")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phNo;
	/*
	 * @Column(name = "studentphoto") private String studentphoto;
	 */

	/*
	 * @Override public String toString() {
	 * 
	 * return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' +
	 * ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phNo=" +
	 * phNo +'\''+ ", studentphoto=" + studentphoto+ '}'; }
	 */
	}



