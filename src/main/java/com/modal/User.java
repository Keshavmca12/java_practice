package com.modal;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USERS")
@Access(AccessType.PROPERTY)
public class User {

	private int id;
	private String name;
	private String email;
	private  String mobileNo;
	private String password;
	private short sex;
	private int userType;
	
	private short isCompleted=-1;
	private short isBlacklisted=-1;
	private long createdOn;
	private List<Object> children;
	@Transient
	public List<Object> getChildren() {
		return children;
	}
	public void setChildren(List<Object> children) {
		this.children = children;
	}
	@Column(name = "CREATED_ON", nullable = false)
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	@Column(name="IS_BLACKLISTED", nullable = false)
	public short getIsBlacklisted() {
		return isBlacklisted;
	}
	public void setIsBlacklisted(short isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "EMAIL", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "MOBILE_NO", unique = true, nullable = false)
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Column(name = "PASSWORD",nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "SEX_ID",nullable = false)
	public short getSex() {
		return sex;
	}
	public void setSex(short sex) {
		this.sex = sex;
	}
	
	@Column(name = "IS_COMPLETED",nullable = false)
	public short getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(short isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + mobileNo + ", password=" + password
				+ ", name=" + name + ", isCompleted=" + isCompleted
				+ ", email=" + email + ", isBlacklisted=" + isBlacklisted + "]";
	}
	@Column(name="ROLE_ID")
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}


}
