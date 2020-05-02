package Sistemas.Administracion.Hospital;

import Sistemas.Administracion.Hospital.DoctoryPaciente.Doctor;
import Sistemas.Administracion.Hospital.DoctoryPaciente.Paciente;

import java.util.ArrayList;

public class Hospitales {
    //ATRIBUTOS
    private ArrayList<Paciente> pacientesPorAtender;
    private ArrayList<Paciente> pacientesAtendiendose;
    private String nombreDelHospital;
    private ArrayList<Paciente> pacientesAtendidos;
    private ArrayList<Doctor> doctorAtendiendo;
    private int camasDisponibles;

    //METODOS
    public int getCamasDisponibles() {
        return camasDisponibles;
    }

    public void setCamasDisponibles(int camasDisponibles) {
        this.camasDisponibles = camasDisponibles;
    }

    public ArrayList<Doctor> getDoctorAtendiendo() {
        return doctorAtendiendo;
    }

    public void setDoctorAtendiendo(ArrayList<Doctor> doctorAtendiendo) {
        this.doctorAtendiendo = doctorAtendiendo;
    }

    public ArrayList<Paciente> getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(ArrayList<Paciente> pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public String getNombreDelHospital() {
        return nombreDelHospital;
    }

    public void setNombreDelHospital(String nombreDelHospital) {
        this.nombreDelHospital = nombreDelHospital;
    }

    public ArrayList<Paciente> getPacientesAtendiendose() {
        return pacientesAtendiendose;
    }

    public void setPacientesAtendiendose(ArrayList<Paciente> pacientesAtendiendose) {
        this.pacientesAtendiendose = pacientesAtendiendose;
    }

    public ArrayList<Paciente> getPacientesPorAtender() {
        return pacientesPorAtender;
    }

    public void setPacientesPorAtender(ArrayList<Paciente> pacientesPorAtender) {
        this.pacientesPorAtender = pacientesPorAtender;
    }
    public int cantidaddePacientesAtendidos(ArrayList pacientesAtendidos)
    {
        getPacientesAtendidos();
        return pacientesAtendidos.size();
    }
    public ArrayList infoPacientesAtendiendose(ArrayList pacientesAtendiendose)
    {
        getPacientesAtendiendose();
        return pacientesAtendiendose;
    }
}
