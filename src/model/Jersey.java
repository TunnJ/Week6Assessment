package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jersey")
public class Jersey {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="COLOR")
	private String color;
	@Column(name="TYPE")
	private String type;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="PLAYER_ID")
	private Player player;
	
	public Jersey(String color, String type) {
		this.color = color;
		this.type = type;
	}
	public Jersey(String color, String type, Player player) {
		this.color = color;
		this.type = type;
		this.player = player;
	}
	public Jersey() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	
	@Override
	public String toString() {
		return "Jersey [id=" + id + ", color=" + color + ", type=" + type + "]";
	}
}
