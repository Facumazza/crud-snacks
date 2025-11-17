package maquina_snack_archivos.servicios;

import maquina_snack_archivos.dominio.Snack;
import java.util.*;

public interface IServicioSnacks {

	void agregarSnack(Snack snack);
	void mostrarSnacks();
	List<Snack> getSnacks();

}
