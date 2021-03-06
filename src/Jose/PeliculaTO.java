package Jose;

public class PeliculaTO {
	
	private String titulo;
	private String codigopelicula;
	private String actor;
	private String director;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodigopelicula() {
		return codigopelicula;
	}
	public void setCodigopelicula(String codigopelicula) {
		this.codigopelicula = codigopelicula;
	}
	
	/**
	 * @return the actor
	 */
	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}
	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	PeliculaTO(String titulo, String codigopelicula, String actor, String director) {
		super();
		this.titulo = titulo;
		this.codigopelicula = codigopelicula;
		this.actor = actor;
		this.director = director;
	}
	
	@Override
	public String toString() {
		return 
		 titulo + "," + codigopelicula + "," + actor + "," + director;
	}
	
	

}
