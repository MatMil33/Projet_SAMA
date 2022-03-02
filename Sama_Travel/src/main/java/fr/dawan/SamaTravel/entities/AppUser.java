package fr.dawan.SamaTravel.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//TODO Vérifier si on crée la classe AppUser en surcouche d'une classeUser????

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING, length = 30)
public abstract class AppUser extends DbObject {

	private String nom;
	private String prenom;

	@Column
	private String email;

	@Column(unique = true)
	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private TypeUser typeUser;

//	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
//	private List<Reservation> reservations;
//	
//	
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="roleName")
//	private Collection<UserRole> roles ;

//TODO mettre dans client
//	public AppUser() {
//		super();
//		reservations = new ArrayList<Reservation>();
//	}

	public AppUser() {
		super();
	}

	public AppUser(String nom, String prenom, String email, String username, String password, TypeUser typeUser) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
		this.typeUser = TypeUser.CLIENT;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [ nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", reservations]";
	}

}
