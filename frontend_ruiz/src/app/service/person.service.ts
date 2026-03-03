import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Person } from '../models/person.model';
import { ResponseDTO } from '../models/ResponseDTO';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  private baseUrl = 'http://localhost:8080/person';

  constructor(private http: HttpClient) {}

  consultarTodos(): Observable<Person[]> {
    return this.http
      .get<ResponseDTO>(`${this.baseUrl}/consultarTodos`)
      .pipe(map((res) => res.data as Person[]));
  }

  consultarPorId(id: number): Observable<Person> {
    return this.http
      .get<ResponseDTO>(`${this.baseUrl}/consultar/${id}`)
      .pipe(map((res) => res.data as Person));
  }

  guardar(person: Person): Observable<ResponseDTO> {
    return this.http.post<ResponseDTO>(`${this.baseUrl}/guardar`, person);
  }

  actualizar(person: Person): Observable<ResponseDTO> {
    return this.http.put<ResponseDTO>(`${this.baseUrl}/actualizar`, person);
  }

  eliminar(id: number): Observable<ResponseDTO> {
    return this.http.delete<ResponseDTO>(`${this.baseUrl}/eliminar/${id}`);
  }
}
