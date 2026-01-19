package logica;

public class GestionUrgencias {

	public static void listarPacientesGravedad(Urgencias u, String gravedad) {
		for (Paciente paciente : u.getPacientes()) {
			if (paciente.getGravedad().equals(gravedad)) {
				System.out.println(paciente);
			}
		}
	}
	
	public static void buscarMedico(Urgencias u, String especialidad) {
		for (Medico medico : u.getEquipo_medio()) {
			if (medico.getEspecialidad().equals(especialidad)) {
				System.out.println(medico);
			}
		}
	}
	
	public static double calcularEdadMedia(Urgencias u) {
		
		
		int sumaEdad = 0;
		int numeroPacientes = 0;
		
		for (Paciente paciente : u.getPacientes()) {
			sumaEdad += paciente.getEdad();
			numeroPacientes++;
		}
		
		double edadMedia =(double) sumaEdad / numeroPacientes;
		return edadMedia;
	}
	
	public static void buscarPaciente(Urgencias u, String sipPaciente)  {
		for (Paciente paciente : u.getPacientes()) {
			if (paciente.getSip().equals(sipPaciente)) {
				System.out.println(paciente);
			}
		}
	}
}
