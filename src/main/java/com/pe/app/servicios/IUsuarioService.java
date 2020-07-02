package com.pe.app.servicios;

import com.pe.app.entidades.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
