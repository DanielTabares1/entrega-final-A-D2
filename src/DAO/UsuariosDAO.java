package DAO;

import modelo.AuxiliarBancario;

public interface UsuariosDAO {

    AuxiliarBancario buscarUsuario(String userName, String password);

}
