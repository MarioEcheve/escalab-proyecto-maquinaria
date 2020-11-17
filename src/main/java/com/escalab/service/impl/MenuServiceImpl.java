package com.escalab.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Menu;
import com.escalab.repo.IMenuRepo;
import com.escalab.service.IMenuService;
import java.util.Optional;

@Service
public class MenuServiceImpl  implements IMenuService{

	@Autowired
	private IMenuRepo menuRepo;
	
	@Override
	public Menu save(Menu obj) {
		return menuRepo.save(obj);
	}

	@Override
	public Menu update(Menu obj) {
		return menuRepo.save(obj);
	}

	@Override
	public List<Menu> list() {
		return menuRepo.findAll();
	}

	@Override
	public Menu findById(Integer id) {
		Optional<Menu> op = menuRepo.findById(id);
		return op.isPresent() ? op.get() : new Menu();
	}

	@Override
	public boolean delete(Integer id) {
		menuRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		List<Menu> menus = new ArrayList<>();
		menuRepo.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));
			
			menus.add(m);
		});
		return menus;
	}

}
