public class Movie {
	
	private String movieName;
	private int numMinutes;
	private boolean isKidFriendly;
	private int numCastMembers;
	private String[] castMembers;
	
	public Movie() {
		this.movieName = "Flick";
		this.numMinutes = 0;
		this.isKidFriendly = false;
		this.numCastMembers = 0;
		this.castMembers = new String [10];
	}
	
	public Movie(String movieName, int numMinutes,boolean isKidFriendly,String [] castMembers) {
		this();
		this.movieName = movieName;
		this.numMinutes = numMinutes;
		this.isKidFriendly = isKidFriendly;
		this.castMembers = copyCastMembers(castMembers);
	}
	
	private String []copyCastMembers(String []members) {
		String []temp  = new String[members.length];
		
		for(int i = 0; i< members.length && i < temp.length; i++) {
			if(members[i]!=null) {
			temp [i] = members[i];
			this.numCastMembers++;
			}
		}
		return temp;
	}
	
	public void setNumMinutes(int numMinutes) {
		this.numMinutes = numMinutes;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public void setIsKidFriendly(boolean isKidFriendly) {
		this.isKidFriendly = isKidFriendly;
	}
	
	public int getNumMinutes() {
		return this.numMinutes;
	}
	
	public String getMovieName() {
		return this.movieName;
	}
	
	public boolean isKidFriendly() {
		return this.isKidFriendly;
	}
	
	public int getNumCastMembers() {
		return this.numCastMembers;
	}
	
	public String[] getCastMembers() {
		
		String[] copy = new String[this.castMembers.length];
		for(int i = 0; i < this.numCastMembers; i++) {
			copy[i] = this.castMembers[i];
		}
		return copy;
	}
	
	public boolean replaceCastMember(int index, String name) {
		if(index<0 || index >= this.numCastMembers) {
			return false;
		}
			this.castMembers[index] = name;
		return true;
	}
	
	public boolean doArraysMatch(String [] array1, String [] array2) { 
		if(array1 == null && array2 == null) {
			return true;
		}
		else if(array1 == null || array2 == null){
			return false;
		}
		if(array1.length != array2.length) {
			return false;
		}
		for(int i = 0; i < array1.length; i++) {
			if(!array1[i].equals(array2[i])) {
				return false;
			}
		}
		return true;
	}
	
	public String getCastMemberNamesAsString() {
		
		if(this.numCastMembers == 0) {
			return "none";
		}
		String names = "";
		for(int i = 0; i< this.numCastMembers; i++) {
			
			if(i == 0) {
				names+= this.castMembers[i] + ",";
			}
			else if(i == this.numCastMembers-1) {
				names += " " +this.castMembers[i];
			}
			else {
				names +=  " " +this.castMembers[i] + ",";
			}
		}
		
		return names;
	}
	public String toString() {
		
		 String s ="Movie: [ Minutes " + String.format("%03d", this.getNumMinutes()) + " | Movie Name: " + String.format("%20s", this.getMovieName() )+ " | " + (this.isKidFriendly() ? "is kid friendly" : "not kid friendly") + " | Number of Cast Members: " + this.getNumCastMembers() + " | ";
		 s += "Cast Members: " + this.getCastMemberNamesAsString() + " ]";
		 
		return s;
	}
	
	public boolean equals(Object o) {
		
		if(o == null) {
			return false;
		}
		if(o instanceof Movie) {
			Movie film = (Movie)o;
			if(this.isKidFriendly == film.isKidFriendly) {
				if(this.getMovieName() == film.getMovieName()) {
					if(this.getNumCastMembers() == film.getNumCastMembers()) {
						if(this.getNumMinutes() == film.getNumMinutes()) {
							if(this.doArraysMatch(getCastMembers(), film.getCastMembers())) {
							return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
