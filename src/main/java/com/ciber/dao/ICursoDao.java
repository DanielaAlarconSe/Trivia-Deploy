package com.ciber.dao;

import java.util.List;

import com.ciber.entities.Curso;

public interface ICursoDao {

	public List<Curso> obtenerCursos(Integer usuario, Integer persona);

	public int registrarCurso(Curso curso);

	int actualizar(Curso curso);

	int eliminarCurso(Curso curso);
}
