package cn.edu.pku.live.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * User entity
 * 
 * @author stanley_hwang
 *
 */
@Entity
@Table(name="tb_user")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String gender;
	private UserStatus status;
	private String portrait;
	private String supportTeam;
	
	public String getSupportTeam() {
		return supportTeam;
	}
	public void setSupportTeam(String supportTeam) {
		this.supportTeam = supportTeam;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
