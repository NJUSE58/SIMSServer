package po;


import java.io.Serializable;

import dataenum.UserRole;
import javafx.scene.image.ImageView;

public class UserPO extends PersistObject implements Serializable{

	private static final long serialVersionUID = -554010814150465068L;
	private String name;
	private String password;
	private UserRole role;
	private ImageView image; // ÓÃ»§Í·Ïñ


	public UserPO(String id, String name, String password, UserRole role, ImageView image) {
		super(id);
		this.name = name;
		this.password = password;
		this.role = role;
		this.image = image;
	}


	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public UserRole getRole() {
		return role;
	}

	public ImageView getImage() {
		return image;
	}

}
