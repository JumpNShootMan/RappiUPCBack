//Imports
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'; //definir a mano
import {map} from 'rxjs/operators'; //definir a mano
import { Observable } from 'rxjs'; //definir a mano

// CLASES - MODEL:
import {Especialidad} from './model/especialidad'; //definir a mano
import {Profesor} from './model/profesor'; //definir a mano
import {Estudiante} from './model/estudiante'; //definir a mano
import {Distrito} from './model/distrito'; //definir a mano
import {Servicio} from './model/servicio';
import { Contrato } from './model/contrato';
import { DeclareVarStmt, identifierModuleUrl } from '@angular/compiler';

//Inicio Servicio
@Injectable({
  providedIn: 'root'
})
export class RappieduService {
  //definir a mano
  private urlBase = 'http://localhost:8080/api';
  private httpHeaders = new HttpHeaders({'Content-type' : 'application/json'}); //definir a mano
  //inyectar http, también importarlo en app.module.ts
  constructor(private http: HttpClient) { }

  // ***** ESPECIALIDAD *****
  createEspecialidad(especialidad: Object) : Observable<Object>{ //para crear en create-product
    return this.http.post(this.urlBase+'/especialidad/registrar',especialidad, {headers:this.httpHeaders}); //enviando el producto al REST de STS
  }
  getEspecialidadList(): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
    console.log('Llamando a REST: '+ this.urlBase + '/especialidad/mostrar');
    return this.http.get(this.urlBase+'/especialidad/mostrar').pipe( //llamado al REST de STS!
      map(response => response as Especialidad[])
    );
  }
  getEspecialidades() : Observable<any>{
    console.log("Llamando a REST: " + this.urlBase+ "/especialidad/mostrar");
    return this.http.get(this.urlBase+ "/especialidad/mostrar").pipe(
       map(response => response as Especialidad[])
    );   
  }

  // ***** PROFESOR *****
  createProfesor(profesor: Object) : Observable<Object>{ //para crear en create-product
    return this.http.post(this.urlBase+'/profesor/registrarse',profesor, {headers:this.httpHeaders}); //enviando el producto al REST de STS
  }

  getProfesorList(): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
    console.log('Llamando a REST: '+ this.urlBase + '/profesores/mostrar');
    return this.http.get(this.urlBase+'/profesores/mostrar').pipe( //llamado al REST de STS!
      map(response => response as Profesor[])
    );
  }
  getProfesorListId(id:number): Observable<any> { //Para llamar a la lista de productos en product-list.components.ts
    console.log('Llamando a REST: '+ this.urlBase + '/profesor/buscar/id');
    return this.http.get(this.urlBase+'/profesor/buscar/id/'+id).pipe( //llamado al REST de STS!
      map(response => response as Profesor)
    );
  }

    // ***** ESTUDIANTE *****
  createEstudiante(estudiante: Estudiante) : Observable<Object>{ //para crear en create-product 
    return this.http.post(this.urlBase+'/estudiante/registrar', estudiante, {headers:this.httpHeaders});
  
  }
  getEstudianteList(): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
    console.log('Llamando a REST: '+ this.urlBase + '/estudiantes/mostrar');
    return this.http.get(this.urlBase+'/estudiantes/mostrar').pipe( //llamado al REST de STS!
      map(response => response as Estudiante[])
    );
  }
  getEstudianteListId(id:number): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
    console.log('Llamando a REST: '+ this.urlBase + '/estudiante/buscar/id');
    return this.http.get(this.urlBase+'/estudiante/buscar/id/'+id).pipe( //llamado al REST de STS!
      map(response => response as Estudiante)
    );
  }

  // ***** DISTRITO *****
  createDistrito(distrito: Object) : Observable<Object>{ //para crear en create-product
    return this.http.post(this.urlBase+'/distrito/registrar',distrito, {headers:this.httpHeaders}); //enviando el producto al REST de STS
  }
  getDistritoList(): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
    console.log('Llamando a REST: '+ this.urlBase + '/distritos/mostrar');
    return this.http.get(this.urlBase+'/distritos/mostrar').pipe( //llamado al REST de STS!
      map(response => response as Distrito[])
    );
  }
  getDistritos() : Observable<any>{
    console.log("Llamando a REST: " + this.urlBase+ "/distritos/mostrar");
    return this.http.get(this.urlBase+ "/distritos/mostrar").pipe(
       map(response => response as Distrito[])
    );   
  }

    // ***** SERVICIO *****

    createServicio(servicio: Object) : Observable<Object>{ //para crear en create-product
      return this.http.post(this.urlBase+'/servicio/registrar',servicio, {headers:this.httpHeaders}); //enviando el producto al REST de STS
    }

    getServicioList(): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
      console.log('Llamando a REST: '+ this.urlBase + '/servicios/mostrar');
      return this.http.get(this.urlBase+'/servicios/mostrar').pipe( //llamado al REST de STS!
        map(response => response as Servicio[])
      );
    }

    // ***** CONTRATO *****

    createContrato(contrato: Object) : Observable<Object>{ //para crear en create-product
      return this.http.post(this.urlBase+'/contrato/registrar',contrato, {headers:this.httpHeaders}); //enviando el producto al REST de STS
    }
    
    getContratoList(): Observable<any>{ //Para llamar a la lista de productos en product-list.components.ts
      console.log('Llamando a REST: '+ this.urlBase + '/contratos/mostrar');
      return this.http.get(this.urlBase+'/contratos/mostrar').pipe( //llamado al REST de STS!
        map(response => response as Contrato[])
      );
    }
  

}
