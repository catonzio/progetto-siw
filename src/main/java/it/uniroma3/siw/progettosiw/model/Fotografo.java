package it.uniroma3.siw.progettosiw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "cognome" }))
public class Fotografo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String nome;
	@Column
	private String cognome;
	@OneToMany(mappedBy = "autore")
	private List<Album> album;
	@OneToMany(mappedBy = "autore")
	private List<Foto> fotoFatte;

	public Fotografo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void aggiungiAlbum(Album album) {
		if (album != null) {
			this.album.add(album);
		}
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void addAlbum(Album album) {
		this.album.add(album);
	}

	public void addFoto(Foto foto) {
		fotoFatte.add(foto);
	}
}