import { Servicio } from './servicio';
import { Estudiante } from './estudiante';

export class Contrato {
    idContrato: number;
    nombreServicio: string;
    nomEstudiante: string;
    apellidoEstudiante: string;
    direccionEstudinate: string;
    nomProfesor: string;
    apellidoProfesor: string;
    year: string;
    mes: string;
    dia: string;
    confirmado: string;
    calificacion: number;
    costo: number;
    nombreEspecialidad: string;
    estudiante : Estudiante;
    servicio : Servicio;
}