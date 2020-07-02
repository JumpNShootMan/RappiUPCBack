import { Especialidad } from './especialidad';
import { Profesor } from './profesor';

export class Servicio {
    idServicio: number;
    nomServicio: string;
    descripcionServicio: string;
    costoServicio: number;
    dia: string;
    hora: string;
    nomEspecialidad: string;
    profesor: Profesor;
}