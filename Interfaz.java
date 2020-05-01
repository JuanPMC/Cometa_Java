import javax.swing.JOptionPane;



public class Interfaz {
	public Interfaz(Departamentos listaDepartamentos) {
		
		int respuesta_salida = 2, respuesta_salida2 = 2;
		String[] lista_departamentos = {"test","dirección", "logística", "control de robots", "médico", "investigación biológica", "construcción y mantenimiento", "sistemas informáticos", "investigación astronómica", "cometología", "navegación"};
		
		do {
			
			String respuesta_departamento = (String) JOptionPane.showInputDialog(null, "Seleccione un departamento", "Departamento", JOptionPane.DEFAULT_OPTION, null, lista_departamentos, lista_departamentos[0]);
			if(respuesta_departamento != null) {
				int respuesta_imprimir_departamento = JOptionPane.showConfirmDialog(null, "¿Desea imrpimir los miembros de este departamento?");
				if(respuesta_imprimir_departamento==0) {
					// Funcion imprimir departamento--->Imprime nombre del departamento, listado de sus miembros agrupados por su cargo y los requisitos dichos cargos ocupados;
				}
				else if (respuesta_imprimir_departamento==1) {
					
					Departamento departamento = listaDepartamentos.getDepartamento(respuesta_departamento);
					Miembro[] miembros = new Miembro[41];
					int num_miembros = departamento.getnumMiembros();
					String[] lista_miembros = new String[num_miembros];
					String[] lista_vacia = {"Sin miembros"};
					
					for(int i=0;i<=num_miembros-1;i++) {
						miembros[i] = departamento.getMiembro(i);
						lista_miembros[i] = miembros[i].getNombre();
					}
					do {	
							if(num_miembros > 0) {
								String respuesta_miembro = (String) JOptionPane.showInputDialog(null, "Seleccione un miembro", "Miembros", JOptionPane.DEFAULT_OPTION, null, lista_miembros, lista_miembros[0]);
							}
							else {
								String respuesta_miembro = (String) JOptionPane.showInputDialog(null, "Seleccione un miembro", "Miembros", JOptionPane.DEFAULT_OPTION, null, lista_vacia, lista_vacia[0]);
							}
								
							int respuesta_imprimir_miembro = JOptionPane.showConfirmDialog(null, "¿Desea imrpimir los datos de este miembro?");
							
							if(respuesta_imprimir_miembro == 0) {
								// Funcion imprimir datos de un miembro;
							}
							else if(respuesta_imprimir_miembro == 1) {
								respuesta_salida2 = JOptionPane.showConfirmDialog(null, "¿Desea seleccionar otro miembro?");
							}
						
					}while(respuesta_salida2==0);
				}
			}
			
		 respuesta_salida = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?");
			
		}while(respuesta_salida==2 || respuesta_salida==1);
	}
}