package mfs.sql;

public class User {

	private String username;
	private String password;
	private String songName;
	private String author;
	private String link;

	private String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private String getSongName() {
		return songName;
	}

	private void setSongName(String songName) {
		this.songName = songName;
	}

	private String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	private String getLink() {
		return link;
	}

	private void setLink(String link) {
		this.link = link;
	}

}
