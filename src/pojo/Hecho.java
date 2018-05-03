package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hechos")
public class Hecho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item;
	
	@Column(name="analisis")
	private String analisis;
	
	@Column(name="image")
	private byte[] image;
	
	@ManyToOne()
	@JoinColumn(name="idBoletin")
	private Boletin boletin;
	
	public Hecho(){
		
	}

	public Hecho(int item, String analisis, byte[] image, Boletin boletin) {
		super();
		this.item = item;
		this.analisis = analisis;
		this.image = image;
		this.boletin = boletin;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getAnalisis() {
		return analisis;
	}

	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Boletin getBoletin() {
		return boletin;
	}

	public void setBoletin(Boletin boletin) {
		this.boletin = boletin;
	}
	
	
	
	
	

}
