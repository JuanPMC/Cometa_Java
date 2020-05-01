import java.io.IOException;
import javax.swing.JOptionPane;

//Esta clase se dedica a intereaccionar con el usuario

public class Mostrador
{
    public void mensajeNormal(String mensaje) { // un mesaje cualquiera
    	JOptionPane.showMessageDialog(null, mensaje, "Noramal", JOptionPane.WARNING_MESSAGE);
    }
    public void mensajeError(String mensaje) { // un mensaje de error
    	JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.WARNING_MESSAGE);
    }
    public void mostrarInterfaz(Departamentos listaDepartamentos) { // la interfaz entera
		Escritor escritor = new Escritor();
		int respuesta_salida = 1, respuesta_salida2 = 2;
		String[] lista_departamentos = {"test","dirección", "logística", "control de robots", "médico", "investigación biológica", "construcción y mantenimiento", "sistemas informáticos", "investigación astronómica", "cometología", "navegación"};	
		
		do {		
			String respuesta_departamento = (String) JOptionPane.showInputDialog(null, "Seleccione un departamento", "Departamento", JOptionPane.DEFAULT_OPTION, null, lista_departamentos, lista_departamentos[0]);	
			Departamento departamento = listaDepartamentos.getDepartamento(respuesta_departamento);
			Miembro[] miembros = new Miembro[41];
			String[] lista_vacia = {"Sin miembros"};
			
			if(respuesta_departamento != null) {	
				if(departamento.getnumMiembros()>0) {
					int respuesta_imprimir_departamento = JOptionPane.showConfirmDialog(null, "¿Desea imrpimir los miembros de este departamento?", "Importante", JOptionPane.YES_NO_OPTION);	
	
					if(respuesta_imprimir_departamento==0) {				
						try {
							escritor.writeDep(respuesta_departamento, listaDepartamentos);					// Funcion imprimir departamento--->Imprime nombre del departamento, listado de sus miembros agrupados por su cargo y los requisitos dichos cargos ocupados;
							JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
						} catch (IOException e) {
							e.printStackTrace();
						}								
					}		
					int num_miembros = departamento.getnumMiembros();
					String[] lista_miembros = new String[num_miembros];
							
					for(int i=0;i<=num_miembros-1;i++) {
						miembros[i] = departamento.getMiembro(i);
						lista_miembros[i] = miembros[i].getNombre();
					}			
					do {					
						if(num_miembros > 0) {
							String respuesta_miembro = (String) JOptionPane.showInputDialog(null, "Seleccione un miembro", "Miembros", JOptionPane.DEFAULT_OPTION, null, lista_miembros, lista_miembros[0]);
							
							if(respuesta_miembro != null) {
								int respuesta_imprimir_miembro = JOptionPane.showConfirmDialog(null, "¿Desea imrpimir los datos de este miembro?", "Importante", JOptionPane.YES_NO_OPTION);		
								
								if(respuesta_imprimir_miembro == 0) {
									for(int i = 0; i<= num_miembros-1;i++)
										if(respuesta_miembro == lista_miembros[i]) {
											try {
												escritor.writeMiem(miembros[i]);				// Funcion imprimir datos de un miembro;
												JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
								}
								respuesta_salida2 = JOptionPane.showConfirmDialog(null, "¿Desea seleccionar otro miembro de este departamento?", "Importante", JOptionPane.YES_NO_OPTION);
							}
						}else {
							String respuesta_miembro = (String) JOptionPane.showInputDialog(null, "Seleccione un miembro", "Miembros", JOptionPane.DEFAULT_OPTION, null, lista_vacia, lista_vacia[0]);
						}					
					}while(respuesta_salida2==0);	
				}
				else {
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Este departamento esta vacío, desea seleccionar otro departamento?", "Importante", JOptionPane.YES_NO_OPTION);
					
					if(confirmacion == 0)
						continue;
				}
			}
			respuesta_salida = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Importante", JOptionPane.YES_NO_OPTION);
		}while(respuesta_salida==1);
	}
}