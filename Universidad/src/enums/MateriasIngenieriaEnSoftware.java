package enums;

import java.util.ArrayList;
import modelo.Materia;

public enum MateriasIngenieriaEnSoftware {
	DESARROLLO_EMPRENDEDOR(1, "Desarrollo emprendedor", 1, 1),
	HERRAMIENTAS_MATEMATICAS_I_ALGEBRA(2, "Herramientas matem‡ticas I - çlgebra", 1, 1),
	HERRAMIENTAS_MATEMATICAS_II_ANALISIS(3, "Herramientas matem‡ticas II - An‡lisis", 1, 1),
	IDIOMA_EXTRANJERO_I(4, "Idioma Extranjero I", 1, 1),
	INTRODUCCION_A_LOS_ALGORITMOS(5, "Introducci—n a los algoritmos", 1, 1),
	SISTEMAS_DE_INFORMACION(6, "Sistemas de informaci—n", 1, 1),
	ARQUITECTURA_DEL_COMPUTADOR(7, "Arquitectura del computador", 1, 2),
	CALCULO_AVANZADO(8, "C‡lculo avanzado", 1, 2),
	IDIOMA_EXTRANJERO_II(9, "Idioma extranjero II", 1, 2),
	MATEMATICA_DISCRETA(10, "Matem‡tica discreta", 1, 2),
	PROGRAMACION_ORIENTADA_A_OBJETOS(11, "Programaci—n orientada a objetos", 1, 2),
	
	ALGORITMOS_Y_ESTRUCTURAS_DE_DATOS_I(12, "Algoritmos y estructuras de datos I", 2, 1),
	GRUPO_Y_LIDERAZGO(13, "Grupo y liderazgo", 2, 1),
	HERRAMIENTAS_MATEMATICAS_III_ESTADISTICA_I(14, "Herramientas matem‡ticas III - Estad’stica", 2, 1),
	IDIOMA_EXTRANJERO_III(15, "Idioma extranjero III", 2, 1),
	LOGICA_SIMBOLICA(16, "L—gica simb—lica", 2, 1),
	TALLER_DE_ALGORITMOS_Y_ESTRUCTURA_DE_DATOS_I(17, "Taller de algoritmos y estructuras de datos I", 2, 1),
	ALGORITMOS_Y_ESTRUCTURA_DE_DATOS_II(18, "Algoritmos y estructuras de datos II", 2, 2),
	IDIOMA_EXTRANJERO_IV(19, "Idioma extranjero IV", 2, 2),
	PARADIGMAS_DE_PROGRAMACION(20, "Paradigmas de programaci—n", 2, 2),
	PRINCIPIOS_DE_ECONOMIA(21, "Principios de econom’a", 2, 2),
	TALLER_DE_ALGORITMOS_Y_ESTRUCTURA_DE_DATOS_II(22, "Taller de algoritmos y estructuras de datos II", 2, 2),
	
	ANALISIS_Y_DISENO_DE_SOFTWARE(23, "An‡lisis y dise–o de software", 3, 1),
	HERRAMIENTAS_MATEMATICAS_V_ESTADISTICA_II(24, "Herramientas matem‡ticas V - Estad’stica II", 3, 1),
	IDIOMA_EXTRANJERO_V(25, "Idioma extranjero V", 3, 1),
	SISTEMAS_OPERATIVOS(26, "Sistemas operativos", 3, 1),
	TALLER_DE_ANALISIS_Y_DISENO_DE_SOFTWARE(27, "Taller de an‡lisis y dise–o de software", 3, 1),
	ETICA_Y_DEONTOLOGIA_PROFESIONAL(28, "ƒtica y deontolog’a profesional", 3, 1),
	BASES_DE_DATOS_I(29, "Bases de datos", 3, 2),
	IDIOMA_EXTRANJERO_VI(30, "Idioma extranjero VI", 3, 2),
	INGENIERIA_DE_SOFTWARE(31, "Ingenier’a de software", 3, 2),
	SEMINARIO_DE_PRACTICA_DE_ANALISTA_EN_SOFTWARE(32, "Seminario de pr‡ctica de Analista en software", 3, 2),
	TALLER_DE_INGENIERIA_DE_SOFTWARE(33, "Taller de ingenier’a de software", 3, 2),
	
	CALIDAD_DE_SOFTWARE(34, "Calidad de software", 4, 1),
	SEGURIDAD_INFORMATICA(35, "Seguridad inform‡tica", 4, 1),
	SISTEMAS_OPERATIVOS_II(36, "Sistemas operativos II", 4, 1),
	ADMINISTRACION_DE_PROYECTOS(37, "Administraci—n de proyectos", 4, 2),
	BASE_DE_DATOS_II(38, "Base de datos II", 4, 2),
	CONSTRUCCION_DE_SOFTWARE(39, "Construcci—n de software", 4, 2),
	HERRAMIENTAS_MATEMATICAS_VI_MODELOS_DE_SIMULACION(40, "Herramientas matem‡ticas VI - Modelos de simulaci—n", 4, 2),
	TALLER_DE_CONSTRUCCION_DE_SOFTWARE(41, "Taller de construcci—n de software", 4, 2),
	
	EMPRENDIMIENTOS_UNIVERSITARIOS(42, "Emprendimientos universitarios", 5, 1),
	METODOS_FORMALES(43, "MŽtodos formales", 5, 1),
	PRACTICA_PROFESIONAL_DE_INGENIERIA_EN_SOFTWARE(44, "Pr‡ctica profesional de Ingenier’a en software", 5, 1),
	PRACTICA_SOLIDARIA(45, "Pr‡ctica solidaria", 5, 1),
	SEMINARIO_FINAL_DE_INGENIERIA_EN_SOFTWARE(46, "Seminario final de Ingenier’a en software", 5, 2);
	
	private int id;
	private String nombre;
	private int anioDictado;
	private int semestreDictado;
	
	private MateriasIngenieriaEnSoftware(int id, String nombre, int anioDictado, int semestreDictado) {
		this.id = id;
		this.nombre = nombre;
		this.anioDictado = anioDictado;
		this.semestreDictado = semestreDictado;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getAnioDictado() {
		return this.anioDictado;
	}
	
	public int getSemestreDictado() {
		return this.semestreDictado;
	}
	
	public static ArrayList<Materia> getMaterias() {
		MateriasIngenieriaEnSoftware aux[] = MateriasIngenieriaEnSoftware.values();
		ArrayList<Materia> resultado = new ArrayList<Materia>();
		for(int i=0; i<aux.length; i++) {
			Materia materia = new Materia(
				aux[i].getId(),
				aux[i].getNombre(),
				aux[i].getAnioDictado(),
				aux[i].getSemestreDictado());
			resultado.add(materia);
		}
		return resultado;
	}
}