package co.com.obusiness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.obusiness.dao.ValidaUsuarioDao;
import co.com.obusiness.entidades.TsEmpUsuarios;



@Service
public class ValidaUsuarioServiceImpl implements ValidaUsuarioService {

	@Autowired 
	private ValidaUsuarioDao validaUsuarioDao ;
	
	public ValidaUsuarioDao getValidaUsuarioDao() {
		return validaUsuarioDao;
	}

	public void setValidaUsuarioDao(ValidaUsuarioDao validaUsuarioDao) {
		this.validaUsuarioDao = validaUsuarioDao;
	}

	@Transactional
	public String validaUsuario(TsEmpUsuarios usuario) throws Exception{		
		return validaUsuarioDao.validaUsuario(usuario);
	}
}
