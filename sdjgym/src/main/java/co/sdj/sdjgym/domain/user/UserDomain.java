package co.sdj.sdjgym.domain.user;

import java.util.UUID;

import co.sdj.sdjgym.domain.Domain;

public class UserDomain extends Domain PersonDomain{
	
	
	private UUID id;
	private String name;
	private String segundoNombre;
	private String apellido;
	private String segundoApellido;
	private UUID identificadorTipoIdentificacion;
	private TipoIdentificacion tipoIdentificacion;
	private int identificacion;
	private int celular;
	private int celularEmergencia;
	private String correo;
	private UUID identificadorEps;
	private Eps eps;
	private UUID identificadorDepartamento;
	private String state;
	private UUID identificadorMunicipio;
	private String municipio;
	
	
	
	protected UserDomain(UUID id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

}
